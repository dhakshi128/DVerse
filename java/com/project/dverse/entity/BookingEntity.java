package com.project.dverse.entity;
import jakarta.persistence.*;
@Entity
@Table(name="Bookings")
public class BookingEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "event_id", nullable = false)
	private MovieEntity movie;
	private int NumberOfPersons;
	public BookingEntity() {}

    public BookingEntity(UserEntity user, MovieEntity movie, int numberOfPersons) {
        this.user = user;
        this.movie = movie;
        this.NumberOfPersons = numberOfPersons;
    }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public MovieEntity getMovie() {
		return movie;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	public int getNumberOfPersons() {
		return NumberOfPersons;
	}

	public void setNumberOfPersons(int numberOfPersons) {
		NumberOfPersons = numberOfPersons;
	}

}
