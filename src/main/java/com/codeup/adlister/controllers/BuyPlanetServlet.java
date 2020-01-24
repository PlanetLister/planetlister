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

@WebServlet("/buy")
public class BuyPlanetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("planet"));
        Planet planet = DaoFactory.getPlanetsDao().findPlanetById(id);
        User user = (User) request.getSession().getAttribute("user");
//        request.setAttribute("planets", DaoFactory.getPlanetsDao().changeOwnerPlanet(planet));
        int idUser = (int) user.getId();
        DaoFactory.getPlanetsDao().changeOwnerPlanet(planet,idUser);
        response.sendRedirect("/profile");
    }
}
