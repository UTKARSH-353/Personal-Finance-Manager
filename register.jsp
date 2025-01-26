<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>User Registration</title></head>
<body>
    <h2>Register New User</h2>
    <form action="personalFinanceManager" method="post">
        <input type="hidden" name="action" value="register">
        Username: <input type="text" name="username" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        Email: <input type="email" name="email" required><br><br>
        <input type="submit" value="Register">
    </form>

    <h3>Already have an account? <a href="personalFinanceManager">Login here</a></h3>
</body>
</html>
