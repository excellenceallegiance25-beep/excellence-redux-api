package com.eapl.excellence.request;

public class SkillAddRequest {

	private Integer employeeId;
	private String skillName;
	private String level;
	private Integer yearsExperience;
	private String updatedAt;

	SkillAddRequest() {
	}

	public SkillAddRequest(Integer employeeId, String skillName, String level, Integer yearsExperience,
			String updatedAt) {
		super();
		this.employeeId = employeeId;
		this.skillName = skillName;
		this.level = level;
		this.yearsExperience = yearsExperience;
		this.updatedAt = updatedAt;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Integer getYearsExperience() {
		return yearsExperience;
	}

	public void setYearsExperience(Integer yearsExperience) {
		this.yearsExperience = yearsExperience;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "SkillAddRequest [employeeId=" + employeeId + ", skillName=" + skillName + ", level=" + level
				+ ", yearsExperience=" + yearsExperience + ", updatedAt=" + updatedAt + "]";
	}

}
