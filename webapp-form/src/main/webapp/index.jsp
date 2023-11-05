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
    <title>Forumulario de usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
    <h3>Formularios de usuarios</h3>

    <%
        if(errors != null && errors.size() > 0){
    %>
    <ul class="alert alert-danger mx-5 px-5">
    <%
    for(String error: errors.values()) {
    %>
    <li><%=error%></li>
    <% } %>
    </ul>
    <% } %>
    <div class="px-5">
        <form action="/webapp-form/sign-up" method="post">
            <div class="row mb-3">
                <label class="col-form-label col-sm-2" for="username">Username</label>
                <div class="col-sm-4">
                    <input class="form-control" type="text" name="username" id="username" value="${param.username}">
                </div>
                <%
                    if(errors != null && errors.containsKey("username")){
                        out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("username") + "</small>");
                    }
                %>
            </div>
            <div class="row mb-3">
                <label class="col-form-label col-sm-2" for="password">Password</label>
                <div class="col-sm-4">
                    <input class="form-control" type="password" name="password" id="password" value="${param.password}">
                </div>
                <%
                    if(errors != null && errors.containsKey("password")){
                        out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("password") + "</small>");
                    }
                %>            
            </div>
            <div class="row mb-3">
                <label class="col-form-label col-sm-2" for="email">Email</label>
                <div class="col-sm-4">
                    <input class="form-control" type="email" name="email" id="email" value="${param.email}">
                </div>
                <%
                    if(errors != null && errors.containsKey("email")){
                        out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("email") + "</small>");
                    }
                %>
            </div>
            <div class="row mb-3">
                <label class="col-form-label col-sm-2" for="country">Country</label>
                <div class="col-sm-4">
                    <select name="country" id="country" class="form-select">
                        <option selected value="">Select a country.</option>
                        <option value="SP" ${param.country.equals("SP") ? "selected" : ""}>Spain</option>
                        <option value="MX" ${param.country.equals("MX") ? "selected" : ""}>Mexico</option>
                        <option value="CL" ${param.country.equals("CL") ? "selected" : ""}>Chile</option>
                        <option value="AR" ${param.country.equals("AR") ? "selected" : ""}>Argentina</option>
                        <option value="PE" ${param.country.equals("PE") ? "selected" : ""}>Peru</option>
                        <option value="CO" ${param.country.equals("CO") ? "selected" : ""}>Colombia</option>
                        <option value="VE" ${param.country.equals("VE") ? "selected" : ""}>Venezuela</option>
                    </select>
                </div>
                <%
                    if(errors != null && errors.containsKey("country")){
                        out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("country") + "</small>");
                    }
                %>
            </div>
            <div class="row mb-3">
                <label class="col-form-label col-sm-2" for="planguages">Programming Languages</label>
                <div class="col-sm-4">
                    <select name="planguages" id="planguages" multiple class="form-select">
                        <option selected value="" disabled>Select a language.</option>
                        <option value="java" ${paramValues.planguages.stream().anyMatch(v -> v.equals("java")).get() ? "selected" : ""}>Java SE</option>
                        <option value="jakartaee" ${paramValues.planguages.stream().anyMatch(v -> v.equals("jakartaee")).get() ? "selected" : ""}>Jakarta EE</option>
                        <option value="spring" ${paramValues.planguages.stream().anyMatch(v -> v.equals("spring")).get() ? "selected" : ""}>Spring Boot</option>
                        <option value="javascript" ${paramValues.planguages.stream().anyMatch(v -> v.equals("javascript")).get() ? "selected" : ""}>JavaScript</option>
                        <option value="angular" ${paramValues.planguages.stream().anyMatch(v -> v.equals("angular")).get() ? "selected" : ""}>Angular</option>
                        <option value="react" ${paramValues.planguages.stream().anyMatch(v -> v.equals("react")).get() ? "selected" : ""}>React</option>
                    </select>
                </div>
                <%
                    if(errors != null && errors.containsKey("planguages")){
                        out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("planguages") + "</small>");
                    }
                %>
            </div>
            <div class="row mb-3">
                <label class="col-form-label col-sm-2" for="roles">Role/s</label>
                <div class="form-check col-sm-2">
                    <input type="checkbox" name="roles" value="ROLE_ADMIN" class="form-check-input" ${paramValues.roles.stream().anyMatch(v -> v.equals("ROLE_ADMIN")).get() ? "checked" : ""}>
                    <label class="form-check-label">Administrator</label>
                </div>
                <div class="form-check col-sm-2">
                    <input checked type="checkbox" name="roles" value="ROLE_USER" class="form-check-input" ${paramValues.roles.stream().anyMatch(v -> v.equals("ROLE_USER")).get() ? "checked" : ""}>
                    <label class="form-check-label">User</label>
                </div>
                <div class="form-check col-sm-2">
                    <input type="checkbox" name="roles" value="ROLE_MODERATOR" class="form-check-input" ${paramValues.roles.stream().anyMatch(v -> v.equals("ROLE_MODERATOR")).get() ? "checked" : ""}>
                    <label class="form-check-label">Moderator</label>
                </div>
                <%
                    if(errors != null && errors.containsKey("roles")){
                        out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("roles") + "</small>");
                    }
                %>
            </div>
            <div class="row mb-3">
                <label class="col-form-label col-sm-2">Languages</label>
                <div class="form-check col-sm-2">
                    <input type="radio" name="language" value="es" class="form-check-input" ${param.language.equals("es") ? "checked" : ""}>
                    <label class="form-check-label">Spanish</label>
                </div>
                <div class="form-check col-sm-2">
                    <input type="radio" name="language" value="en" class="form-check-input" ${param.language.equals("en") ? "checked" : ""}>
                    <label class="form-check-label">English</label>
                </div>
                <div class="form-check col-sm-2">
                    <input type="radio" name="language" value="fr" class="form-check-input" ${param.language.equals("fr") ? "checked" : ""}>
                    <label class="form-check-label">French</label>
                </div>
                <%
                    if(errors != null && errors.containsKey("language")){
                        out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>" + errors.get("language") + "</small>");
                    }
                %>
            </div>
            <div class="row mb-3">
                <label class="form-check-label col-sm-2" for="enable">Enabled</label>
                <div class="form-check col-sm-2">
                    <input type="checkbox" name="enable" id="enable" checked class="form-check-input">
                </div>
            </div>
            <div class="row mb-3">
                <div>
                    <input type="submit" value="Send" class="btn btn-primary">
                </div>
            </div>
            <input type="hidden" name="secret" value="12345">
        </form>
    </div>
</body>
</html>