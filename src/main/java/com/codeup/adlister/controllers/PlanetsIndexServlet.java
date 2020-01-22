package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/galaxy")
public class PlanetsIndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/splash");
            return;
        }
        request.setAttribute("planets", DaoFactory.getPlanetsDao().all());
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }

}
