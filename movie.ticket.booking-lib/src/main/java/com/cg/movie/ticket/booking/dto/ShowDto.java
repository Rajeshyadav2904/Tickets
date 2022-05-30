package com.cg.movie.ticket.booking.dto;

import java.util.Date;

public class ShowDto {
	 
	
    private String moviename;
    private Date date;
    private int nooftickets;
    private int bookingcount;
    private int theatreid;
    private int showid;
   
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNooftickets() {
		return nooftickets;
	}


	public int getTheatreid() {
		return theatreid;
	}
	public void setTheatreid(int theatreid) {
		this.theatreid = theatreid;
	}
	public void setNooftickets(int nooftickets) {
		this.nooftickets = nooftickets;
	}
	public int getBookingcount() {
		return bookingcount;
	}
	public void setBookingcount(int bookingcount) {
		this.bookingcount = bookingcount;
	}
	
	public int getShowid() {
		return showid;
	}
	public void setShowid(int showid) {
		this.showid = showid;
	}
	@Override
	public String toString() {
		return "ShowDto [moviename=" + moviename + ", date=" + date + ", nooftickets=" + nooftickets + ", bookingcount="
				+ bookingcount + ", theatreid=" + theatreid + ", showid=" + showid + "]";
	}
	
}
	