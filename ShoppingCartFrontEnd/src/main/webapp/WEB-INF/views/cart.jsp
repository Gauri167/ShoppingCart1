<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<c:forEach var="cart" items="${cartList}">

<%-- <img alt="" src="${ImagesFolder}${cart.productid}.PNG"> --%>
<img alt="" src="resources/images/productImages/${cart.productid}.PNG">
Name:<input type="text" name="productname" value="${cart.productName}"><br>
Price:<input type="text" name="price" value="${cart.price}"><br>
Quantity:<input type="text" name="quantity" value="${cart.quantity}"><br>
</c:forEach>

</body>
</html>