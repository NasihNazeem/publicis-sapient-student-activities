package com.example.springbootdbapp.model.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootdbapp.model.beans.Friend;
import com.example.springbootdbapp.model.dao.FriendRepository;

@Service
public class FriendServiceImpl implements FriendService{

    @Autowired
    private FriendRepository friendDao;

    @Override
    @Transactional
    public Friend addFriend(int profileIdRef, Friend friend) {
        friend.setProfileIdRef(profileIdRef);
        return friendDao.save(friend);
    }

    @Override
    public void deleteFriend(int profileIdRef) {
        friendDao.delete(friendDao.findById(profileIdRef).get());
        
    }
    
    
}
