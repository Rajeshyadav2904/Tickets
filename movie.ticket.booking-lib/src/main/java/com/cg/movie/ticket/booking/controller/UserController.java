package com.cg.movie.ticket.booking.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.ticket.booking.dto.BookDto;
import com.cg.movie.ticket.booking.dto.UserDto;
import com.cg.movie.ticket.booking.dto.ViewTicketDto;
import com.cg.movie.ticket.booking.entities.ShowInformation;
import com.cg.movie.ticket.booking.services.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserServiceImpl service;

	@PostMapping
	public ResponseEntity<String> registrationUser(@RequestBody UserDto userdto){
		int userid = service.registrationUser(userdto);
		return new ResponseEntity<String>("inserted userid="+userid,HttpStatus.OK);
		
	}
	@GetMapping("/location/{location}")
	public ResponseEntity<List<ShowInformation>> search(@PathVariable String location)
	{
		List<ShowInformation> showlist=service.searchShowByLocation(location);
		return new ResponseEntity<List<ShowInformation>>(showlist,HttpStatus.OK);
	
	}
	@GetMapping("/moviename/{moviename}")
	public ResponseEntity<List<ShowInformation>> search1(@PathVariable String moviename)
	{
		List<ShowInformation> showlist=service.searchShowByMoviename(moviename);
		return new ResponseEntity<List<ShowInformation>>(showlist,HttpStatus.OK);
	
	}
	@GetMapping("/theatrename/{theatrename}")
	public ResponseEntity<List<ShowInformation>> search2(@PathVariable String theatrename)
	{
		List<ShowInformation> showlist=service.searchShowByTheaterName(theatrename);
		return new ResponseEntity<List<ShowInformation>>(showlist,HttpStatus.OK);
	
	}
	@GetMapping("/date/{date}")
	public ResponseEntity<List<ShowInformation>> search3(@PathVariable Date date)
	{
		List<ShowInformation> showlist=service.searchShowByDate(date);
		return new ResponseEntity<List<ShowInformation>>(showlist,HttpStatus.OK);
	
	}
	@GetMapping("/login/{userid}/{password}")
	public String login(@PathVariable int  userid,@PathVariable String password){
	return	service.login(userid, password);
	}
	@PostMapping("/booking/")
	public ResponseEntity<String> booking(@RequestBody BookDto bookdto){
		int bookingid=service.bookingTickets(bookdto);
		return new ResponseEntity<String>("booked bookingid= "+bookingid,HttpStatus.OK);
		
	}
	@GetMapping("/viewticket/{bookingid}")
	public ResponseEntity<ViewTicketDto> viewTicket(@PathVariable int bookingid){
		ViewTicketDto vd =service.viewBookedTickets(bookingid);
		return new  ResponseEntity<ViewTicketDto>(vd,HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{bookingid}")
	public ResponseEntity<String> cancelTicket(@PathVariable int bookingid){
		service.cancelTickets(bookingid);
		return new  ResponseEntity<String>("deleted",HttpStatus.OK);
		
	}
}
