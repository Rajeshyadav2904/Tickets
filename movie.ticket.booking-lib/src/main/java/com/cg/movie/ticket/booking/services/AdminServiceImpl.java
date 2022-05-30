package com.cg.movie.ticket.booking.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movie.ticket.booking.dto.ShowDto;
import com.cg.movie.ticket.booking.dto.TheatreDto;
import com.cg.movie.ticket.booking.dto.UserDto;
import com.cg.movie.ticket.booking.entities.ShowInformation;
import com.cg.movie.ticket.booking.entities.Theatre;
import com.cg.movie.ticket.booking.entities.Users;
import com.cg.movie.ticket.booking.repository.ShowInformationRepository;
import com.cg.movie.ticket.booking.repository.TheatreRepository;

import com.cg.movie.ticket.booking.repository.UsersRepository;



   @Service
    public class AdminServiceImpl implements AdminService{
    @Autowired
    ShowInformationRepository showrepo;
    @Autowired
    UsersRepository userrepo;
    @Autowired
    TheatreRepository theatrerepo;
    
	@Override
	public int addMovies(ShowDto showdto) {  
		    Theatre t1 = theatrerepo.getTheaterById(showdto.getTheatreid());
		    ShowInformation admin = new ShowInformation();
		    admin.setTheatreid(t1);
		    admin.setMoviename(showdto.getMoviename());
		    admin.setDate(showdto.getDate());
		    admin.setTotalnooftickets(showdto.getTotalnooftickets());
		    admin.setBookingcount(showdto.getBookingcount());
		    showrepo.save(admin);
			return admin.getShowid();	    
   }
	
	@Override
	public int registerUser(UserDto userdto) {
		 Users admin = new Users();
		 
		 admin.setMobilenumber(userdto.getMobilenumber());
		 admin.setEmail(userdto.getEmail());
		 admin.setPassword(userdto.getPassword());
		 admin.setRole(userdto.getRole());
		 userrepo.save(admin);
	     return admin.getUserid();
	}
	
	@Override
	public List<ShowInformation> viewAllMovies() {
		return showrepo.findAll();
	}

	@Override
	public void updateMovies(ShowInformation show) {
		 showrepo.save(show);
		
	}

	@Override
	public void deleteMovies(int showid) {
		 showrepo.deleteById(showid);	
		
	}

	@Override
	public List<ShowInformation> viewShowDetails() {
		return showrepo.findAll();
	}

	@Override
	public List<ShowInformation> viewBookingCounts() {
		return showrepo.findAll();
	  }

	@Override
	public int addTheatre(TheatreDto theatredto) {
		Theatre t1= new Theatre();
		t1.setTheatrename(theatredto.getTheatrename());
		t1.setLocation(theatredto.getLocation());
		theatrerepo.save(t1);
		return t1.getTheatreid();
	}
	
	}	
   
    
    