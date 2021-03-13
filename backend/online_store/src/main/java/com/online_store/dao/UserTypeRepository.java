package com.online_store.dao;

import com.online_store.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "userType", path = "user-type")
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
}
