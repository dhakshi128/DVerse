package com.project.dverse.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.project.dverse.entity.UserEntity;
import com.project.dverse.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@RequestMapping("/users")
@Tag(name = "User Controller", description = "API for managing users")
public class UserController {
	@Autowired
	private UserService userservice;

	//create
	@Operation(summary = "Create a new user", description = "Create a new user with the provided details")
	@PostMapping
	public ResponseEntity<UserEntity> createuser(@RequestBody UserEntity user){
		UserEntity createduser=userservice.createUser(user);
		return new ResponseEntity<>(createduser,HttpStatus.CREATED);
	}
	//read
	@Operation(summary = "Get all users", description = "Retrieve a list of all users")
	@GetMapping()
	public ResponseEntity<List<UserEntity>> getUser(){
		List<UserEntity> users=userservice.getAllUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	//read by id
	@Operation(summary = "Get user by ID", description = "Retrieve user details by their ID")
	@GetMapping("/{id}")
    public ResponseEntity<UserEntity> getbyId(@PathVariable Long id) {
        UserEntity user = userservice.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
	//update
	@Operation(summary = "Update user by ID", description = "Update user details by their ID")
	@PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateuser(@PathVariable Long id, @RequestBody UserEntity userdetail) {
        UserEntity updateduser = userservice.updateUser(id, userdetail);
        return new ResponseEntity<>(updateduser, HttpStatus.OK);
    }
	//delete
	@Operation(summary = "Delete user by ID", description = "Delete a user by their ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteuser(@PathVariable Long id){
		userservice.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
}
