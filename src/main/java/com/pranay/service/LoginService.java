package com.pranay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranay.model.Login;
import com.pranay.repository.LoginRepository;

@Service
public class LoginService {
    @Autowired
    private LoginRepository log;

    public void registerUser(Login l) {
        log.save(l);
    }

    public Login validateUser(String name, String password) {
        Login user = log.findByName(name);
        if (user != null && user.getPassword().equals(password)) {
            return user; 
        }
        return null; 
    }
}
