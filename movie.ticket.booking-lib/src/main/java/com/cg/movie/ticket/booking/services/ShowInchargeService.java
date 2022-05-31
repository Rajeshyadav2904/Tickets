package com.cg.movie.ticket.booking.services;

import java.util.List;
import java.util.Optional;

import com.cg.movie.ticket.booking.dto.ShowDto;
import com.cg.movie.ticket.booking.dto.UserDto;
import com.cg.movie.ticket.booking.entities.ShowInformation;
import com.cg.movie.ticket.booking.exceptions.ShowNotFoundExceptions;

public interface ShowInchargeService {
	
	int registerShowIncharge(UserDto s);
	 int addShowTimings(ShowDto show);
	 List<ShowInformation> viewAllShows();
	 int updateShowTimings(ShowDto show);
	 void deleteShowTimings(int showid);
	 Optional<ShowInformation> getShowById(int showid)throws ShowNotFoundExceptions;

}
