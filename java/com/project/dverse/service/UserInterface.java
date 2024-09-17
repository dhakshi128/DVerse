package com.project.dverse.service;

import java.util.List;

import com.project.dverse.entity.UserEntity;

public interface UserInterface {
    List<UserEntity> getAllUsers();
    UserEntity getUserById(Long id);
    UserEntity createUser(UserEntity user);
    UserEntity updateUser(Long id, UserEntity user);
    void deleteUser(Long id);
}

