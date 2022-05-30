package com.cg.movie.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.movie.ticket.booking.entities.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
}
