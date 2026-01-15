package com.eapl.excellence.repo;

import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eapl.excellence.request.EmpLeaveRequest;
import com.eapl.excellence.request.ServicesDetailRequest;
import com.eapl.excellence.response.CommonDetailResponse;
import com.eapl.excellence.response.CommonResponse;
import com.eapl.excellence.response.ServiceResponse;
import com.eapl.excellence.utilities.Utility;

@Repository
public class ServiceRepo {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	private final Utility utility;

	@Autowired
	public ServiceRepo(NamedParameterJdbcTemplate jdbcTemplate, Utility utility) {
		this.jdbcTemplate = jdbcTemplate;
		this.utility = utility;
	}

	public List<ServiceResponse> getAllServices() {
        String sql = "SELECT * FROM fn_get_all_services()";
        
        try {
            return jdbcTemplate.query(sql, Collections.emptyMap(), (rs, rowNum) -> {
                // Handle profile picture SAFELY
                String base64ServicePicture = null;
                try {
                    byte[] pictureBytes = rs.getBytes("icon");
                    if (pictureBytes != null && pictureBytes.length > 0) {
                        base64ServicePicture = Base64.getEncoder().encodeToString(pictureBytes);
                    }
                } catch (Exception e) {
                    // Log error but continue
                    System.err.println("Error processing icon: " + e.getMessage());
                }
                
                return new ServiceResponse(
                    rs.getInt("id"), 
                    rs.getString("title"), 
                    rs.getString("description"),
                    base64ServicePicture, 
                    rs.getString("color"), 
                    rs.getString("features"), 
                    rs.getString("bg_type"),
                    rs.getString("category"), 
                    rs.getString("details"), 
                    rs.getString("price"), 
                    rs.getString("duration"),
                    rs.getBoolean("status")
                );
            });
        } catch (DataAccessException e) {
            // Log and rethrow
            System.err.println("Database error in getAllServices: " + e.getMessage());
            throw new RuntimeException("Database error", e);
        }
    }

	public List<CommonDetailResponse> getAllRoleDetails() {
		String sql = "SELECT * FROM roles";

		return jdbcTemplate.query(sql, (rs, rowNum) -> new CommonDetailResponse(rs.getInt("id"), rs.getString("name"),
				rs.getString("abbreviation"), rs.getString("description"), rs.getBoolean("status")));
	}

	public List<CommonDetailResponse> getAllDepartmentDetails() {
		String sql = "SELECT * FROM departments";

		return jdbcTemplate.query(sql, (rs, rowNum) -> new CommonDetailResponse(rs.getInt("id"), rs.getString("name"),
				rs.getString("abbreviation"), rs.getString("description"), rs.getBoolean("status")));
	}

	public List<CommonDetailResponse> getAllPositionDetails() {
		String sql = "SELECT * FROM positions";

		return jdbcTemplate.query(sql, (rs, rowNum) -> new CommonDetailResponse(rs.getInt("id"), rs.getString("name"),
				rs.getString("abbreviation"), rs.getString("description"), rs.getBoolean("status")));
	}

	@Transactional
	public List<CommonResponse> updateServiceRequestDetails(ServicesDetailRequest request) {
		try {
			// Convert Base64 profile picture to byte array if provided
			byte[] serviceIconBytes = null;
			if (request.getIcon() != null && !request.getIcon().isEmpty()) {
				// Remove data URL prefix if present
				String base64Image = request.getIcon();
				if (base64Image.contains(",")) {
					base64Image = base64Image.split(",")[1];
				}
				serviceIconBytes = Base64.getDecoder().decode(base64Image);
			}

			String sql = "SELECT * FROM fn_manage_service_details(" + ":p_operation, :p_id, :p_title, :p_description, "
					+ ":p_icon, :p_color, :p_features, :p_bg_type, "
					+ ":p_category, :p_details, :p_price, :p_duration, " + ":p_status)";

			Map<String, Object> params = new HashMap<>();
			params.put("p_operation", request.getIndicator());
			params.put("p_id", request.getId());
			params.put("p_title", request.getTitle());
			params.put("p_description", request.getDescription());
			params.put("p_icon", serviceIconBytes);
			params.put("p_color", request.getColor());
			params.put("p_features", request.getFeatures());
			params.put("p_bg_type", request.getBg_type());
			params.put("p_category", request.getCategory());
			params.put("p_details", request.getDetails());
			params.put("p_price", request.getPrice());
			params.put("p_duration", request.getDuration());
			params.put("p_status", request.getStatus());

			return jdbcTemplate.query(sql, params, (rs, rowNum) -> {
				Boolean success = rs.getBoolean("success");
				String message = rs.getString("message");
				String operation = rs.getString("operations");

				// Create ServiceResponse object
				ServiceResponse serviceResponse = null;

				String base64ServicePicture = null;
				byte[] pictureBytes = rs.getBytes("service_icon");
				if (pictureBytes != null && pictureBytes.length > 0) {
					base64ServicePicture = Base64.getEncoder().encodeToString(pictureBytes);
				}

				// Check if service data is available
				Integer serviceId = rs.getObject("service_id", Integer.class);
				if (serviceId != null) {
					serviceResponse = new ServiceResponse(serviceId, rs.getString("service_title"),
							rs.getString("service_description"), base64ServicePicture, rs.getString("service_color"),
							rs.getString("service_features"), rs.getString("service_bg_type"),
							rs.getString("service_category"), rs.getString("service_details"),
							rs.getString("service_price"), rs.getString("service_duration"),
							rs.getBoolean("service_status"));
				}

				List<ServiceResponse> dataList = Collections.singletonList(serviceResponse);

				return new CommonResponse(success, message, "service_operation", dataList);
			});
		} catch (Exception e) {
			return (List<CommonResponse>) new CommonResponse(false, "Error: " + e.getMessage(), "error", null);
		}
	}

}
