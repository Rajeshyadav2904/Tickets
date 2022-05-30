package com.cg.movie.ticket.booking.services;

import java.util.Date;
import java.util.List;

import com.cg.movie.ticket.booking.dto.BookDto;
import com.cg.movie.ticket.booking.dto.UserDto;
import com.cg.movie.ticket.booking.dto.ViewTicketDto;
import com.cg.movie.ticket.booking.entities.ShowInformation;

public interface UserService {
int registrationUser(UserDto userdto);
	
	List<ShowInformation> searchShowByLocation(String location);
	
	List<ShowInformation> searchShowByTheaterName(String theatrename);
	List<ShowInformation> searchShowByMoviename(String moviename);
	List<ShowInformation> searchShowByDate(Date date);
	String login(int userid,String password);
	ViewTicketDto viewBookedTickets(int bookingid);
	int  bookingTickets(BookDto bookdto);
	void cancelTickets(int bookingid);

}
