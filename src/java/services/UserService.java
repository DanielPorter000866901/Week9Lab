package services;

import models.User;
import dataaccess.UserDB;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    
    private final UserDB accessUsers = new UserDB();
    
    public List<User> getAll() throws Exception {
        
        List<User> users = accessUsers.getAll();
        
        return users;
    }
    
    public User get(String email) throws Exception {
        
        User user = accessUsers.get(email);
        
        return user;
    }
    
    public void insert(User user) throws Exception {
        accessUsers.insert(user);
    }
    
    public void update(User user) throws Exception {
        accessUsers.update(user);
    }
    
    public void delete(User user) throws Exception {
        accessUsers.delete(user);
    }
}
