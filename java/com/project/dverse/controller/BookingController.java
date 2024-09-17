package com.project.dverse.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.dverse.entity.BookingEntity;
import com.project.dverse.service.BookingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@RequestMapping("/booking")
@Tag(name = "Booking Controller", description = "API for managing bookings")
public class BookingController {
	@Autowired
	private BookingService bkservice;
	//create
	@Operation(summary = "Create a new booking", description = "Create a new booking with the provided details")
	@PostMapping
	public ResponseEntity<BookingEntity> createbooking(@RequestBody BookingEntity booking,Long userId, Long movieId){
		BookingEntity createdbook=bkservice.createBooking(booking,userId,movieId);
		return new ResponseEntity<>(createdbook,HttpStatus.CREATED);
	}
	//get all
	@Operation(summary = "Get all bookings", description = "Retrieve a list of all bookings")
	@GetMapping
	public ResponseEntity<List<BookingEntity>> getallbooking(){
		List<BookingEntity> allbook=bkservice.getAllBookings();
		return new ResponseEntity<>(allbook,HttpStatus.OK);
	}
	//getbyid
	@Operation(summary = "Get booking by ID", description = "Retrieve booking details by their ID")
	@GetMapping("/{id}")
	public ResponseEntity<BookingEntity> getbooking(@PathVariable Long id){
		BookingEntity book=bkservice.getBookingById(id);
		return new ResponseEntity<>(book,HttpStatus.OK);
	}
	//update
	@Operation(summary = "Update booking by ID", description = "Update booking details by their ID")
	@PutMapping("/{id}")
	public ResponseEntity<BookingEntity> updatebooking(@PathVariable Long id,BookingEntity book){
		BookingEntity updatebook=bkservice.updateBooking(id, book);
		return new ResponseEntity<>(updatebook,HttpStatus.OK);
	}
	//delete
	@Operation(summary = "Delete booking by ID", description = "Delete a booking by their ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBooking(@PathVariable Long id){
		bkservice.deleteBooking(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
