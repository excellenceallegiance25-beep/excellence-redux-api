package com.eapl.excellence.response;

public class UserReviewResponse {

	 private Integer id;
	    private String name;
	    private String position;
	    private String company;
	    private String comment_text;
	    private Integer rating;
	    private String initials;
	    private String color;

	    public UserReviewResponse() {}

		public UserReviewResponse(Integer id, String name, String position, String company, String comment_text,
				Integer rating, String initials, String color) {
			super();
			this.id = id;
			this.name = name;
			this.position = position;
			this.company = company;
			this.comment_text = comment_text;
			this.rating = rating;
			this.initials = initials;
			this.color = color;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getComment_text() {
			return comment_text;
		}

		public void setComment_text(String comment_text) {
			this.comment_text = comment_text;
		}

		public Integer getRating() {
			return rating;
		}

		public void setRating(Integer rating) {
			this.rating = rating;
		}

		public String getInitials() {
			return initials;
		}

		public void setInitials(String initials) {
			this.initials = initials;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		@Override
		public String toString() {
			return "UserReviewResponse [id=" + id + ", name=" + name + ", position=" + position + ", company=" + company
					+ ", comment_text=" + comment_text + ", rating=" + rating + ", initials=" + initials + ", color="
					+ color + "]";
		}
	    
	    

}
