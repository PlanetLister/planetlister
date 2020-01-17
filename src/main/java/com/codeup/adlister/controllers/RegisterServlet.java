package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");
        String filepath = "/WEB-INF/img/dummy.jpg";

        // validate input
        boolean inputHasErrors = username.isEmpty()
                || email.isEmpty()
                || password.isEmpty()
                || (! password.equals(passwordConfirmation))
                || !Password.checkPwd(password)
                || !Password.checkEmail(email)
                || DaoFactory.getUsersDao().findByUsername(username) != null
                || DaoFactory.getUsersDao().findByEmail(email) != null;

        if (inputHasErrors) {
            if(username.isEmpty()){
                request.setAttribute("usernameError", "Username cannot be blank");
            }else if(DaoFactory.getUsersDao().findByUsername(username) != null){
                request.setAttribute("usernameError", "Username already exists");
            }

            if(email.isEmpty()){
                request.setAttribute("emailError", "Email cannot be blank");
            }else if(!Password.checkEmail(email)){
                request.setAttribute("emailError", "Email is not in correct format (name@host.com)");
            }else if(DaoFactory.getUsersDao().findByEmail(email) != null){
                request.setAttribute("emailError", "Email already exists");
            }

            if(password.isEmpty()){
                request.setAttribute("passwordError", "Password cannot be blank");
            }else if(!password.equals(passwordConfirmation)){
                request.setAttribute("passwordError", "Passwords did not match");
            }else if(!Password.checkPwd(password)){
                request.setAttribute("passwordError", "Password is not in correct format(at least one lower case, one uppper case, " +
                        "one special character (@#$%^&+=), at least one digit, and between 8-10 characters)");
            }
            request.setAttribute("usernameInput", username);
            request.setAttribute("emailInput", email);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        // create and save a new user
        User user = new User(username, email, Password.hash(password),filepath);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
