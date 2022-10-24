package services;

import models.User;
import models.Role;
import dataaccess.UserDB;
import java.util.ArrayList;
import java.util.List;

/**
 * Get users from data access
 * @author Daniel Porter
 */
public class UserService {
    
    private final UserDB accessUsers = new UserDB();
    private final RoleService rs = new RoleService();
    
    /**
     * Get all users and match up roles
     * @return Users as a list
     * @throws Exception 
     */
    public List<User> getAll() throws Exception {
        
        List<User> users = accessUsers.getAll();
        
        // match role id with the role from the role table and update.
        for (int i = 0; i < users.size(); i++) {
            
            int id = users.get(i).getRole().getId();
            Role role = rs.get(id);
            
            users.get(i).setRole(role);
        }
        
        return users;
    }
    
    /**
     * Get all users and match up roles
     * @return Users as a list
     * @throws Exception 
     */
    public User get(String email) throws Exception {
        
        User user = accessUsers.get(email);
        
        // match role id with the role from the role table and update.
        int id = user.getRole().getId();
        Role role = rs.get(id);
        user.setRole(role);
        
        return user;
    }
    
    /**
     * Insert new user
     * @param user
     * @throws Exception 
     */
    public void insert(User user) throws Exception {
       
        // match role id with the role from the role table and update.
        int id = user.getRole().getId();
        Role role = rs.get(id);
        user.setRole(role);
        
        accessUsers.insert(user);
    }
    
    /**
     * update existing user
     * @param user
     * @throws Exception 
     */
    public void update(User user) throws Exception {
        
        // match role id with the role from the role table and update.
        int id = user.getRole().getId();
        Role role = rs.get(id);
        user.setRole(role);
        
        accessUsers.update(user);
    }
    
    /**
     * delete a user
     * @param user
     * @throws Exception 
     */
    public void delete(User user) throws Exception {
        accessUsers.delete(user);
    }
}
