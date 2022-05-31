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
	UsersRepository userepo;
	@Autowired
	TheatreRepository tetrepo;
	@Autowired
	ShowInformationRepository showrepo;
	@Autowired
	BookTicketRepository bookrepo;


		@Override
		public List<ShowInformation> searchShowByLocation(String location) {
			Theatre tet= tetrepo.getTetByLoc(location);
			if(tet.equals(null))
				throw new TheraterNotFoundException();
			List<ShowInformation> show=showrepo.getShowByTetId(tet.getTheatreid());
			return show;
		}
		@Override
		public List<ShowInformation> searchShowByTheaterName(String theatrename) {
			Theatre tet= tetrepo.getTetByName(theatrename);
			if(tet==null)
				throw new TheraterNotFoundException();
			List<ShowInformation> show=showrepo.getShowByTetId(tet.getTheatreid());
			
			return show;
		}
		@Override
		public List<ShowInformation> searchShowByMoviename(String moviename) {
			List<ShowInformation> show=showrepo.getShowByMovie(moviename);
			if(show.isEmpty())
				throw new MovieNotFoundExceptions();
			return show;
		}
		@Override
		public List<ShowInformation> searchShowByDate(Date date) {
			List<ShowInformation> show=showrepo.getShowByTimings(date);
			if(show.isEmpty())
				throw new ShowNotFoundExceptions();
			return show;
		}
		@Override
		public ViewTicketDto viewBookedTickets(int bookingid) {
			BookTicket book=bookrepo.getById(bookingid);
			if(book.equals(null))
				throw new InvalidBookingIdException();
			
			ViewTicketDto vd=new ViewTicketDto();
			vd.setUserid(bookrepo.getIdById(bookingid));
			vd.setUsername(userepo.getNameById(bookrepo.getIdById(bookingid)));
			vd.setMoviename(showrepo.getNameId(bookrepo.getSById(bookingid)));
			vd.setNoofticketsbooked(book.getNoofticketsbooked());
			vd.setTheatrename(tetrepo.getNameById(showrepo.getSId(bookrepo.getSById(bookingid))));
			vd.setLocation(tetrepo.getLocById(showrepo.getSId(bookrepo.getSById(bookingid))));
			
			return vd;
		}
		@Override
		public int registrationUser(UserDto userdto) {
			Users user = new Users();
			user.setUsername(userdto.getUsername());
			user.setPassword(userdto.getPassword());
			user.setEmail(userdto.getEmail());
			user.setRole(userdto.getRole());
			userepo.save(user);
			return user.getUserid();
		}
		@Override
		public String login(int userid, String password) {
			
		if(userepo.existsById(userid)) {

			
			if(userepo.getByPassword(userid).equals(password)) {
				Users user=userepo.getId(userid);
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
			bookrepo.save(book);
			show.setBookingcount(show.getBookingcount()+book.getBookingid());
			return book.getBookingid();
		}
		else {
			
			int x=show.getTotalnooftickets()-show.getBookingcount();
			System.out.println(" only tickets avaiable are  "+""+x);
		
		return 0;
		}}
		@Override
		public void cancelTickets(int bookingid) {
			if(bookrepo.getById(bookingid)==null)
				throw new InvalidBookingIdException();
			
			userepo.deleteById(bookingid);
			
		}
		

}
