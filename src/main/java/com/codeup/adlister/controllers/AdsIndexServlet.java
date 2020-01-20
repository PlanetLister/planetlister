package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String button = request.getParameter("button");
        String userResponse = button + " " + id;
        request.setAttribute("editDelMessage", userResponse);

        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //post request to display the info
        String userSearch = request.getParameter("search");

        if(userSearch != null && !userSearch.equals("")){
            List<Ad> ads = DaoFactory.getAdsDao().search(userSearch);
            if(!ads.isEmpty()){
                request.setAttribute("ads", ads);
                request.setAttribute("userInput", request.getParameter("search"));
                request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
                return;
            }else {
                request.setAttribute("errorMessage", "No results were found");
            }

        }
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }
}
