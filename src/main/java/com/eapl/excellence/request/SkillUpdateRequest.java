package com.eapl.excellence.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SkillUpdateRequest {

	private Integer id;
	private String level;
	private Integer yearsExperience;
	private String updatedAt;

	SkillUpdateRequest() {
	}

	public SkillUpdateRequest(Integer id, String level, Integer yearsExperience, String updatedAt) {
		super();
		this.id = id;
		this.level = level;
		this.yearsExperience = yearsExperience;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "SkillUpdateRequest [id=" + id + ", level=" + level + ", yearsExperience=" + yearsExperience
				+ ", updatedAt=" + updatedAt + "]";
	}

}
