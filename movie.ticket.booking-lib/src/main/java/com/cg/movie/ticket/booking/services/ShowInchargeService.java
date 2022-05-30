package com.cg.movie.ticket.booking.services;

import java.util.List;

import com.cg.movie.ticket.booking.dto.ShowDto;
import com.cg.movie.ticket.booking.entities.ShowInformation;

public interface ShowInchargeService {
	
	 int registerShowIncharge(ShowDto showdto);
	 void addShowTiming(ShowInformation show);
	 List<ShowInformation> viewAllShows();
	 void updateShowTimings(ShowInformation show);
	 void deleteShowTimings(int showid);

}
