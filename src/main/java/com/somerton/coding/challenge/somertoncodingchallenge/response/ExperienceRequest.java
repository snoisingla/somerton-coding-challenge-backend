package com.somerton.coding.challenge.somertoncodingchallenge.response;

public class ExperienceRequest {

		private String email;
		private String name;
		private String location;
		private String photoUrl;
		
		public ExperienceRequest(String email, String name, String location, String photoUrl) {
			super();
			this.email = email;
			this.name = name;
			this.location = location;
			this.photoUrl = photoUrl;
		}
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getPhotoUrl() {
			return photoUrl;
		}
		public void setPhotoUrl(String photoUrl) {
			this.photoUrl = photoUrl;
		}
		
		
		
}
