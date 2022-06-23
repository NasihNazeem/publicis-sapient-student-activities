package com.example.springbootdbapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdbapp.exceptions.FriendNotFoundException;
import com.example.springbootdbapp.exceptions.ProfileNotFoundException;
import com.example.springbootdbapp.model.beans.Friend;
import com.example.springbootdbapp.model.beans.Profile;
import com.example.springbootdbapp.model.service.FriendService;
import com.example.springbootdbapp.model.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private FriendService friendService;

    @PostMapping
    public ResponseEntity<Object> store(@RequestBody Profile profile) {
        Profile storedProfile = profileService.storeProfile(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(storedProfile);
    }

    @GetMapping
    public ResponseEntity<Object> getProfiles() {
        List<Profile> list = profileService.fetchProfiles();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<Object> getProfile(@PathVariable("profileId") int id){
        try{
            Profile profile = profileService.fetchProfile(id);
            return ResponseEntity.status(HttpStatus.OK).body(profile);
        } catch (ProfileNotFoundException e){
            Map<String,String> map = new HashMap<>();
            map.put("error", e.getMessage());
            map.put("status", "404");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
        }
    }

    @PostMapping("/{profileId}")
    public ResponseEntity<Object> addFriend(@RequestBody Friend friend, @PathVariable("profileId") int id){
        Friend createdFriend = friendService.addFriend(id, friend);
        Map<String,String> map = new HashMap<>();

        map.put("message", "Added " +createdFriend.getName());
        map.put("description", "Added to profile id: "+ createdFriend.getProfileIdRef());
        
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    
    @PutMapping("/{profileId}")
    public ResponseEntity<Object> updatePhoneNo(@RequestBody Profile updatedProfile, @PathVariable("profileId") int id) throws ProfileNotFoundException{
        
        profileService.updateProfile(id, updatedProfile);

        Map<String, String> map = new HashMap<>();

        map.put("message", "Profile " + id + " phone number has been updated.");
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @DeleteMapping("/{profileId}")
    public ResponseEntity<Object> deleteFriend(@PathVariable("profileId") int id) throws FriendNotFoundException{
        friendService.deleteFriend(id);
        
        Map<String, String> map = new HashMap<>();

        map.put("message", "Friend "+ id + " deleted");
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

}