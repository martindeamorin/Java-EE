<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Iniciar Sesion</h1>
    <form action="/webapp-cookies/login" method="post">
        <div>
            <label for="username">Nombre Usuario</label>
            <div>
                <input type="text" name="username" id="username">
            </div>
        </div>
        <div>
            <label for="password">Contrasena</label>
            <div>
                <input type="password" name="password" id="password">
            </div>
        </div>
        <input type="submit" value="Send">
    </form>
</body>
</html>