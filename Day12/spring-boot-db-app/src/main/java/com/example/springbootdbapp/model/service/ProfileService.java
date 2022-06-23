package com.example.springbootdbapp.model.service;

import java.util.List;

import com.example.springbootdbapp.exceptions.ProfileNotFoundException;
import com.example.springbootdbapp.model.beans.Profile;

public interface ProfileService {
    
    // Stores a profile into the database
    public Profile storeProfile(Profile profile);


    // Returns All Profiles within List
    public List<Profile> fetchProfiles();


    // This returns a profile with respectice id OR throw ProfileNotFoundExcpetion
    public Profile fetchProfile(int id) throws ProfileNotFoundException;

    public Profile updateProfile(int id, Profile updated) throws ProfileNotFoundException;
}
