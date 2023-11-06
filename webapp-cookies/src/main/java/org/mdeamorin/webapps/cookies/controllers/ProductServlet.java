package org.mdeamorin.webapps.cookies.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import org.mdeamorin.webapps.cookies.models.Product;
import org.mdeamorin.webapps.cookies.services.CookieService;
import org.mdeamorin.webapps.cookies.services.CookieServiceImpl;
import org.mdeamorin.webapps.cookies.services.ProductService;
import org.mdeamorin.webapps.cookies.services.ProductServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/products.html", "/products"})
public class ProductServlet extends HttpServlet{
    private ProductService productService = new ProductServiceImpl();
    private CookieService cookieService = new CookieServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.retrieve();
        resp.setContentType("text/html");
        Optional<String> foundCookie = cookieService.getCookieValue(req, "username");

        
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Resultado form</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Listado Productos</h1>");
            if(foundCookie.isPresent()){
                out.println("      <h3 style=\"color: blue\">Hola " + foundCookie.get() + "</h3>");
            }
            out.println("        <table>");
            out.println("           <thead>");
            out.println("               <tr>");
            out.println("                   <th>ID</th>");
            out.println("                   <th>Name</th>");
            out.println("                   <th>Type</th>");
            if(foundCookie.isPresent()){
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
                if(foundCookie.isPresent()){
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
