<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!doctype html>
<html lang="es">
	<head>
		<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	    <meta name="description" content="Conmigo - Tu Web Amiga">
	    <meta name="author" content="dsbc">
	    <meta name="_csrf" content="${_csrf.token}"/>
	    
	    <link rel="icon" href="../../favicon.ico">
		<title><tiles:importAttribute name="title" /></title>
	
	    <!-- Bootstrap core CSS -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	    <link href="${pageContext.request.contextPath}/resources/css/sticky-footer-navbar.css" rel="stylesheet">
	    <tiles:insertAttribute name="pageCssStyle" />
	    <!-- Custom styles for this template -->
	    <link href="${pageContext.request.contextPath}/resources/css/conmigo.css" rel="stylesheet">
	</head>
	<body>
		<header>
			<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
				<tiles:insertAttribute name="header" />
			</nav>
		</header>
		
		<main role="main" class="container">
		  <tiles:insertAttribute name="body" />
		</main>
		
		<footer class="footer">
		  <div class="container">
		  	<tiles:insertAttribute name="footer" />
		  </div>
		</footer>
		
		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<tiles:insertAttribute name="pageScripts" /> 
		<tiles:insertAttribute name="customScripts" />  
	</body>
</html>
