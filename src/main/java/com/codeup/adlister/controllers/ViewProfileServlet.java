package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Planet;
import com.codeup.adlister.models.User;

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
        long userId = user.getId();
        user = DaoFactory.getUsersDao().findUserById(userId);

        request.setAttribute("user",user);
        request.setAttribute("planets", DaoFactory.getPlanetsDao().usersPlanets(userId));

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
