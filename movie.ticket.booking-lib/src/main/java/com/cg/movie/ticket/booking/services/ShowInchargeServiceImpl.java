package com.cg.movie.ticket.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movie.ticket.booking.dto.ShowDto;
import com.cg.movie.ticket.booking.entities.ShowInformation;
import com.cg.movie.ticket.booking.repository.ShowInformationRepository;

@Service
public class ShowInchargeServiceImpl implements ShowInchargeService{
	@Autowired
	ShowInformationRepository showrepo;
	
	@Override
	public int registerShowIncharge(ShowDto showdto) {
		ShowInformation incharge = new ShowInformation();
		incharge.setDate(showdto.getDate());
		return incharge.getShowid();
		
	}

	@Override
	public void addShowTiming(ShowInformation show) {
		showrepo.save(show);
		
	}

	@Override
	public List<ShowInformation> viewAllShows() {
		return showrepo.findAll();
	}

	@Override
	public void updateShowTimings(ShowInformation show) {
		showrepo.save(show);
		
	}

	@Override
	public void deleteShowTimings(int showid) {
		showrepo.deleteById(showid);
		
	}

	

}
