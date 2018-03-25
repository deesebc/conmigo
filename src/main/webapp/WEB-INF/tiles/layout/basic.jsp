<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="Conmigo - Tu Web Amiga">
    <meta name="author" content="dsbc">
    <meta name="_csrf" content="${_csrf.token}"/>
    <link rel="icon" href="../../favicon.ico">

	<title><tiles:importAttribute name="title" /></title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

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
