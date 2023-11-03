package org.mdeamorin.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <meta charset=\"UTF-8\">");
        out.println("        <title>Hola Mundo Servlet</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1>Tarea 1: Servlet y envio de Parametros</h1>");
        if(name != null && surname != null) {
            LocalDate today = LocalDate.now();
            out.println("<h2> Bienvenido " + name + " " + surname + "</h2>");
            out.println(
                "<h3> La fecha actual es: " 
                + today.getDayOfMonth() 
                + " de " 
                + today.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()) 
                + ", " + today.getYear() 
                + "</h3>"
            );
        } else {
            out.println("<h2>Se debe proporcionar un nombre y apellido</h2>");
        }

        out.println("    </body>");
        out.println("</html>");
        out.close();
    }
}
