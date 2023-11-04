package org.mdeamorin.apiservlet.webapp.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sign-up")
public class FormServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        String[] planguages = req.getParameterValues("planguages");
        String[] roles = req.getParameterValues("roles");
        String language = req.getParameter("language");
        String enable = req.getParameter("enable");
        String secret = req.getParameter("secret");

        List<String> errors = new ArrayList<>();
        if(username == null || username.isBlank()) {
            errors.add("The username is required.");
        }

        if(password == null || password.isBlank()) {
            errors.add("The password is required.");
        }

        if(email == null || email.contains("@")) {
            errors.add("The email is required.");
        }
        
        if(country == null || country.isBlank()) {
            errors.add("The country is required.");
        }

        if(language == null) {
            errors.add("The language is required.");
        }   

        if(planguages == null || planguages.length == 0) {
            errors.add("Programming languages are requiered.");
        }

        if(roles == null || roles.length == 0) {
            errors.add("Roles are requiered.");
        }

        if(enable == null) {
            enable = "off";
        }

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Resultado form</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Resultado form!</h1>");
            out.println("        <ul>");
            out.println("           <li>Username: " + username + "</li>");
            out.println("           <li>Password: " + password + "</li>");
            out.println("           <li>Email: " + email + "</li>");
            out.println("           <li>Country: " + country + "</li>");
            out.println("         <li>Languages: <ul>");
            Arrays.asList(planguages).forEach(planguage -> {
                                            out.println("<li>" + planguage + "</li>");
            });
            out.println("           </ul>");
            out.println("         <li>Roles: <ul>");
            Arrays.asList(roles).forEach(role -> {
                                            out.println("<li>" + role + "</li>");
            });
            out.println("           </ul>");
            out.println("           <li>Language: " + language + "</li>");
            out.println("           <li>Enabled: " + enable + "</li>");
            out.println("           <li>Secret: " + secret + "</li>");            
            out.println("        </ul>");
            out.println("    </body>");
            out.println("</html>");            
        }
    }
}
