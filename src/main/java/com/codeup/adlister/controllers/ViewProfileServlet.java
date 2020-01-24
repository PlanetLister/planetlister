package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Planet;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/splash");
            return;
       }

        User user = (User) request.getSession().getAttribute("user");
        int userId = (int) user.getId();
        user = DaoFactory.getUsersDao().findUserById(userId);
        request.setAttribute("categories", DaoFactory.getCategoriesDao().all());
        request.setAttribute("user",user);
        request.setAttribute("planets", DaoFactory.getPlanetsDao().usersPlanets(userId));
        request.setAttribute("generalError", request.getParameter("generalError"));
        request.setAttribute("emailError", request.getParameter("emailError"));
        request.setAttribute("usernameError", request.getParameter("usernameError"));
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String edit = request.getParameter("editSend");
        String delete = request.getParameter("deleteSend");
        String update = request.getParameter("updateId");

        if(edit != null){
            request.getSession().setAttribute("planetId", edit);
            response.sendRedirect("/update");
        }

        if(delete != null){
            request.getSession().setAttribute("delPlanetId", delete);
            response.sendRedirect("/galaxy/delete");
        }

        if(update != null){

            String username = request.getParameter("uname");
            String email = request.getParameter("uemail");
            Boolean validate = !username.equals(" ") && !email.equals(" ");

            if(username != null && email != null){
                if(validate){
                    User user = (User) request.getSession().getAttribute("user");
                    Boolean checkUsername = DaoFactory.getUsersDao().findByUsername(username) == null ||
                            DaoFactory.getUsersDao().findByUsername(username).getId() == user.getId();
                    Boolean checkEmail = DaoFactory.getUsersDao().findByEmail(email) == null ||
                            DaoFactory.getUsersDao().findByEmail(email).getEmail().equals(user.getEmail());
                    Boolean checkEmailForm = Password.checkEmail(email);

                    if(checkEmailForm && checkEmail && checkUsername){
                        user.setUsername(username);
                        user.setEmail(email);
                        DaoFactory.getUsersDao().updateUser(user);
                        request.getSession().setAttribute("user", user);
                    }else {
                        if(!checkEmail){
                            request.setAttribute("emailError", "Email is already register.");
                        }
                        if(!checkEmailForm){
                            request.setAttribute("emailError", "Email is not in the correct form");
                        }
                        if(!checkUsername){
                            request.setAttribute("usernameError", "Username is already taken. Please choose another one.");
                        }
                    }

                }else {
                    request.setAttribute("generalError", "Fields cannot be null or empty");
                }
            }else{
                request.setAttribute("generalError", "Fields cannot be null or empty");
            }

            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        }
    }
}
