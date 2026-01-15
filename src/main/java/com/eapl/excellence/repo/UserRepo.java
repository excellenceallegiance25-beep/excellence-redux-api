package com.eapl.excellence.repo;

import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eapl.excellence.request.PartnerDetailRequest;
import com.eapl.excellence.response.AchievementResponse;
import com.eapl.excellence.response.CommonResponse;
import com.eapl.excellence.response.EmployeeProfileResponse;
import com.eapl.excellence.response.EmployeeResponse;
import com.eapl.excellence.response.JobOpeningResponse;
import com.eapl.excellence.response.PartnerResponse;
import com.eapl.excellence.response.ServiceResponse;
import com.eapl.excellence.response.UserReviewResponse;

@Repository
public class UserRepo {
	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public UserRepo(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional
	public List<UserReviewResponse> getAllReviewDetails() {
		String sql = "SELECT * FROM fn_get_all_reviews()";

		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new UserReviewResponse(rs.getInt("id_text"), rs.getString("name_text"),
						rs.getString("position_text"), rs.getString("company_text"), rs.getString("comment_text"),
						rs.getInt("rating"), rs.getString("initials_text"), rs.getString("color_text")));
	}

	@Transactional
	public List<PartnerResponse> getAllPartnerDetails() {
		String sql = "SELECT * FROM fn_get_all_partners()";

		return jdbcTemplate.query(sql, (rs, rowNum) -> {

			String base64PartnerPicture = null;
			byte[] pictureBytes = rs.getBytes("partner_profile_picture");
			if (pictureBytes != null && pictureBytes.length > 0) {
				base64PartnerPicture = Base64.getEncoder().encodeToString(pictureBytes);
			}

			return new PartnerResponse(rs.getInt("id"), rs.getString("name"), rs.getString("type"),
					rs.getString("logo"), rs.getString("color"), rs.getString("email"), rs.getString("phone"),
					rs.getString("services"), rs.getBoolean("status"), base64PartnerPicture);
		});
	}

	@Transactional
	public List<JobOpeningResponse> getAllOpenings() {
		String sql = "SELECT * FROM fn_get_job_openings()";

		return jdbcTemplate.query(sql, (rs, rowNum) -> new JobOpeningResponse(rs.getInt("id"), rs.getString("title"),
				rs.getString("department"), rs.getString("location"), rs.getString("type")));
	}

	@Transactional
	public List<AchievementResponse> getAllAchievements() {
		String sql = "SELECT * FROM fn_get_achievements()";

		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new AchievementResponse(rs.getInt("id"), rs.getString("title"), rs.getString("value"),
						rs.getString("description"), rs.getString("icon"), rs.getString("color"),
						rs.getString("bg_type"), rs.getString("bg_image"), rs.getString("bg_pattern")));
	}

	@Transactional
	public List<EmployeeResponse> getAllEmployees() {
		String sql = "SELECT * FROM fn_get_all_employees()";

		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new EmployeeResponse(rs.getInt("id"), rs.getString("name"), rs.getString("role"),
						rs.getString("avatar"), rs.getString("bio"), rs.getString("full_bio"),
						rs.getString("expertise"), rs.getString("linkedin"), rs.getString("education")));
	}

