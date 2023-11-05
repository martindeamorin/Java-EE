<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<% 
    Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Producto</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
    <div class="px-5">
        <h1>Creacion de producto</h1>
        <form action="/webapp-form-tarea2/product" method="post">
            <div class="row mb-3">
                <label class="col-form-label col-sm-2" for="name">Nombre</label>
                <div class="col-sm-4">
                    <input type="text" name="name" id="name" value="${param.name}" class="form-control">
                </div>
                <% if(errors != null && errors.containsKey("name")) { %>
                    <small class='alert alert-danger col-sm-4' style="color: red;"><%= errors.get("name") %></small>
                <% } %>
            </div>
            <div class="row mb-3">
                <label class="col-form-label col-sm-2" for="price">Precio</label>
                <div class="col-sm-4">
                    <input type="number" name="price" id="price" value="${param.price}" class="form-control">
                </div>
                <% if(errors != null && errors.containsKey("price")) { %>
                    <small class='alert alert-danger col-sm-4' style="color: red;"><%= errors.get("price") %></small>
                <% } %>
            </div>
            <div class="row mb-3">
                <label class="col-form-label col-sm-2" for="manufacter">Fabricante</label>
                <div class="col-sm-4">
                    <input type="text" name="manufacter" id="manufacter" value="${param.manufacter}" class="form-control">
                </div>
                <% if(errors != null && errors.containsKey("manufacter")) { %>
                    <small class='alert alert-danger col-sm-4' style="color: red;"><%= errors.get("manufacter") %></small>
                <% } %>
            </div>
            <div class="row mb-3">
                <label class="col-form-label col-sm-2" for="categories">Categorias</label>
                <div class="form-check col-sm-2">
                    <input type="checkbox" class="form-check-input" name="categories" id="categories" value="Tecnologia" ${paramValues.categories.stream().anyMatch(v -> v.equals("Tecnologia")).get() ? "checked" : ""}>
                    <label class="form-check-label">Tecnologia</label>
                </div>
                <div class="form-check col-sm-2">
                    <input type="checkbox" class="form-check-input" name="categories" id="categories" value="Alimento" ${paramValues.categories.stream().anyMatch(v -> v.equals("Alimento")).get() ? "checked" : ""}>
                    <label class="form-check-label">Alimento</label>
                </div>
                <div class="form-check col-sm-2">
                    <input type="checkbox" class="form-check-input" name="categories" id="categories" value="Vestimenta" ${paramValues.categories.stream().anyMatch(v -> v.equals("Vestimenta")).get() ? "checked" : ""}>
                    <label class="form-check-label">Vestimenta</label>
                </div>
                <div class="form-check col-sm-2">
                    <input type="checkbox" class="form-check-input" name="categories" id="categories" value="Hogar" ${paramValues.categories.stream().anyMatch(v -> v.equals("Hogar")).get() ? "checked" : ""}>
                    <label class="form-check-label">Hogar</label>
                </div>
                <% if(errors != null && errors.containsKey("categories")) { %>
                    <small class='alert alert-danger col-sm-4 m-2' style="color: red;"><%= errors.get("categories") %></small>
                <% } %>
            </div>
            <input type="submit" value="Send" class="btn btn-primary">
        </form>
    </div>
</body>
</html>