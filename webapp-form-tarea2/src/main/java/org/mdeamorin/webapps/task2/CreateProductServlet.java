package org.mdeamorin.webapps.task2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class CreateProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        getServletContext()
        .getRequestDispatcher("/new-product.jsp")
        .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String> errors = new HashMap<String, String>();

        String name = req.getParameter("name");
        Integer price;
        try {
            price = Integer.parseInt(req.getParameter("price"));
        } catch (NumberFormatException e) {
            errors.put("price", "Debe ingresar un precio expresado en enteros para su producto.");
        }
        String manufacter = req.getParameter("manufacter");
        String[] categories = req.getParameterValues("categories");

        if(name == null || name.isBlank()) errors.put("name", "Debe ingresar un nombre para su producto.");
        if(manufacter == null || manufacter.isBlank() || !(manufacter.length() >= 4 && manufacter.length() <= 10)) errors.put("manufacter", "Debe ingresar un fabricante para su producto (entre 4 y 10 caracteres)");
        if(categories == null || categories.length == 0) errors.put("categories", "Debe ingresar al menos una categoria para su producto.");

        if(!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            getServletContext()
                .getRequestDispatcher("/new-product.jsp")
                .forward(req, resp);            
        };

        getServletContext()
            .getRequestDispatcher("/product.jsp")
            .forward(req, resp);
    }
}
