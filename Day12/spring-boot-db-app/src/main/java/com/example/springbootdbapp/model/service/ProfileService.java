package com.example.springbootdbapp.model.service;

import java.util.List;

import com.example.springbootdbapp.model.beans.Profile;

public interface ProfileService {
    
    public Profile storeProfile(Profile profile);

    public List<Profile> fetchProfiles();
}
