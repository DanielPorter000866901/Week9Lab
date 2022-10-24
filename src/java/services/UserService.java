package services;

import models.User;
import models.Role;
import dataaccess.UserDB;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    
    private final UserDB accessUsers = new UserDB();
    private final RoleService rs = new RoleService();
    
    public List<User> getAll() throws Exception {
        
        List<User> users = accessUsers.getAll();
        
        for (int i = 0; i < users.size(); i++) {
            
            int id = users.get(i).getRole().getId();
            Role role = rs.get(id);
            
            users.get(i).setRole(role);
        }
        
        return users;
    }
    
    public User get(String email) throws Exception {
        
        User user = accessUsers.get(email);
        int id = user.getRole().getId();
        Role role = rs.get(id);
        user.setRole(role);
        
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
