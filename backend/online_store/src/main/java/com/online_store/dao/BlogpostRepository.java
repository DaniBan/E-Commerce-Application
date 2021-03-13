package com.online_store.dao;

import com.online_store.entity.Blogpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface BlogpostRepository extends JpaRepository<Blogpost, Integer> {
}
