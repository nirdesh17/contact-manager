package com.contactmanager.contactmanager.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Column(unique = true) //for accecpting unique email id
    private String email;
    private String password;
    private String role;
    private boolean enabled;
    private String imageUrl;
    @Column(length = 500)
    private String about;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "user")//for one user their can be many contacts//CascadeType.All will ensure that all persistence events such as persist, refresh, merge and remove that occur on the parent, will be passed to the child.// mapped bu user table so no need for another table for foreign key management
    private List<Contact> contacts = new ArrayList<>();

    public User() {
    }

//    public User(int id, String name, String email, String password, String role, boolean enabled, String imageUrl, String about) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.role = role;
//        this.enabled = enabled;
//        this.imageUrl = imageUrl;
//        this.about = about;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
