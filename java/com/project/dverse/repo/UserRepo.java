package com.project.dverse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.dverse.entity.UserEntity;

@Repository

public interface UserRepo extends JpaRepository<UserEntity,Long>{

}
