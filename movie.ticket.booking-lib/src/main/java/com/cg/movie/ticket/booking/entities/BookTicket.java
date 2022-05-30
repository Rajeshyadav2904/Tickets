package com.cg.movie.ticket.booking.entities;

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
@Table(name="BookingTicket")
public class BookTicket {
@Id
@SequenceGenerator(name = "book_seq",initialValue=1,sequenceName="book_code_seq",allocationSize=2)
@GeneratedValue(generator="book_seq",strategy = GenerationType.SEQUENCE)
private int bookingid;

@Column(name="noofticketsbooked",length=25)
private int noofticketsbooked;

@OneToOne
@JoinColumn(name = "userid")
private Users userid;

@OneToOne
@JoinColumn(name = "showid")
private ShowInformation showid;

public ShowInformation getShowid() {
	return showid;
}
public void setShowid(ShowInformation showid) {
	this.showid = showid;
}
public int getBookingid() {
	return bookingid;
}
public void setBookingid(int bookingid) {
	this.bookingid = bookingid;
}
public int getNoofticketsbooked() {
	return noofticketsbooked;
}
public void setNoofticketsbooked(int noofticketsbooked) {
	this.noofticketsbooked = noofticketsbooked;
}
public Users getUserid() {
	return userid;
}
public void setUserid(Users userid) {
	this.userid = userid;
}

}