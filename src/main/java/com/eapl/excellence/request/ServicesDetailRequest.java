package com.eapl.excellence.request;

public class ServicesDetailRequest {

	private String indicator;
	private Integer id;
	private String title;
	private String description;
	private String icon;
	private String icon_type;
	private String color;
	private String features;
	private String bg_type;
	private String category;
	private String details;
	private String price;
	private String duration;
	private Boolean status;

	public ServicesDetailRequest() {
	}

	public ServicesDetailRequest(String indicator, Integer id, String title, String description, String icon,
			String color, String features, String bg_type, String category, String details, String price,
			String duration, Boolean status) {
		super();
		this.indicator = indicator;
		this.id = id;
		this.title = title;
		this.description = description;
		this.icon = icon;
		this.color = color;
		this.features = features;
		this.bg_type = bg_type;
		this.category = category;
		this.details = details;
		this.price = price;
		this.duration = duration;
		this.status = status;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
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

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getBg_type() {
		return bg_type;
	}

	public void setBg_type(String bg_type) {
		this.bg_type = bg_type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ServicesDetailRequest [indicator=" + indicator + ", id=" + id + ", title=" + title + ", description="
				+ description + ", icon=" + icon + ", color=" + color + ", features=" + features + ", bg_type="
				+ bg_type + ", category=" + category + ", details=" + details + ", price=" + price + ", duration="
				+ duration + ", status=" + status + "]";
	}

}
