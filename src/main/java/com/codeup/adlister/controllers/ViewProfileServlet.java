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
        int userId = (int) user.getId();
        user = DaoFactory.getUsersDao().findUserById(userId);
        request.setAttribute("categories", DaoFactory.getCategoriesDao().all());
        request.setAttribute("user",user);
        request.setAttribute("planets", DaoFactory.getPlanetsDao().usersPlanets(userId));

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String edit = request.getParameter("editSend");
        String delete = request.getParameter("deleteSend");

        if(edit != null){
            request.getSession().setAttribute("planetId", edit);
            response.sendRedirect("/update");
        }

        if(delete != null){
            request.getSession().setAttribute("delPlanetId", delete);
            response.sendRedirect("/galaxy/delete");
        }
    }
}
