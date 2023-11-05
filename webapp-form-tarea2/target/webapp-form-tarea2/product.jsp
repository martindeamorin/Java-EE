<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Producto registrado</title>
</head>
<body>
    <div>
        <h1>El producto se ha registrado correctamente.</h1>
        <ul>
            <li>Nombre: ${param.name}</li>
            <li>Precio: ${param.price}</li>
            <li>Fabricante: ${param.manufacter}</li>
            <li>
                Categorias:
                <% if(request.getParameterValues("categories").length > 0) { %>
                    <ul>
                        <% for(String category: request.getParameterValues("categories")) { %>
                            <li><%= category %></li>
                        <% } %>
                    </ul>
                <% } %>
            </li>
        </ul>
    </div>
</body>
</html>