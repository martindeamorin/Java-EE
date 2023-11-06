package org.mdeamorin.webapp.headers.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    
     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setHeader("Location", req.getContextPath() + "/products.html");
        //resp.setStatus(HttpServletResponse.SC_FOUND);
        resp.sendRedirect(req.getContextPath() + "/products.html"); //forma abreviada
     }
}
