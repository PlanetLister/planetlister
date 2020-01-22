package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Planet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

@WebServlet("/update")
public class UpdateSerlvet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Planet updatePlanet = DaoFactory.getPlanetsDao().findPlanetById(11);
        request.setAttribute("pName", updatePlanet.getName());
        request.setAttribute("pDescription", updatePlanet.getDescription());
        request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = 11;
        int userId = 1;
        String name = request.getParameter("planetName");
        String description = request.getParameter("planetDescription");

        if(name != null && description != null){
            if(!name.equals("") && !description.equals("")){
                Planet update = new Planet(id, name, description, userId);
                DaoFactory.getPlanetsDao().updatePlanet(update);
                request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
            }else{
                if(name.equals("")){
                    request.setAttribute("nameError", "Name cannot be blank");
                }else {
                    request.setAttribute("pName", request.getParameter("planetName"));
                }

                if(description.equals("")){
                    request.setAttribute("descriptionError", "Description cannot be blank");
                }else {
                    request.setAttribute("pDescription", request.getParameter("planetDescription"));
                }

                request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
            }
        }
    }
}
