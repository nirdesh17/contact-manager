package com.contactmanager.contactmanager.repository;

import com.contactmanager.contactmanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
