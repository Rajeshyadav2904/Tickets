package com.cg.movie.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.movie.ticket.booking.entities.Theatre;
@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer>{

	@Query(value = "select t1 from Theatre t1 where t1.theatreid=?1")
	Theatre getTheaterById(int theatreid);
}
