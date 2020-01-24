package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Planet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.codeup.adlister.dao.DaoFactory.*;

@WebServlet("/galaxy")
public class PlanetsIndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/splash");
            return;
        }
        request.setAttribute("planets", getPlanetsDao().all());
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String userSearch = request.getParameter("input");

        if(userSearch != null && !userSearch.equals("")){
            List<Planet> planets = getPlanetsDao().search(userSearch);
            if(!planets.isEmpty()){
                request.setAttribute("planets", planets);
                request.setAttribute("userInput", request.getParameter("input"));
                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                return;
            }else{
                request.setAttribute("errorMessage", "No results were found");
            }
        }

        request.setAttribute("planets", getPlanetsDao().all());
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
    }

}
