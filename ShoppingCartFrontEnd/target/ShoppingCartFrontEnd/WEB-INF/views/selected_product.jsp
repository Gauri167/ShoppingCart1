<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="cart/add" method="post">
<%-- 
<img alt="" src="${selectedProductImage}"><br> --%>
<img alt="" src="resources/images/${selectedProduct.id}.PNG"><br>

Name:<input type="text" disabled="disabled" name="productName" value="${selectedProduct.name}"><br>
Price:<input type="text" disabled="disabled" name="price" value="${selectedProduct.price}"><br>
Quantity:<input type="text" name="quantity"><br>
Description:${selectedProduct.description}<br>
<input type="submit" value="Add to Cart">

</form>


<%-- <a href="cart/add?productName=${selectedProduct.name}&price=${selectedProduct.price}&quantity=1">Add To Cart</a>
 --%>
</body>
</html>