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

@WebServlet("/galaxy/planet")
public class ShowPlanetServlet extends HttpServlet {


    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (request.getSession().getAttribute("user") == null) {
//            response.sendRedirect("/splash");
//            return;
//        }
        long planetId = Integer.parseInt(request.getParameter("id"));
        Planet planet = DaoFactory.getPlanetsDao().findPlanetById(planetId);
        User user = DaoFactory.getUsersDao().findPlanetsOwnerById(planetId);
        request.setAttribute("planet", planet);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/planet.jsp").forward(request, response);

    }

}


