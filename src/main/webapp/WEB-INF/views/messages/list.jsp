<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="/WEB-INF/views/includes/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Liste des messages</title>
</head>
<body>
	<h1>Liste des messages</h1>
	<c:forEach var="m" items="${messages}">
		<p>
		<span>${m} </span>
		<!-- afficher le bouton si user est un admin -->
		<span>
		<sec:authorize access="hasRole('ADMIN')">
		<a href="${contextPath}/messages/supprimer">Supprimer</a>
		</sec:authorize>
		</span>
		
		</p>
	</c:forEach>
	<a href="/deconnecter">Se connecter</a>
</body>
</html>