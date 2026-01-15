package com.eapl.excellence.repo;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eapl.excellence.request.ProfileUpdateRequest;
import com.eapl.excellence.request.RegistrationRequest;
import com.eapl.excellence.response.CommonResponse;
import com.eapl.excellence.response.EmployeeHistoryResponse;
import com.eapl.excellence.response.EmployeeProfileResponse;
import com.eapl.excellence.response.EmployeeSkillResponse;
import com.eapl.excellence.utilities.XmlConverter;

@Repository
public class ProfileRepo {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public ProfileRepo(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional
	public List<EmployeeProfileResponse> getAllProfiles() {
		try {
			String sql = "SELECT * FROM fn_get_all_employee_profiles()";

			return jdbcTemplate.query(sql, (rs, rowNum) -> {
				byte[] profilePictureBytes = rs.getBytes("profile_picture");
				String profilePictureBase64 = (profilePictureBytes != null)
						? Base64.getEncoder().encodeToString(profilePictureBytes)
						: null;

				return new EmployeeProfileResponse(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("phone"), rs.getString("title"), rs.getString("company"), rs.getString("location"),
						rs.getString("bio"), rs.getString("education"), rs.getString("website"), rs.getString("github"),
						rs.getString("linkedin"), rs.getString("joined_date"), rs.getBoolean("status"),
						rs.getString("role"), rs.getString("role_type"), rs.getBoolean("notifications_email"),
						rs.getBoolean("notifications_push"), rs.getBoolean("notifications_marketing"),
						rs.getBoolean("notifications_security"), rs.getBoolean("two_factor_enabled"),
						rs.getString("last_profile_update"), rs.getString("created_at"), rs.getString("updated_at"),
						rs.getString("password"), profilePictureBase64, rs.getString("profile_picture_type"),
						rs.getString("department"), rs.getString("position"), null, null);
			});

		} catch (Exception e) {
			throw new RuntimeException("Failed to update complete profile: " + e.getMessage(), e);
		}
	}

	@Transactional
	public List<EmployeeSkillResponse> getAllSkills() {

		String sql = "SELECT * FROM fn_get_all_employee_skills()";

		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new EmployeeSkillResponse(rs.getInt("id"), rs.getInt("employee_id"),
						rs.getString("skill_name"), rs.getString("level"), rs.getInt("years_experience"),
						rs.getString("updated_at")));
	}

