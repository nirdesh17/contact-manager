package com.contactmanager.contactmanager.repository;

import com.contactmanager.contactmanager.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Integer> {

}
