<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>User Profile</title></head>
<body>
    <h2>User Profile</h2>
    <p>Username: ${user.username}</p>
    <p>Email: ${user.email}</p>
    <p>Account Balance: $${user.balance}</p>
    
    <form action="personalFinanceManager" method="post">
        <input type="hidden" name="action" value="logout">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
