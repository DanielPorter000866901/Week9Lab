
package services;

import models.Role;
import dataaccess.RoleDB;
import java.util.ArrayList;
import java.util.List;

/**
 * Get roles from data access.
 * @author Daniel Porter
 */
public class RoleService {
    private final RoleDB accessRoles = new RoleDB();
    
    /**
     * Get all roles
     * @return Role list
     * @throws Exception 
     */
    public List<Role> getAll() throws Exception {
        List<Role> roles;
        
        roles = accessRoles.getAll();
        
        return roles;
    }
    
    /**
     * Get role by id
     * @param roleID
     * @return Role
     * @throws Exception 
     */
    public Role get(int roleID) throws Exception {
        Role role;
        
        role = accessRoles.get(roleID);
        
        return role;
    }
}
