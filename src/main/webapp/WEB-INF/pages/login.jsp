<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Wear & Share - Login</title>
    <link rel="stylesheet" type="text/css" href="login.css">
</head>

<body>

<!-- ================= HEADER ================= -->
<header class="site-header">
    <div class="header-logo">
        WEAR & SHARE
    </div>

    <div class="header-title">
        <h1>WEAR & SHARE</h1>
        <p>SHARE • STYLE • SUSTAIN</p>
    </div>
</header>

<!-- ================= MAIN CONTENT ================= -->
<div class="main-content">

    <!-- LEFT COLUMN -->
    <div class="col-left">

        <div class="brand-image-placeholder">
            <span>BRAND IMAGE</span>
        </div>

        <div class="tagline-box">
            FASHION THAT CONNECTS PEOPLE
        </div>

    </div>

    <div class="divider"></div>

    <!-- CENTER COLUMN (LOGIN FORM) -->
    <div class="col-center">

        <h2>LOGIN</h2>

        <!-- ERROR MESSAGE -->
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
            <div class="error-msg"><%= error %></div>
        <%
            }
        %>

        <form action="LoginServlet" method="post">

            <div class="form-group">
                <label>Username</label>
                <input type="text" name="username" placeholder="Enter username" required>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" placeholder="Enter password" required>
            </div>

            <button type="submit" class="btn-login">LOGIN</button>

        </form>

        <p class="signup-prompt">Don’t have an account?</p>
        <a href="signup.jsp" class="btn-signup">SIGN UP</a>

    </div>

    <div class="divider"></div>

    <!-- RIGHT COLUMN -->
    <div class="col-right">

        <img src="images/fashion.jpg" class="fashion-img" alt="Fashion Image">

        <!-- fallback placeholder -->
        <div class="img-placeholder">
            IMAGE NOT FOUND
        </div>

    </div>

</div>

<!-- ================= FOOTER ================= -->
<footer class="site-footer">
    © 2026 Wear & Share | All Rights Reserved
</footer>

</body>
</html>