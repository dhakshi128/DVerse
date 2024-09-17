package com.project.dverse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dverse.entity.BookingEntity;

@Repository

public interface BookingRepo extends JpaRepository<BookingEntity,Long> {

}
