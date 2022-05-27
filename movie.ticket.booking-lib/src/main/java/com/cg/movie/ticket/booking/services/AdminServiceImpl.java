package com.cg.movie.ticket.booking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.movie.ticket.booking.entities.UserEntity;
import com.cg.movie.ticket.booking.repository.UserEntityRepository;

public class AdminServiceImpl implements AdminService {
@Autowired
UserEntityRepository userrepo;
	@Override
	public void addUserEntity(UserEntity userid) {
		userrepo.save(userid);
	
	}

	@Override
	public List<UserEntity> viewAllUsers() {
		return userrepo.findAll();
	}

	@Override
	public Optional<UserEntity> getDeptById(int userid) {
		Optional<UserEntity> use1 = userrepo.findById(userid);
		return use1;	
	}

	@Override
	public void updateUserEntity(UserEntity user) {
	userrepo.save(user);	
		
	}

	@Override
	public void deleteUsersEntity(int userid) {
	userrepo.deleteById(userid);	
	}

}
