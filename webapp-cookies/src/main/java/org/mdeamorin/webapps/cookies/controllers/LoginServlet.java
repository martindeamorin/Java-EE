package org.mdeamorin.webapps.cookies.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import org.mdeamorin.webapps.cookies.services.CookieService;
import org.mdeamorin.webapps.cookies.services.CookieServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final static String USERNAME = "admin";
    private final static String PASSWORD = "12345";
    private CookieService cookieService = new CookieServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Optional<String> foundCookie = cookieService.getCookieValue(req, "username");
        
        if(foundCookie.isPresent()) {
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Hola " + foundCookie.get() + "</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Hola " + foundCookie.get() + " has iniciado sesion con exito</h1>");
                out.println("        <p><a href=\"" + req.getContextPath()  + "/index.html\">Volver</a></p>");
                out.println("        <p><a href=\"" + req.getContextPath()  + "/logout\">Cerrar Sesion</a></p>");
                out.println("    </body>");
                out.println("</html>");
            }
        } else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(USERNAME.equals(username) && PASSWORD.equals(password)) {
            Cookie userInfo = new Cookie("username", username);
            resp.addCookie(userInfo);

            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "El usuario no se encuentra autorizado para ingresar.");
        }
    }
}
