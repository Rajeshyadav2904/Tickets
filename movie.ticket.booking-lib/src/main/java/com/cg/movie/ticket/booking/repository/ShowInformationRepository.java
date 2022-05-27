package com.cg.movie.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.movie.ticket.booking.entities.ShowInformationEntity;

public interface ShowInformationRepository extends JpaRepository<ShowInformationEntity, Long>{

}
