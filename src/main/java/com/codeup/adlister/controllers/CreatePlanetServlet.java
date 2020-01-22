package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Planet;
import com.codeup.adlister.models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/galaxy/planet/create")
public class CreatePlanetServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Planet planet = new Planet(
                request.getParameter("pname"),
                request.getParameter("description"),
                (int) user.getId()
                );
        DaoFactory.getPlanetsDao().insert(planet);
        response.sendRedirect("/galaxy");
    }
}
