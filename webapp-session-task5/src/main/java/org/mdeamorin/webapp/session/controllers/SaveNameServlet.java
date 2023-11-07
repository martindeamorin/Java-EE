package org.mdeamorin.webapp.session.controllers;

import java.io.IOException;

import org.mdeamorin.webapp.session.services.SessionService;
import org.mdeamorin.webapp.session.services.SessionServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/save-name")
public class SaveNameServlet extends HttpServlet{

    private SessionService sessionService = new SessionServiceImpl();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String foundSession = sessionService.getSessionValue(req, "username");
        if(foundSession != null) {
            getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String foundSession = sessionService.getSessionValue(req, "username");
        String username = req.getParameter("username");

        if(!username.equals(foundSession)) sessionService.setSessionValue(req, "username", username);
        
        getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
    }
}
