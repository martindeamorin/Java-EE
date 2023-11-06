package org.mdeamorin.webapp.headers.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.mdeamorin.webapp.headers.models.Product;
import org.mdeamorin.webapp.headers.services.ProductService;
import org.mdeamorin.webapp.headers.services.ProductServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/products.json")
public class ProductJsonServlet extends HttpServlet{
    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.retrieve();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(products);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }

     
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream body = req.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.readValue(body, Product.class);

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Detalle de producto</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("       <h1>Detalle producto</h1>");
            out.println("       <ul>");
            out.println("           <li> ID: " + product.getId() + "</li>");
            out.println("           <li> Nombre: " + product.getName() + "</li>");
            out.println("           <li> Tipo: " + product.getType() + "</li>");
            out.println("           <li> Precio: " + product.getPrice() + "</li>");
            out.println("       </ul>");
            out.println("    </body>");
            out.println("</html>");
        }
    }
}
