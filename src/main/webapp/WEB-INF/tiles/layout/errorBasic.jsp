<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<meta name="google-signin-client_id" content="<spring:message code='property.google.appId' />">	
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta charset="UTF-8">
	<title><tiles:getAsString name="title" /></title>
	<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">   
	<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/basic.css"/>
	<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/media-queries.css"/>
	<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/drawer.css"/>
</head>
<body class="drawer drawer--left <tiles:getAsString name="bodyClass" />">  
	  <div class="page">
        <tiles:insertAttribute name="header" />
        <main class="col-xs-12" role="main">
			<div class="content-container">
	            <tiles:insertAttribute name="body" />
	        </div>
       </main>
       <tiles:insertAttribute name="footer" />
    </div>	
    <tiles:insertAttribute name="pageScripts" /> 
    <tiles:insertAttribute name="customScripts" /> 
</body>
</html>