package com.cg.movie.ticket.booking.dto;

public class ViewTicketDto {
	private int  userid;
	private String username;
	private String moviename;

	private int noofticketsbooked;
	private String theatrename;
	private String location;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public int getNoofticketsbooked() {
		return noofticketsbooked;
	}
	public void setNoofticketsbooked(int noofticketsbooked) {
		this.noofticketsbooked = noofticketsbooked;
	}
	public String getTheatrename() {
		return theatrename;
	}
	public void setTheatrename(String theatrename) {
		this.theatrename = theatrename;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "ViewTicketDto [userid=" + userid + ", username=" + username + ", moviename=" + moviename
				+ ", noofticketsbooked=" + noofticketsbooked + ", theatrename=" + theatrename + ", location=" + location
				+ "]";
	}
}
