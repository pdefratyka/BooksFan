<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<c:url value="/resources/styles/loginSe.css"/>">
<title>Login</title>
</head>
<body>
  <div id="someCtrl"  data-ng-controller="defaultCtrl">
    <div id="loginDiv">
      <input id="login" type="text" placeholder="Login...">
      <input id="password" type="password" placeholder="Password..." ng-keypress="loginFunction($event)">
      <input type="button" value="Login" ng-click="login()">
      <input type="button" value="Home" ng-click="back()">
    </div>
  </div>

	<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.0-beta.5/angular.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/ajaxScript3.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/loginS2.js"/>"></script>

</body>
</html>
