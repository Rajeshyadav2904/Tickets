package com.cg.movie.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.movie.ticket.booking.entities.TheatreEntity;

public interface TheatreEntityRepository extends JpaRepository<TheatreEntity, Integer>{

}
