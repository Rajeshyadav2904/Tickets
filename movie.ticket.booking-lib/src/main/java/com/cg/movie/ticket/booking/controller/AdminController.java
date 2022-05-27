package com.cg.movie.ticket.booking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.ticket.booking.entities.UserEntity;
import com.cg.movie.ticket.booking.exceptions.ResourceNotFoundExecption;
import com.cg.movie.ticket.booking.exceptions.UserNotFoundException;
import com.cg.movie.ticket.booking.repository.UserEntityRepository;

@RestController
@RequestMapping("/users")
public class AdminController {
@Autowired
private UserEntityRepository repository;

@GetMapping("/admin")
public List<UserEntity> getAllusers(){
	return repository.findAll();	
}
@PostMapping("/admin/{id}")
public 	UserEntity addUsers(@RequestBody UserEntity data) {
	return repository.save(data);	
	
}
@GetMapping("/admin/{id}")
public ResponseEntity<UserEntity> getUser(@PathVariable(value="id") Integer id)throws ResourceNotFoundExecption
{
	UserEntity user=repository.findById(id).orElseThrow(()-> new ResourceNotFoundExecption("user not found"));
	return ResponseEntity.ok().body(user);

}
@PutMapping("/admin/{id}")
public ResponseEntity<UserEntity> editUser(@PathVariable(value="id") Integer id)throws ResourceNotFoundExecption
{
	UserEntity user1=repository.findById(id).orElseThrow(()-> new ResourceNotFoundExecption("user not found"));
	user1.setEmail(user1.getEmail());
	user1.setMobilenumber(user1.getMobilenumber());
	user1.setPassword(user1.getPassword());
	user1.setRole(user1.getRole());
	final UserEntity updateuser = repository.save(user1);
	return ResponseEntity.ok().body(updateuser);
}
@DeleteMapping("/admin/{id}")
public Map<String,Boolean> deleteUser(@PathVariable(value="id")Integer id) throws UserNotFoundException
{
	UserEntity user1=repository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found ....."));
	repository.delete(user1);
	
	Map<String,Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return response;
}
}

