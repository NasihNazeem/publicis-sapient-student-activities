package com.example.springbootdbapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootdbapp.exceptions.ProfileNotFoundException;
import com.example.springbootdbapp.model.beans.Friend;
import com.example.springbootdbapp.model.beans.Profile;
import com.example.springbootdbapp.model.dao.FriendRepository;
import com.example.springbootdbapp.model.dao.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileDao;
    
    @Autowired
    private FriendRepository friendDao;

    @Transactional
    @Override
    public Profile storeProfile(Profile profile) {
        Profile createdProfile = profileDao.save(profile);
        return createdProfile;
    }

    @Override
    public List<Profile> fetchProfiles() {
        List<Profile> list = profileDao.findAll();
        return list;
    }

    @Override
    public Profile fetchProfile(int id) throws ProfileNotFoundException {
        Profile profile = profileDao.findById(id).orElse(null);

        if(profile == null){
            throw new ProfileNotFoundException("Profile with an id: " + id + " is not found!");
        }

        List<Friend> friends = friendDao.getFriendsFromProfile(id);
        profile.setFriends(friends);
        return profile;
    }

    @Override
    public Profile updateProfile(int id, Profile updated) throws ProfileNotFoundException {
        Profile profile = fetchProfile(id);
        profile.setPhone(updated.getPhone());
        profile = profileDao.save(profile);
        return profile;
    }
    
    
}
