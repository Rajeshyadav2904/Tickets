package com.cg.movie.ticket.booking.services;

import java.util.List;

import com.cg.movie.ticket.booking.dto.ShowDto;
import com.cg.movie.ticket.booking.dto.TheatreDto;
import com.cg.movie.ticket.booking.dto.UserDto;
import com.cg.movie.ticket.booking.entities.ShowInformation;

public interface AdminService{
	int registerUser(UserDto userdto);
	int addTheatre(TheatreDto theatredto);
    int addMovies(ShowDto showdto);
	List<ShowInformation> viewAllMovies();
	void updateMovies(ShowInformation show);
	void deleteMovies(int showid);
	List<ShowInformation> viewShowDetails();
	List<ShowInformation> viewBookingCounts();
}