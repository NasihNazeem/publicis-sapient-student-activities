package com.example.springbootdbapp.model.service;

import com.example.springbootdbapp.model.beans.Friend;

public interface FriendService {
    
    public Friend addFriend(int profileIdRef, Friend friend);

    public void deleteFriend(int profileIdRef);
}
