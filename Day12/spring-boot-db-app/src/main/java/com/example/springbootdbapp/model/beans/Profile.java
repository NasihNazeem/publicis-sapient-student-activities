package com.example.springbootdbapp.model.beans;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Profile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileId;
    private String name;
    private long phone;
    private LocalDate dob;

    @OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "profileidref")
    private List<Friend> friends;
    

    /**
     * @return int return the profileId
     */
    public int getProfileId() {
        return profileId;
    }

    /**
     * @param profileId the profileId to set
     */
    public void setProfileId(int profileId) {
        this.profileId = profileId;
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
     * @return LocalDate return the dob
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }


    /**
     * @return List<Friend> return the friends
     */
    public List<Friend> getFriends() {
        return friends;
    }

    /**
     * @param friends the friends to set
     */
    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

}
