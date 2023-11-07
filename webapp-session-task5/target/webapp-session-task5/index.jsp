<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Tarea 5: Session HTTP</h1>
    <p>Hola, ${sessionScope.username != null ? sessionScope.username : "anonimo"}</p>
    <form action="/webapp-session-task5/save-name" method="post">
    <div>
        <label for="username">Nombre de usuario</label>
        <div>
            <input type="text" name="username" id="username">
        </div>
    </div>
    <div>
        <input type="submit" value="Ingresar">
    </div>
    </form>
</body>
</html>