package org.mdeamorin.webapps.cookies.controllers;

import java.io.IOException;
import java.util.Optional;

import org.mdeamorin.webapps.cookies.services.CookieService;
import org.mdeamorin.webapps.cookies.services.CookieServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogouServlet extends HttpServlet {

    private CookieService cookieService = new CookieServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> foundCookie = cookieService.getCookieValue(req, "username");
        if(foundCookie.isPresent()) {
            cookieService.deleteCookie(resp, "username");
        }
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
