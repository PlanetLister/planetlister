package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Planet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/galaxy/planet")
public class ShowPlanetServlet extends HttpServlet {

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long planetId = Integer.parseInt(request.getParameter("id"));
        Planet planet = DaoFactory.getPlanetsDao().findPlanetById(planetId);
        request.setAttribute("planet", planet);
        request.getRequestDispatcher("/WEB-INF/planet.jsp").forward(request, response);

    }

}


