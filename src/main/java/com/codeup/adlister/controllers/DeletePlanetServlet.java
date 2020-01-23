package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLPlanetsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/galaxy/delete")
public class DeletePlanetServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/splash");
            return;
        }
        String planetid = (String) request.getSession().getAttribute("delPlanetId");
        int delplanetID = Integer.parseInt(planetid);

        int allCat = DaoFactory.getCategoriesDao().deleteCategoriesPerPlanet(delplanetID);

        DaoFactory.getPlanetsDao().deletePlanet(delplanetID);


        response.sendRedirect("/profile");
    }
}