//	@Transactional
//	public List<EmployeeResponse> getAllEmployees() throws SQLException {
//
//		final String sql = "SELECT * FROM fn_get_all_employees()";
//
//		try {
//			return jdbcTemplate.query(sql,
//					(rs, rowNum) -> new EmployeeResponse(rs.getInt("id"), rs.getString("name"), rs.getString("role"),
//							rs.getString("avatar"), rs.getString("bio"), rs.getString("full_bio"),
//							rs.getString("expertise"), rs.getString("linkedin"), rs.getString("education")));
//		} catch (DataAccessException | IllegalArgumentException e) {
//			throw new SQLException(e);
//		}
//	}

	@Transactional
	public List<EmployeeProfileResponse> getUserDetails(String email, String password) {
		try {
			String sql = "SELECT * FROM fn_get_login_user_details(:p_email, :p_password)";

			Map<String, Object> params = new HashMap<>();

			params.put("p_email", email);
			params.put("p_password", password);

			return jdbcTemplate.query(sql, params, (rs, rowNum) -> {
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
	public List<CommonResponse> forgotPasswordOTPDetails(String email, String otp) {

		String sql = "SELECT * FROM fn_forgot_password_otp_verification(:p_email, :p_otp)";

		Map<String, Object> params = new HashMap<>();
		params.put("p_email", email);
		params.put("p_otp", otp);

		return jdbcTemplate.query(sql, params,
				(rs, rowNum) -> new CommonResponse(rs.getBoolean("status"), rs.getString("message"), null, null));
	}

	@Transactional
	public List<CommonResponse> resetPasswordDetails(String email, String newPassword) {

		String sql = "SELECT * FROM fn_reset_forgot_password(:p_email, :p_new_password)";

		Map<String, Object> params = new HashMap<>();
		params.put("p_email", email);
		params.put("p_new_password", newPassword);

		return jdbcTemplate.query(sql, params,
				(rs, rowNum) -> new CommonResponse(rs.getBoolean("status"), rs.getString("message"), null, null));
	}

	@Transactional
	public List<CommonResponse> updatePartnerRequestDetails(PartnerDetailRequest request) {
		try {
			// Convert Base64 profile picture to byte array if provided
			byte[] profileBytes = null;
			if (request.getProfilePicture() != null && !request.getProfilePicture().isEmpty()) {
				// Remove data URL prefix if present
				String base64Image = request.getProfilePicture();
				if (base64Image.contains(",")) {
					base64Image = base64Image.split(",")[1];
				}
				profileBytes = Base64.getDecoder().decode(base64Image);
			}

			String sql = "SELECT * FROM fn_update_partner_details("
					+ ":p_operation, :p_id, :p_name, :p_profile_picture, "
					+ ":p_profile_picture_type, :p_color, :p_phone, :p_services, "
					+ ":p_emails, :p_type, :p_logo, :p_status)";

			Map<String, Object> params = new HashMap<>();
			params.put("p_operation", request.getIndicator());
			params.put("p_id", request.getId());
			params.put("p_name", request.getName());
			params.put("p_profile_picture", profileBytes);
			params.put("p_profile_picture_type", request.getProfilePictureType());
			params.put("p_color", request.getColor());
			params.put("p_phone", request.getPhone());
			params.put("p_services", request.getServices());
			params.put("p_emails", request.getEmail());
			params.put("p_type", request.getType());
			params.put("p_logo", request.getLogo());
			params.put("p_status", request.isStatus());

			return jdbcTemplate.query(sql, params, (rs, rowNum) -> {
				Boolean success = rs.getBoolean("success");
				String message = rs.getString("message");
				String operation = rs.getString("operations");

				// Create ServiceResponse object
				PartnerResponse serviceResponse = null;

				String base64PartnerPicture = null;
				byte[] pictureBytes = rs.getBytes("partner_profile_picture");
				if (pictureBytes != null && pictureBytes.length > 0) {
					base64PartnerPicture = Base64.getEncoder().encodeToString(pictureBytes);
				}

				// Check if service data is available
				Integer serviceId = rs.getObject("partner_id", Integer.class);
				if (serviceId != null) {
					serviceResponse = new PartnerResponse(serviceId, rs.getString("partner_name"),
							rs.getString("partner_type"), rs.getString("partner_logo"), rs.getString("partner_color"),
							rs.getString("partner_email"), rs.getString("partner_phone"),
							rs.getString("partner_services"), rs.getBoolean("partner_status"), base64PartnerPicture);
				}

				List<PartnerResponse> dataList = Collections.singletonList(serviceResponse);

				return new CommonResponse(success, message, "partner_operation", dataList);
			});
		} catch (Exception e) {
			return (List<CommonResponse>) new CommonResponse(false, "Error: " + e.getMessage(), "error", null);
		}
	}

}