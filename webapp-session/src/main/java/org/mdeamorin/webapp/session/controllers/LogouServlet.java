package org.mdeamorin.webapp.session.controllers;

import java.io.IOException;

import org.mdeamorin.webapp.session.services.SessionService;
import org.mdeamorin.webapp.session.services.SessionServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogouServlet extends HttpServlet {

    private SessionService sessionService = new SessionServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String foundSessionValue = sessionService.getSessionValue(req, "username");
        if(foundSessionValue != null) {
            sessionService.deleteSessionValue(req, "username");;
        }
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
