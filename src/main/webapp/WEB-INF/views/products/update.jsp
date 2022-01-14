<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier produit</title>
</head>
<body>
	<form:form modelAttribute="product" method="post">
		<form:input path="product" cssErrorClass="erreur"/>
		<form:errors path="product"/>
		<form:hidden path="id"/>
		<input type="submit" value="Modifier produit">
	</form:form>
</body>
</html>