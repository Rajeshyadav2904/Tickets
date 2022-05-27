package com.cg.movie.ticket.booking.services;

import java.util.List;
import java.util.Optional;

import com.cg.movie.ticket.booking.entities.UserEntity;

public interface AdminService {
void addUserEntity(UserEntity userid);
List<UserEntity>viewAllUsers();
Optional<UserEntity> getDeptById(int userid);
void updateUserEntity(UserEntity user);
void deleteUsersEntity(int userid);
}
