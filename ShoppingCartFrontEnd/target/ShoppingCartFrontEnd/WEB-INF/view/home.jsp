<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h2>welcome to home page</h2></center>
<hr color="blue" size="5">
<a href="login">Existing user</a>
<a href="registration">New user</a>
<jsp:include page="product_menu.jsp"></jsp:include>
${errorMessage}
${welcomeMessage}
<c:if test="${isUserClickedLogin==true}">
<jsp:include page="login.jsp"></jsp:include>
</c:if>
<c:if test="${isUserClickedRegister==true}">
<jsp:include page="registration.jsp"></jsp:include>
</c:if>
</body>
</html>