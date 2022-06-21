package com.cg.movie.ticket.booking.services;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.cg.movie.ticket.booking.dto.BookDto;
import com.cg.movie.ticket.booking.dto.UserDto;
import com.cg.movie.ticket.booking.dto.ViewTicketDto;
import com.cg.movie.ticket.booking.entities.BookTicket;
import com.cg.movie.ticket.booking.entities.ShowInformation;
import com.cg.movie.ticket.booking.entities.Theatre;
import com.cg.movie.ticket.booking.entities.Users;
import com.cg.movie.ticket.booking.exceptions.InvalidBookingIdException;
import com.cg.movie.ticket.booking.exceptions.MovieNotFoundExceptions;
import com.cg.movie.ticket.booking.exceptions.ShowNotFoundExceptions;
import com.cg.movie.ticket.booking.exceptions.TheraterNotFoundException;
import com.cg.movie.ticket.booking.exceptions.UserNotFoundException;
import com.cg.movie.ticket.booking.repository.BookTicketRepository;
import com.cg.movie.ticket.booking.repository.ShowInformationRepository;
import com.cg.movie.ticket.booking.repository.TheatreRepository;
import com.cg.movie.ticket.booking.repository.UsersRepository;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UsersRepository userepo;
	@Autowired
	private TheatreRepository tetrepo;
	@Autowired
	private ShowInformationRepository showrepo;
	@Autowired
	private BookTicketRepository bookrepo;


		@Override
		public List<ShowInformation> searchShowByLocation(String location) {
			
			Theatre tet=tetrepo.getTetByName(location);
			
			if(tet==null) 
				throw new TheraterNotFoundException();
				
			
				
			return showrepo.getshowBytetName(tet.getTheatreid());
		
		}
		@Override
		public List<ShowInformation> searchShowByTheaterName(String theatrename) {
			
		Theatre tet	=tetrepo.getTtByName(theatrename);
		
			if(tet==null)
				throw new TheraterNotFoundException();
			
			return showrepo.getshowBytetName(tet.getTheatreid());
			
		
		}
		@Override
		public List<ShowInformation> searchShowByMoviename(String moviename) {
			
			List<ShowInformation> show=showrepo.getShowByMovie(moviename);
			
			if(show.isEmpty())
				throw new MovieNotFoundExceptions();
			return show;
		}
		
		@Override
		public ViewTicketDto viewBookedTickets(int bookingid) {
			BookTicket book=bookrepo.getById(bookingid);
			Users user=bookrepo.getUseById(bookingid);
			ShowInformation show=bookrepo.getshowById(bookingid);
			Theatre tet =show.getTet();
			if(book==null)
				throw new InvalidBookingIdException();
			
			ViewTicketDto vd=new ViewTicketDto();
			vd.setDate(show.getDate());
			vd.setTime(show.getTime());
	        vd.setUserid(user.getUserid());
	        vd.setUsername(user.getUsername());
	        vd.setMoviename(show.getMoviename());
			vd.setNoofticketsbooked(book.getNoofticketsbooked());
			vd.setTheatrename(tet.getTheatrename());
			vd.setLocation(tet.getLocation());
			
			return vd;
		}
		@Override
		public int registrationUser(UserDto userdto) {
			Users user = new Users();
			user.setUsername(userdto.getUsername());
			user.setPassword(userdto.getPassword());
			user.setEmail(userdto.getEmail());
			user.setMobilenumber(userdto.getMobilenumber());
			user.setRole(userdto.getRole());
			userepo.save(user);
			return user.getUserid();
		}
		@Override
		public String login(int userid, String password) {
			
		if(userepo.existsById(userid)) {

			
			if(userepo.getByPassword(userid).equals(password)) {
				userepo.getId(userid);
			System.out.println("user logged in");
			}
			else {
				System.out.println("user password not matched");
				}}
			else
				throw new UserNotFoundException();
			
	return null;
		}
		@Override
		public int bookingTickets(BookDto bookdto) {
			
			
			ShowInformation show=showrepo.getShowById(bookdto.getShowid());
		Users user=userepo.getById(bookdto.getUserid());
		
			if(bookdto.getNoofticketsbooked()<=(show.getTotalnooftickets()-show.getBookingcount())) {
			BookTicket book=new BookTicket();
			book.setNoofticketsbooked(bookdto.getNoofticketsbooked());
			book.setShow(show);
			book.setUser(user);
			bookrepo.save(book);
			show.setBookingcount(show.getBookingcount()+book.getNoofticketsbooked());
			showrepo.save(show);
			return book.getBookingid();
		}
		else {
			
			int x=show.getTotalnooftickets()-show.getBookingcount();
			System.out.println(" only tickets avaiable are  "+""+x);
		
		return 0;
		}}
		@Override
		public void cancelTickets(int bookingid) {
			BookTicket book=bookrepo.getById(bookingid);
			if(book==null)
				throw new InvalidBookingIdException();
			
			ShowInformation show=bookrepo.getshowById(bookingid);
			show.setBookingcount(show.getBookingcount()-book.getNoofticketsbooked());
			bookrepo.deleteById(bookingid);
			
			
		}
		

}
