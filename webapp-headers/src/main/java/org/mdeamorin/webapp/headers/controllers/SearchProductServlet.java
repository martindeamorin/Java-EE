package org.mdeamorin.webapp.headers.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import org.mdeamorin.webapp.headers.models.Product;
import org.mdeamorin.webapp.headers.services.ProductService;
import org.mdeamorin.webapp.headers.services.ProductServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/search-product")
public class SearchProductServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/search-product.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String product = req.getParameter("product");

        if(product.isBlank()) resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "No puede mandar el campo vacio.");
        
        Optional<Product> found = productService.search(product);

        if(found.isPresent()){
            Product foundProduct = found.get();
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Producto Encontrado</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("       <h1>Producto Encontrado</h1>");
                out.println("          <ul>");
                out.println("               <li> ID: " + foundProduct.getId() +"</li>");
                out.println("               <li> Nombre: " + foundProduct.getName() +"</li>");
                out.println("               <li> Tipo: " + foundProduct.getType() +"</li>");
                out.println("               <li> Precio: " + foundProduct.getPrice() +"</li>");
                out.println("          </ul>");
                out.println("    </body>");
                out.println("</html>");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No se encontro el producto con el nombre " + product);
        }

    }
}
