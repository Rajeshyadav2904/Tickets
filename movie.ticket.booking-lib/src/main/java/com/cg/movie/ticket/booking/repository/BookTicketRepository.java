package com.cg.movie.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.movie.ticket.booking.entities.BookTicket;
@Repository
public interface BookTicketRepository extends JpaRepository<BookTicket, Integer>{

}
