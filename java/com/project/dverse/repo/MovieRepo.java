package com.project.dverse.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dverse.entity.MovieEntity;

@Repository

public interface MovieRepo extends JpaRepository<MovieEntity,Long> {


}
