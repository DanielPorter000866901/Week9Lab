package services;

import models.User;
import models.Role;
import dataaccess.UserDB;
import java.util.ArrayList;
import java.util.List;
import exceptions.InvalidFieldsException;

/**
 * Get users from data access
 * @author Daniel Porter
 */
public class UserService {
    
    private final UserDB accessUsers = new UserDB();
    
    /**
     * Get all users and match up roles
     * @return Users as a list
     * @throws Exception 
     */
    public List<User> getAll() throws Exception {
        
        List<User> users = accessUsers.getAll();
        
        return users;
    }
    
    /**
     * Get all users and match up roles
     * @return Users as a list
     * @throws Exception 
     */
    public User get(String email) throws Exception {
        
        User user = accessUsers.get(email);
        
        return user;
    }
    
    /**
     * Insert new user
     * @param user
     * @throws Exception 
     * @throws InvalidFieldsException if null or empty fields
     */
    public void insert(User user) throws Exception, InvalidFieldsException {
       
        
        // check all attributes are valid
        if (user.getEmail() == null || user.getFirstName() == null || user.getLastName() == null || user.getPassword() == null ||
                user.getEmail().equals("") || user.getFirstName().equals("") || user.getLastName().equals("") || user.getPassword().equals("")) {
            throw new InvalidFieldsException();
        } else {
            accessUsers.insert(user);
        }
        
    }
    
    /**
     * update existing user
     * @param user
     * @throws Exception 
     * @throws InvalidFieldsException if null or empty fields
     */
    public void update(User user) throws Exception, InvalidFieldsException {
        
        
        // check all attributes are valid
        if (user.getEmail() == null || user.getFirstName() == null || user.getLastName() == null || user.getPassword() == null ||
                user.getEmail().equals("") || user.getFirstName().equals("") || user.getLastName().equals("") || user.getPassword().equals("")) {
            throw new InvalidFieldsException();
        } else {
            accessUsers.update(user);
        }
        
        
    }
    
    /**
     * delete a user by email
     * @param email
     * @throws Exception 
     */
    public void delete(String email) throws Exception {
        accessUsers.delete(email);
    }
}
