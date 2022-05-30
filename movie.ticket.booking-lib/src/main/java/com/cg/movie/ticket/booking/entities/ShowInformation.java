package com.cg.movie.ticket.booking.entities;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="ShowInformation")
public class ShowInformation {
@Id@SequenceGenerator(name = "show_seq",initialValue=92022,sequenceName="show_code_seq",allocationSize=2)
@GeneratedValue(generator="show_seq",strategy = GenerationType.SEQUENCE)
	private int showid;
@Column(name="moviename",length=25)
	private String moviename;
@Column(name="nooftickets",length=25)
	private int nooftickets;
@Column(name="date",length=25)
	private Date date;
@Column(name="bookingcount",length=25)
    private int bookingcount;

public int getBookingcount() {
	return bookingcount;
}

public void setBookingcount(int bookingcount) {
	this.bookingcount = bookingcount;
}

@OneToOne
@JoinColumn(name = "theatreid")
	private Theatre theatreid;

public int getShowid() {
	return showid;
}

public void setShowid(int showid) {
	this.showid = showid;
}

public String getMoviename() {
	return moviename;
}

public void setMoviename(String moviename) {
	this.moviename = moviename;
}

public int getNooftickets() {
	return nooftickets;
}

public void setNooftickets(int nooftickets) {
	this.nooftickets = nooftickets;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public Theatre getTheatreid() {
	return theatreid;
}

public void setTheatreid(Theatre theatreid) {
	this.theatreid = theatreid;
}
}






