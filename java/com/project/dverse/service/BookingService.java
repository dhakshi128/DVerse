package com.project.dverse.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dverse.ResourceNotFoundException;
import com.project.dverse.entity.BookingEntity;
import com.project.dverse.entity.MovieEntity;
import com.project.dverse.entity.UserEntity;
import com.project.dverse.repo.BookingRepo;
import com.project.dverse.repo.MovieRepo;
import com.project.dverse.repo.UserRepo;
@Service
public class BookingService implements BookingInterface{
	
	@Autowired
	private BookingRepo bkrepo;
	@Autowired
	private UserRepo userrepo;
	@Autowired
	private MovieRepo movierepo;
	//create
	@Override
	public BookingEntity createBooking(BookingEntity book,Long userId, Long movieId) {
		UserEntity user=userrepo.findById(userId).orElseThrow();
		MovieEntity movie=movierepo.findById(movieId).orElseThrow();
		book.setUser(user);
		book.setMovie(movie);
		return bkrepo.save(book);
	}
	//get all:
	@Override
	public List<BookingEntity> getAllBookings(){
		return bkrepo.findAll();
	}
	//getbyid:
	@Override
	public BookingEntity getBookingById(Long id) {
		return bkrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Booking Not Found"));
	}
	//update
	@Override
    public BookingEntity updateBooking(Long id,BookingEntity bookdetails) {
    	BookingEntity book=bkrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Booking Not Found"));
    	book.setNumberOfPersons(bookdetails.getNumberOfPersons());
    	book.setMovie(bookdetails.getMovie());
    	return bkrepo.save(book);
    }
    //delete
	@Override
    public void deleteBooking(Long id) {
    	BookingEntity book=bkrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Booking Not Found"));
    	bkrepo.delete(book);
    }
}
