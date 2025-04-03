package com.projekat.RoomBooking.service;

import java.util.List;

import com.projekat.RoomBooking.model.User;



public interface IUserService {
    User registerUser(User user);
    List<User> getUsers();
    void deleteUser(String email);
    User getUser(String email);
}
