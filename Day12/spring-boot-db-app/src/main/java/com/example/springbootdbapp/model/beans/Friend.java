package com.example.springbootdbapp.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Friend {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long phone;

    // Foreign Key
    @Column(name = "profileidref")
    private int profileIdRef;

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return long return the phone
     */
    public long getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(long phone) {
        this.phone = phone;
    }

    /**
     * @return int return the profileIdRef
     */
    public int getProfileIdRef() {
        return profileIdRef;
    }

    /**
     * @param profileIdRef the profileIdRef to set
     */
    public void setProfileIdRef(int profileIdRef) {
        this.profileIdRef = profileIdRef;
    }

}
