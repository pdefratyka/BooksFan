<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<c:url value="/resources/styles/addBookSe.css"/>">
<title>Add book</title>
</head>
<body>
	<div id="someCtrl" data-ng-controller="defaultCtrl">
		<div id="addBook">
			<input id="title" type="text" placeholder="Title..."> 
			<input id="author" type="text" placeholder="Author...">
			<input id="year" type="text" placeholder="Year..."> 
			<input id="image" type="text" placeholder="Image...">
			<input type="button" value="Submit" ng-click="addBook()">				
		</div>
	</div>

	<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.0-beta.5/angular.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/ajaxScript.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/addBookS.js"/>"></script>

</body>
</html>