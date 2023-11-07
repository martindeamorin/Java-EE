<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil</title>
</head>
<body>
    <h1>Perfil</h1>
    <ul>
        <li>Username: ${sessionScope.username}</li>
    </ul>
    <p><a href="/webapp-session-task5">Volver</a></p>
</body>
</html>