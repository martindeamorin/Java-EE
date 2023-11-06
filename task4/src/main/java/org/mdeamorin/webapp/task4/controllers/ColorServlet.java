package org.mdeamorin.webapp.task4.controllers;

import java.io.IOException;
import java.util.Optional;

import org.mdeamorin.webapp.task4.services.CookieService;
import org.mdeamorin.webapp.task4.services.CookieServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/change-color")
public class ColorServlet extends HttpServlet {
    private CookieService cookieService = new CookieServiceImpl();
    private final String COLOR = "color";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/change-color.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> colorCookie = cookieService.getCookieValue(req, COLOR);
        String colorParam = req.getParameter(COLOR);
        if(!colorCookie.isPresent()){
            cookieService.setCookie(resp, COLOR, colorParam);
            resp.sendRedirect(req.getContextPath() + "/change-color");
        } else {
            if(!colorParam.equals(colorCookie.get())) cookieService.setCookie(resp, COLOR, colorParam);
            resp.sendRedirect(req.getContextPath() + "/change-color");
        }
    }
}
