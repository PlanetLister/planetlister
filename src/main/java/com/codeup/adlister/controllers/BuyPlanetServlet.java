package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Planet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/buy")
public class BuyPlanetServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Planet planet = (Planet)request.getSession().getAttribute("planet");

//        request.setAttribute("planets", DaoFactory.getPlanetsDao().changeOwnerPlanet(planet));
        DaoFactory.getPlanetsDao().changeOwnerPlanet(planet);
    }
}
