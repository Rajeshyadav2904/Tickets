package com.cg.movie.ticket.booking.dto;

public class UserDto{
	private String username;
	private String password;
	private String email;
    private double mobilenumber;
    private String Role;
	private int userid;
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
	public double getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(double mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "UserDto [username=" + username + ", password=" + password + ", email=" + email + ", mobilenumber="
				+ mobilenumber + ", Role=" + Role + ", userid=" + userid + "]";
	}
	
}

