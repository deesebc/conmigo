<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <meta name="description" content="Conmigo - Tu Web Amiga">
    <meta name="author" content="dsbc">
    <meta name="_csrf" content="${_csrf.token}"/>
    <link rel="icon" href="../../favicon.ico">
	<title><tiles:getAsString name="title" /></title>
	<!-- Bootstrap core CSS -->
    <link href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/conmigo.css" rel="stylesheet">
</head>
  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
      	<tiles:insertAttribute name="header" />
      </div>
    </nav>

    <div class="container">
	  <tiles:insertAttribute name="body" />
    </div><!-- /.container -->
    
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