<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<c:url value="/resources/styles/bookSe.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/styles/homeSe.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/styles/particularBookSe.css"/>">
<title>Particular Book</title>
</head>
<body onload="ajaxLoadBook(${userId})">
  <div id="mainCtrl"  data-ng-controller="defaultCtrl">
    <div id="header">
      <div id="logo" ng-click="pageLogoFunction()">
        <img src="/BookWeb/resources/styles/images/logo.png">
        <h2>BOOKWEB</h2>
      </div>

      <input type="text" placeholder="Title or Author..." class="Search" ng-model="searchValue" ng-keypress="searchFunction($event)">
      <input type="button" ng-click="search()" id="searchButton">
      <div id="login">
        <a href="/BookWeb/login">Log in</a><span>  /  </span><a href="/BookWeb/register">Register</a>
      </div> 
        <nav class="profile">
          <ul>
            <li class="profileParent">
               <!--There should be ${name} instead of Profile
                   Ewentually you'll have to change function if-->
              <img src="/BookWeb/resources/styles/images/profile.png" value="${name}" id="profileButton" ng-click="profile('${userId}')">
              <h3>${name}</h3>
              <ul>
                <li><input type="button" value="Profile" ng-click="profile('${userId}')"></li>
                <li><input type="button" value="Logout" ng-click="logout()"></li>
              </ul>
            </li>
          </ul>
        </nav>
    </div>
    <div id="description">
      <img src="{{book.img}}" style="float:left;" class="bookImage">
      <div style="float:left">
        <h5>Title: {{book.title}}</h5>
        <h5>Author: {{book.author}}</h5>
        <h5>Year: {{book.year}}</h5>
      </div></br>

      <div id="rateMenu">
        <h4>Rate: {{book.rate}}</h4>
        <h4>Views: {{book.views}}</h4>
        <p2>I want to read</p2><input type="checkbox" id="wantReadCheck" ng-click="wantToRead()">
        <h4>My rate:{{personalRate}}</h4>
        <dvi class="rating">
          <span data-ng-repeat="rate in rateList" ng-click="userRate(rate)">☆</span>

        </div>
      </div>
      <div id="commentSection" ng-model="coment">
        <textarea ng-model="comment" cols="40" rows="3" placeholder="Here you can add your comment.It will be visible just for you"></textarea>
        <input type="button" value="save" ng-click="saveComment()">
      </div>
      <div id="yourComment">
     	<span>{{comment}}</span>
      </div>
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
		src="<c:url value="/resources/scripts/particularBookS.js"/>"></script>

</body>
</html>