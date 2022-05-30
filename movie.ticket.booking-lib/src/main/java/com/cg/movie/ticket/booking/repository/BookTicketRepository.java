package com.cg.movie.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.movie.ticket.booking.entities.BookTicket;
@Repository
public interface BookTicketRepository extends JpaRepository<BookTicket, Integer>{
	@Query(value="select book from BookTicket book where book.bookingid=?1")
	BookTicket getBookById(int bookingid);
	@Query(value="select book.userid from BookTicket book where book.bookingid=?1")
	public int getIdById(int bookingid );
	@Query(value="select book.showid from BookTicket book where book.bookingid=?1")
	public int getSById(int bookingid );
	
	
}