	@Transactional
	public List<EmployeeHistoryResponse> getAllHistory() {

		String sql = "SELECT * FROM fn_get_all_employee_update_history()";

		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new EmployeeHistoryResponse(rs.getInt("id"), rs.getInt("employee_id"),
						rs.getString("field_name"), rs.getString("action"), rs.getString("timestamp"),
						rs.getString("status")));
	}

	@Transactional
	public Map<String, Object> updateCompleteProfile(ProfileUpdateRequest request) {
		Map<String, Object> result = new HashMap<>();

		try {
			// Convert Base64 profile picture to byte array if provided
			byte[] profilePictureBytes = null;
			if (request.getProfilePicture() != null && !request.getProfilePicture().isEmpty()) {
				// Remove data URL prefix if present
				String base64Image = request.getProfilePicture();
				if (base64Image.contains(",")) {
					base64Image = base64Image.split(",")[1];
				}
				profilePictureBytes = Base64.getDecoder().decode(base64Image);
			}

			String sql = "SELECT * FROM fn_update_complete_employee_profile_new("
					+ ":p_employee_id, :p_name, :p_email, :p_phone, :p_title, :p_company, "
					+ ":p_location, :p_bio, :p_education, :p_website, :p_github, :p_linkedin, "
					+ ":p_status, :p_role, :p_role_type, :p_notifications_email, :p_notifications_push, "
					+ ":p_notifications_marketing, :p_notifications_security, :p_two_factor_enabled, "
					+ ":p_skills_xml, :p_current_password, :p_new_password, "
					+ ":p_profile_picture, :p_profile_picture_type,:p_profile_department,:p_profile_position,:p_operation_indicator)";

			Map<String, Object> params = new HashMap<>();

			// Required parameter
			params.put("p_employee_id", request.getId());

			// Profile parameters
			params.put("p_name", request.getName());
			params.put("p_email", request.getEmail());
			params.put("p_phone", request.getPhone());
			params.put("p_title", request.getTitle());
			params.put("p_company", request.getCompany());
			params.put("p_location", request.getLocation());
			params.put("p_bio", request.getBio());
			params.put("p_education", request.getEducation());
			params.put("p_website", request.getWebsite());
			params.put("p_github", request.getGithub());
			params.put("p_linkedin", request.getLinkedin());
			params.put("p_status", request.isStatus());
			params.put("p_role", request.getRole());
			params.put("p_role_type", request.getRoleType());

			// Settings
			params.put("p_notifications_email", request.getNotificationsEmail());
			params.put("p_notifications_push", request.getNotificationsPush());
			params.put("p_notifications_marketing", request.getNotificationsMarketing());
			params.put("p_notifications_security", request.getNotificationsSecurity());
			params.put("p_two_factor_enabled", request.getTwoFactorEnabled());

			// Skills XML - using your generic XmlConverter
			String skillsXml = null;
			if (request.getSkills() != null && !request.getSkills().isEmpty()) {
				skillsXml = XmlConverter.convertListToXml(request.getSkills(), "skills", "skill");
			}
			params.put("p_skills_xml", skillsXml);

			// Password
			params.put("p_current_password", request.getCurrentPassword());
			params.put("p_new_password", request.getNewPassword());

			// Profile picture
			params.put("p_profile_picture", profilePictureBytes);
			params.put("p_profile_picture_type", request.getProfilePictureType());

			params.put("p_profile_department", request.getDepartment());
			params.put("p_profile_position", request.getPosition());
			params.put("p_operation_indicator", request.getIndicator());

			// Execute SQL function
			List<EmployeeProfileResponse> updatedProfile = jdbcTemplate.query(sql, params, (rs, rowNum) -> {

				// Handle nullable fields
				int empId = rs.getInt("emp_id");
				if (rs.wasNull())
					empId = 0; // or whatever default you prefer

				String lastProfileUpdate = rs.getString("emp_last_profile_update");
				String createdAt = rs.getString("emp_created_at");
				String updatedAt = rs.getString("emp_updated_at");

				// Handle profile picture
				String base64ProfilePicture = null;
				byte[] pictureBytes = rs.getBytes("emp_profile_picture");
				if (pictureBytes != null && pictureBytes.length > 0) {
					base64ProfilePicture = Base64.getEncoder().encodeToString(pictureBytes);
				}

				return new EmployeeProfileResponse(empId, rs.getString("emp_name"), rs.getString("emp_email"),
						rs.getString("emp_phone"), rs.getString("emp_title"), rs.getString("emp_company"),
						rs.getString("emp_location"), rs.getString("emp_bio"), rs.getString("emp_education"),
						rs.getString("emp_website"), rs.getString("emp_github"), rs.getString("emp_linkedin"),
						rs.getString("emp_joined_date"), rs.getBoolean("emp_status"), rs.getString("emp_role"),
						rs.getString("emp_role_type"), rs.getBoolean("emp_notifications_email"),
						rs.getBoolean("emp_notifications_push"), rs.getBoolean("emp_notifications_marketing"),
						rs.getBoolean("emp_notifications_security"), rs.getBoolean("emp_two_factor_enabled"),
						rs.getString("emp_last_profile_update"), rs.getString("emp_created_at"),
						rs.getString("emp_updated_at"), rs.getString("emp_password"), base64ProfilePicture,
						rs.getString("emp_profile_picture_type"), rs.getString("emp_profile_department"),
						rs.getString("emp_profile_position"), rs.getString("operation_result"),
						rs.getString("message"));
			});

			result.put("success", true);
			result.put("message", updatedProfile.get(0).getOperationMessage());
			result.put("type", updatedProfile.get(0).getOperationResult());
			result.put("data", updatedProfile);

			return result;

		} catch (Exception e) {
			result.put("success", false);
			result.put("message", e.getMessage());
			result.put("type", "EMP_COMPLETE_PROFILE_UPDATE_FAILURE");
			return result;
//			throw new RuntimeException("Failed to update complete profile: " + e.getMessage(), e);
		}
	}

	@Transactional
	public List<CommonResponse> addNewUserDetails(RegistrationRequest request) {

		String sql = "SELECT * FROM fn_employee_registration_profile("
				+ ":p_employee_id, :p_first_name, :p_last_name, :p_email, " + ":p_company_name, :p_phone, :p_password, "
				+ ":p_confirm_password, :p_agree_term_and_condition)";

		Map<String, Object> params = new HashMap<>();

		params.put("p_employee_id", request.getEmployeeId());
		params.put("p_first_name", request.getFirstname());
		params.put("p_last_name", request.getLastname());
		params.put("p_email", request.getEmail());
		params.put("p_phone", request.getPhone());
		params.put("p_company_name", request.getCompany());
		params.put("p_password", request.getNewPassword());
		params.put("p_confirm_password", request.getCurrentPassword());
		params.put("p_agree_term_and_condition", true);

		return jdbcTemplate.query(sql, params,
				(rs, rowNum) -> new CommonResponse(rs.getBoolean("status"), rs.getString("message"), null, null));
	}

}
