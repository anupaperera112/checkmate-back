package com.example.to_do.list.repository;

import com.example.to_do.list.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
