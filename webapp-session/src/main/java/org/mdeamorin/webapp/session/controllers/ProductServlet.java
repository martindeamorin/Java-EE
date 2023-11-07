package org.mdeamorin.webapp.session.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.mdeamorin.webapp.session.models.Product;
import org.mdeamorin.webapp.session.services.SessionService;
import org.mdeamorin.webapp.session.services.SessionServiceImpl;
import org.mdeamorin.webapp.session.services.ProductService;
import org.mdeamorin.webapp.session.services.ProductServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/products.html", "/products"})
public class ProductServlet extends HttpServlet{
    private ProductService productService = new ProductServiceImpl();
    private SessionService sessionService = new SessionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.retrieve();
        resp.setContentType("text/html");
        String foundSessionValue = sessionService.getSessionValue(req, "username");

        
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Resultado form</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Listado Productos</h1>");
            if(foundSessionValue != null){
                out.println("      <h3 style=\"color: blue\">Hola " + foundSessionValue + "</h3>");
            }
            out.println("        <table>");
            out.println("           <thead>");
            out.println("               <tr>");
            out.println("                   <th>ID</th>");
            out.println("                   <th>Name</th>");
            out.println("                   <th>Type</th>");
            if(foundSessionValue != null){
                out.println("                   <th>Price</th>");
            }
            out.println("               </tr>");
            out.println("           </thead>");
            out.println("           <tbody>");
            products.forEach(product -> {
                out.println("           <tr>");
                out.println("               <td>" + product.getId() + "</td>");
                out.println("               <td>" + product.getName() + "</td>");
                out.println("               <td>" + product.getType() + "</td>");
                if(foundSessionValue != null){
                    out.println("               <td>" + product.getPrice() + "</td>");
                }
                out.println("           </tr>");
            });
            out.println("           </tbody>");            
            out.println("        </table>");
            out.println("    </body>");
            out.println("</html>");            

        }
    }

}
