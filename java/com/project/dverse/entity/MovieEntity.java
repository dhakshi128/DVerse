package com.project.dverse.entity;
import java.time.LocalDate;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="Movies")
public class MovieEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String movieName;
	private String TheatreName;
	private LocalDate Date;//YYYY-MM-DD
	@OneToMany(mappedBy = "movie")
    private Set<BookingEntity> bookings;
	public MovieEntity() {}
	public MovieEntity(long id, String movieName, Set<BookingEntity> bookings, String theatreName, LocalDate date) {
	
		this.id = id;
		this.movieName = movieName;
		this.bookings = bookings;
		TheatreName = theatreName;
		Date = date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTheatreName() {
		return TheatreName;
	}
	public void setTheatreName(String theatreName) {
		TheatreName = theatreName;
	}
	public LocalDate getDate() {
		return Date;
	}
	public void setDate(LocalDate date) {
		Date = date;
	}
	

}
