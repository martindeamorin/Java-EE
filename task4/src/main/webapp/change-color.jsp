<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cambio de colores</title>
</head>
<body>
    <div>
        <h1 style="color: ${cookie["color"] != null ? cookie["color"].getValue() : "black"};">Cambio de color</h1>
        <p style="color: ${cookie["color"] != null ? cookie["color"].getValue() : "black"};">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Illo amet ipsam asperiores nisi, suscipit sed ullam, tenetur temporibus dicta totam, ipsum corrupti accusantium molestias ducimus. Consectetur voluptatum expedita aliquid eveniet.
        </p>
    </div>
    <form method="post" action="/task4/change-color">
        <label for="color">Color</label>
        <select name="color" id="color">
            <option style="color:black;" value="black" ${"black".equals(cookie["color"].getValue()) ? "selected" : ""}>Negro</option>
            <option style="color:red;" value="red" ${"red".equals(cookie["color"].getValue()) ? "selected" : ""}>Rojo</option>
            <option style="color:blue;" value="blue" ${"blue".equals(cookie["color"].getValue()) ? "selected" : ""}>Azul</option>
            <option style="color:green;" value="green" ${"green".equals(cookie["color"].getValue()) ? "selected" : ""}>Verde</option>
            <option style="color:yellow;" value="yellow" ${"yellow".equals(cookie["color"].getValue()) ? "selected" : ""}>Amarillo</option>
            <option style="color:coral;" value="coral" ${"coral".equals(cookie["color"].getValue()) ? "selected" : ""}>Coral</option>
            <option style="color:blueviolet;" value="blueviolet" ${"blueviolet".equals(cookie["color"].getValue()) ? "selected" : ""}>Violeta</option>
            <option style="color:brown;" value="brown" ${"brown".equals(cookie["color"].getValue()) ? "selected" : ""}>Marron</option>
        </select>
        <div>
            <input type="submit" value="Cambiar">
        </div>
    </form>
</body>
</html>