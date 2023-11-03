package org.mdeamorin.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/param/get-url")
public class ParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String greeting = req.getParameter("greeting");
        String name = req.getParameter("name");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <meta charset=\"UTF-8\">");
        out.println("        <title>Hola Mundo Servlet</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1>Hola Mundo Parameter!</h1>");
        if(greeting != null && name != null) {
            out.println("<h2>" + greeting + " " + name + "</h2>");
        } else if(greeting != null) {
            out.println("<h2>" + greeting + " desconocido</h2>");
        } else if (name != null){
            out.println("<h2>Hola " + name + "</h2>");
        } else {
            out.println("<h2>Hola desconocido</h2>");
        }
        try{
            Integer code = Integer.valueOf(req.getParameter("code"));
            out.println("<h3>El codigo enviado es: " + code + "</h3>");
        } catch (NumberFormatException e) {
            out.println("<h3>No se ha enviado un codigo, o se envio en el formato equivocado</h3>");
        }
        out.println("    </body>");
        out.println("</html>");
        out.close();
    }
}
