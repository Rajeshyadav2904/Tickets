package com.cg.movie.ticket.booking.dto;

import java.sql.Time;
import java.util.Date;

public class ShowDto {
	private String moviename;
	private Date date;
	private int totalnooftickets;
	private int bookingcount;
	private int theatreid;
    private String time;
    private int showid;
	
	
	public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	
	public int getTotalnooftickets() {
		return totalnooftickets;
	}
	public void setTotalnooftickets(int totalnooftickets) {
		this.totalnooftickets = totalnooftickets;
	}
	public int getBookingcount() {
		return bookingcount;
	}
	public void setBookingcount(int bookingcount) {
		this.bookingcount = bookingcount;
	}
	public int getTheatreid() {
		return theatreid;
	}
	public void setTheatreid(int theatreid) {
		this.theatreid = theatreid;
	}
	public int getShowid() {
		return showid;
	}
	public void setShowid(int showid) {
		this.showid = showid;
	}
	@Override
	public String toString() {
		return "ShowDto [moviename=" + moviename + ", date=" + date + ", totalnooftickets=" + totalnooftickets
				+ ", bookingcount=" + bookingcount + ", theatreid=" + theatreid + ", time=" + time + ", showid="
				+ showid + "]";
	}
	
	
	
}
	