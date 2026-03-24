package com.winy.e_commerce.ifrastructure.repositories;

import com.winy.e_commerce.ifrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
