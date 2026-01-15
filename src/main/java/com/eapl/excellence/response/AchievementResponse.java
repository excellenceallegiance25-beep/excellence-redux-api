package com.eapl.excellence.response;

public class AchievementResponse {

	private Integer id;
	private String title;
	private String value;
	private String description;
	private String icon;
	private String color;
	private String bgType;
	private String bgImage;
	private String bgPattern;

	public AchievementResponse() {
	}

	public AchievementResponse(Integer id, String title, String value, String description, String icon, String color,
			String bgType, String bgImage, String bgPattern) {
		this.id = id;
		this.title = title;
		this.value = value;
		this.description = description;
		this.icon = icon;
		this.color = color;
		this.bgType = bgType;
		this.bgImage = bgImage;
		this.bgPattern = bgPattern;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBgType() {
		return bgType;
	}

	public void setBgType(String bgType) {
		this.bgType = bgType;
	}

	public String getBgImage() {
		return bgImage;
	}

	public void setBgImage(String bgImage) {
		this.bgImage = bgImage;
	}

	public String getBgPattern() {
		return bgPattern;
	}

	public void setBgPattern(String bgPattern) {
		this.bgPattern = bgPattern;
	}

	@Override
	public String toString() {
		return "AchievementResponse [id=" + id + ", title=" + title + ", value=" + value + ", description="
				+ description + ", icon=" + icon + ", color=" + color + ", bgType=" + bgType + ", bgImage=" + bgImage
				+ ", bgPattern=" + bgPattern + "]";
	}

}
