package com.cg.movie.ticket.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.ticket.booking.dto.ShowDto;
import com.cg.movie.ticket.booking.entities.ShowInformation;
import com.cg.movie.ticket.booking.services.ShowInchargeServiceImpl;

@RestController
@RequestMapping("/show")
public class ShowInchargeController {
	@Autowired
	private ShowInchargeServiceImpl showservice;
	
	@PostMapping()
	public ResponseEntity<String> registerShowIncharge(@RequestBody ShowDto showdto){
	int incharge = showservice.registerShowIncharge(showdto);
	return new ResponseEntity<String>("get showid ="+incharge, HttpStatus.OK);
	}
	

	@PostMapping("/add")
	public ResponseEntity<String> addShowTimings(@RequestBody ShowDto showdto){
	int incharge = showservice.registerShowIncharge(showdto);
	return new ResponseEntity<String>("get show timings ="+incharge, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ShowInformation>> getAllShows() {
		List<ShowInformation> showList = showservice.viewAllShows();
		return new ResponseEntity<List<ShowInformation>>(showList,HttpStatus.OK);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<String> editShowTimings(@RequestBody ShowInformation show){
		showservice.updateShowTimings(show);
		return new ResponseEntity<String>("updated",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteShowTimings(@PathVariable int showid){
		showservice.deleteShowTimings(showid);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}

}
