package com.cg.movie.ticket.booking.dto;

public class UserDto{
	private String username;
	private String password;
	private String email;
	private String role;

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private long mobilenumber;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	@Override
	public String toString() {
		return "UserDto [username=" + username + ", password=" + password + ", email=" + email + ", role=" + role
				+ ", mobilenumber=" + mobilenumber + "]";
	}
	
}

