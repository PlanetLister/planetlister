package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.Planet;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/galaxy/planet")
public class ShowPlanetServlet extends HttpServlet {


    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/splash");
            return;
        }
        int planetId = Integer.parseInt(request.getParameter("id"));

        Planet planet = DaoFactory.getPlanetsDao().findPlanetById(planetId);
        User planetUser = DaoFactory.getUsersDao().findPlanetsOwnerById(planetId);
        User user = (User) request.getSession().getAttribute("user");
        List<Category> category = DaoFactory.getCategoriesDao().combined(planet);

        request.getSession().setAttribute("planet", planet);
        request.setAttribute("planetUser", planetUser);
        request.setAttribute("categories", category);

        if(planet.getUser_id() != user.getId()){
            request.setAttribute("validate", "true");
        }

        request.getRequestDispatcher("/WEB-INF/planet.jsp").forward(request, response);

    }

}


