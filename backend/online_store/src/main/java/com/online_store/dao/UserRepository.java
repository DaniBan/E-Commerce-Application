package com.online_store.dao;

import com.online_store.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Integer> {

    // find user by email method
    Page<User> findByEmail(@RequestParam("email") String email, Pageable pageable);

    // find user by id method
    User findUserById(int id);

}
