package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import models.User;
import models.Role;

/**
 * 
 * @author Aaron Warsylewicz, Daniel Porter
 */
public class UserDB {

    /**
     * get all users
     * @return users as a list
     * @throws Exception 
     */
    public List<User> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<User> users = em.createNamedQuery("User.findAll", User.class).getResultList();
            return users;
        } finally {
            em.close();
        }
    }

    /**
     * Get user by email
     * @param email
     * @return User
     * @throws Exception 
     */
    public User get(String email) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            User user = em.find(User.class, email);
            return user;
        } finally {
            em.close();
        }
    }
    
    /**
     * Make new user
     * @param user
     * @throws Exception 
     */
    public void insert(User user) throws Exception {
        
        
        try {
            
        } finally {
            
        }
    }

    /**
     * update an existing user
     * @param user
     * @throws Exception 
     */
    public void update(User user) throws Exception {
        
        
        try {
            
        } finally {
            
        }
    }

    /**
     * delete a user by email
     * @param email
     * @throws Exception 
     */
    public void delete(String email) throws Exception {
        
        
        try {
            
        } finally {
            
        }
    }

}
