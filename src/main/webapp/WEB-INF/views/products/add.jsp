<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire d'ajout</title>
</head>
<body>
	<h1>Formulaire d'ajout</h1>
	<form method="post">
		<div>
			<label for="product">Produit</label>
			<!-- message=mon message -->
			<input type="text" id="product" name="product">
			<br>
			<label for="isbn">isbn</label>
			<input type="text" id="isbn" name="isbn">
			<br>
			<label for="nom">nom</label>
			<input type="text" id="nom" name="nom">
			<br>
			<label for="designation">designation</label>
			<input type="text" id="designation" name="designation">
			<br>
			<label for="prixHT">prixHT</label>
			<input type="text" id="prixHT" name="prixHT">
			<br>
			<label for="stock">stock</label>
			<input type="text" id="stock" name="stock">
			<br>
			<label for="categorie">categorie</label>
			<input type="text" id="categorie" name="categorie">
			<br>
			<!-- afficher message d'erreur si le champ est invalide -->
			<c:if test="${erreur != null}">
				<p>${erreur}</p>
			</c:if>
		</div>
		
		<div>
			<input type="submit" value="Créer produit">
		</div>
		
	</form>
	
</body>
</html>