package com.cg.movie.ticket.booking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Theatre")
public class Theatre {
	
@Id
@SequenceGenerator(name = "thearter_seq",initialValue=602022,sequenceName="thearter_code_seq",allocationSize=2)
@GeneratedValue(generator="thearter_seq",strategy = GenerationType.SEQUENCE)
private int theatreid;
@Column(name="theatrename",length=25)
private String theatrename;
@Column(name="location",length=25)
private String location;
@Column(name="screens",length=25)
private int screens;
@Column(name="totaltickets",length=25)
private int totaltickets;
public int getTheatreid() {
	return theatreid;
}
public void setTheatreid(int theatreid) {
	this.theatreid = theatreid;
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
public int getScreens() {
	return screens;
}
public void setScreens(int screens) {
	this.screens = screens;
}
public int getTotaltickets() {
	return totaltickets;
}
public void setTotaltickets(int totaltickets) {
	this.totaltickets = totaltickets;
}

}
