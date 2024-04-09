package com.websummarizer.Web.Summarizer.services;

import com.websummarizer.Web.Summarizer.model.User;
import com.websummarizer.Web.Summarizer.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    // These methods are used for: password and request token
    public void setPassword(User user) {
        userRepo.setPassword(user.getPassword(), user.getEmail());
    }
    public User getUserByEmail(String email){return userRepo.getUserByEmail(email);}
    public User getUserByEmailAndResetToken(String email, String token){
        return userRepo.getUserByEmailAndResetToken(email, token);
    }
    public int setPasswordRequestToken(String token, User user){
        return userRepo.setRequestToken(token, user.getEmail());
    }
}
