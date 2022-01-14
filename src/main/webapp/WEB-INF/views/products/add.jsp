<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire d'ajout</title>
</head>
<body>
	<h1>Formulaire d'ajout</h1>
	<form:form modelAttribute="product" method="post">
		<div>
			<label for="isbn">ISBN</label>
			<!-- message=mon message -->
			<form:input id="isbn" path="isbn" cssErrorClass="erreur"/>
			<form:errors path="isbn"/>
			<form:hidden path="id"/>
			<br> 
			<label for="nom">Nom</label>
			<!-- message=mon message -->
			<form:input id="nom" path="nom" cssErrorClass="erreur"/>
			<form:errors path="nom"/>
			<form:hidden path="id"/>
			<br> 
			<label for="designation">Designation</label>
			<!-- message=mon message -->
			<form:input id="designation" path="designation" cssErrorClass="erreur"/>
			<form:errors path="designation"/>
			<form:hidden path="id"/>
			<br> 
			<label for="prixHT">Prix HT</label>
			<!-- message=mon message -->
			<form:input id="prixHT" path="prixHT" cssErrorClass="erreur"/>
			<form:errors path="prixHT"/>
			<form:hidden path="id"/>
			<br> 
			<label for="stock">Stock</label>
			<!-- message=mon message -->
			<form:input id="stock" path="stock" cssErrorClass="erreur"/>
			<form:errors path="stock"/>
			<form:hidden path="id"/>
			<br> 
			<label for="categorie">Categorie</label>
			<!-- message=mon message -->
			<form:input id="categorie" path="categorie" cssErrorClass="erreur"/>
			<form:errors path="categorie"/>
			<form:hidden path="id"/>
			<br> 
			<!-- afficher message d'erreur si le champ est invalide -->
			<c:if test="${erreur != null}">
				<p>${erreur}</p>
			</c:if>
		</div>

		<div>
			<input type="submit" value="Créer produit">
		</div>

	</form:form>
</body>
</html>