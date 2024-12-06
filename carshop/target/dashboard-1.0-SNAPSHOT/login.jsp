<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="login-container">
            <h2>Admin Login</h2>
            <form id="login-form" action="checklogin" method="post">
                <label for="username">Username:</label>
                <input name="user" type="text" id="inputUsername" required>

                <label for="password">Password:</label>
                <input name="pass" type="password" id="inputPassword" required>
                <br> <br>
                <button type="submit">Login</button>
                <% if (request.getAttribute("mess") != null) { %>
                <p class="error-message">
                    <%= request.getAttribute("mess") %>
                </p>
                <% } %>
            </form>
        </div>
    </body>
</html>
