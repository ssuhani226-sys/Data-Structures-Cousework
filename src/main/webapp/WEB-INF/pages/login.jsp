<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/Coursework/css/login.css">
</head>
<body>

<div class="container">
    <div class="card">

        <h2>Welcome Back</h2>

        <form action="${pageContext.request.contextPath}/login" method="post">
            <input type="email" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Login</button>
        </form>

        <p>Don't have an account? 
            <a href="${pageContext.request.contextPath}/register">Register</a>
        </p>

        <%
            if(request.getAttribute("error") != null){
        %>
            <p class="error"><%= request.getAttribute("error") %></p>
        <%
            }
        %>

    </div>
</div>

</body>
</html>