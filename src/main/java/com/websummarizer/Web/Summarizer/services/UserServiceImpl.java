package com.websummarizer.Web.Summarizer.services;

import com.websummarizer.Web.Summarizer.model.User;
import com.websummarizer.Web.Summarizer.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public User createUser(User user) {
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        //user.setRole("ROLE_USER");
        return userRepo.save(user);
    }

}
