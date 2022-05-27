package com.cg.movie.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.movie.ticket.booking.entities.BookTicketEntity;

public interface BookTicketEntityRepository extends JpaRepository<BookTicketEntity, Integer>{

}
