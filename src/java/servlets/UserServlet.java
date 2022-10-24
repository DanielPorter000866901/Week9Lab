package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.*;
import models.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<User> users;
        List<Role> roles;
        
        UserService us = new UserService();
        RoleService rs = new RoleService();
        
        String action = request.getParameter("action");
        
        // initialize to false - not editing
        request.setAttribute("edit", false);
        
        // delete user
        if (action != null && action.equals("delete")) {
            String deleteEmail = request.getParameter("userEmail");
            
            try {
                us.delete(deleteEmail);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action != null && action.equals("edit")){ // edit a user
            
            request.setAttribute("edit", true); // so the edit page shows up.
            try {
                User editUser = us.get(request.getParameter("userEmail")); // get user to edit
                request.setAttribute("editUser", editUser);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        try {
            users = us.getAll();
            roles = rs.getAll();
            
            request.setAttribute("users", users);
            request.setAttribute("roles", roles);
            
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        UserService us = new UserService();
        
        if (action != null && action.equals("add")) {
            User newUser;
            
            String email = request.getParameter("email");
            String firstName = request.getParameter("fname");
            String lastName = request.getParameter("lname");
            String password = request.getParameter("password");
            int roleId = Integer.parseInt(request.getParameter("role"));
            
            try {
                us.insert(new User(email, firstName, lastName, password, new Role(roleId, "")));
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        response.sendRedirect(request.getContextPath() + "/user");
        
    }

}
