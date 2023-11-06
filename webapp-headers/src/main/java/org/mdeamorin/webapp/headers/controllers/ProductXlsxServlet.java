package org.mdeamorin.webapp.headers.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.mdeamorin.webapp.headers.models.Product;
import org.mdeamorin.webapp.headers.services.ProductService;
import org.mdeamorin.webapp.headers.services.ProductServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/products.xls", "/products.html", "/products"})
public class ProductXlsxServlet extends HttpServlet{
    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.retrieve();
        boolean isXLS = req.getServletPath().endsWith(".xls");
        if(isXLS) {
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition", "attachment;filename=products.xls");
        } else {
            resp.setContentType("text/html");
        }
        try (PrintWriter out = resp.getWriter()) {
            if(!isXLS) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Resultado form</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Listado Products</h1>");
                out.println("        <p><a href=\"" + req.getContextPath() + "/products.xls" + "\">Descargar EXCEL</a></p>");
                out.println("        <p><a href=\"" + req.getContextPath() + "/products.json" + "\">Descargar JSON</a></p>");

            }

            out.println("        <table>");
            out.println("           <thead>");
            out.println("               <tr>");
            out.println("                   <th>ID</th>");
            out.println("                   <th>Name</th>");
            out.println("                   <th>Type</th>");
            out.println("                   <th>Price</th>");
            out.println("               </tr>");
            out.println("           </thead>");
            out.println("           <tbody>");
            products.forEach(product -> {
                out.println("           <tr>");
                out.println("               <td>" + product.getId() + "</td>");
                out.println("               <td>" + product.getName() + "</td>");
                out.println("               <td>" + product.getType() + "</td>");
                out.println("               <td>" + product.getPrice() + "</td>");
                out.println("           </tr>");
            });
            out.println("           </tbody>");            
            out.println("        </table>");

            if(!isXLS) {
                out.println("    </body>");
                out.println("</html>");            
            }

        }
    }

}
