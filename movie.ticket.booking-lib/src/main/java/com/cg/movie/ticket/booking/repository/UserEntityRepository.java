package com.cg.movie.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.movie.ticket.booking.entities.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer>{
	
}
