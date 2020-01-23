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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(request.getSession().getAttribute("user") == null){
            response.sendRedirect("/splash");
            return;
        }

        String planetid = (String) request.getSession().getAttribute("planetId");
        int id = Integer.parseInt(planetid);
        Planet updatePlanet = DaoFactory.getPlanetsDao().findPlanetById(id);
        request.setAttribute("pName", updatePlanet.getName());
        request.setAttribute("pDescription", updatePlanet.getDescription());
        request.setAttribute("pId", id);
        request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        int id = Integer.parseInt(request.getParameter("updateId"));
        User user = (User) request.getSession().getAttribute("user");
        int userId = (int) user.getId();
        String name = request.getParameter("planetName");
        String description = request.getParameter("planetDescription");

        if(name != null && description != null){
            if(!name.equals("") && !description.equals("")){
                Planet update = new Planet(id, name, description, userId);
                int ok = DaoFactory.getPlanetsDao().updatePlanet(update);
                if(ok > 0){
                    request.getSession().removeAttribute("planetId");
                    //request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
                    response.sendRedirect("/profile");
                }

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
