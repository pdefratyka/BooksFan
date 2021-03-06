<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<c:url value="/resources/styles/profileSe.css"/>">
<title>Profile</title>
</head>
<body data-ng-controller="defaultCtrl" id="someCtrl" onload="ajaxLoadYourBooks()">
  <div id="header">
    <div id="pageLogo" ng-click="pageLogoFunction()">
      <img src="https://image.ibb.co/ivTmc6/logo.png" id="logoIcon">
      <h2>BooksFan</h2>
    </div>
         <nav class="profile">
          <ul>
            <li class="profileParent">
               <!--There should be ${name} instead of Profile
                   Ewentually you'll have to change function if-->
              <img src="https://image.ibb.co/bMof4m/profile.png" value="${name}" id="profileButton" ng-click="profile('${userId}')">
              <h3>${name}</h3>
              <ul>
                <li><input type="button" value="Profile" ng-click="profile('${userId}')"></li>
                <li><input type="button" value="Logout" ng-click="logout()"></li>
              </ul>
            </li>
          </ul>
        </nav>
    <div id="lowBar">
      <h2 ng-click="readBooksFunction()">Read books</h2>
      <h2 ng-click="wantToReadFunction()">Want to read</h2>
      <h2 ng-click="addBookFunction('${userId}')">Add book</h2>
    </div>
  </div>
  <div id="center">
    <div id="options">
      <input class="FilterInput" ng-model="search.title" placeholder="Title...">
      <input class="FilterInput" ng-model="search.author" placeholder="Author...">
      <!-- <input class="FilterInput" ng-model="search.year" placeholder="Year...">
      <input class="FilterInput" ng-model="search.rate" placeholder="Rate..."> -->
      <h3 ng-click="sortTitlesByAlphabet()">Sort titles by Alphabet</h3>
      <h3 ng-click="sortAuthorsByAlphabet()">Sort authors by Alphabet</h3>
      <!--  <h3 ng-click="sortByYear()">Sort by Year</h3>
      <h3>Sort by Date</h3>
      <h3>Sort by General rate</h3>
      <h3 ng-click="sortByYourRate()">Sort by Your rate</h3>-->
    </div>
    <div id="mainPage">
      <div class="bookFrame" data-ng-repeat="book in bookList | filter:myFilter" ng-click="selectBook(book.id)" ng-mouseenter="mouseOver($event,true);" ng-mouseleave="mouseOver($event,false)" >
        <img src="{{book.img}}" style="float:left;" class="bookImage">
        <div style="float:left">
          <h5>Title: {{book.title}}</h5>
          <h5>Author: {{book.author}}</h5>
          <h5>Year: {{book.year}}</h5>
          <h5>Rate: {{book.rate}}</h5>
        </div></br>
      </div>
    </div>
  </div>
  <div id="footer">
  </div>
	<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.0-beta.5/angular.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/profileScript.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/ajaxScript3.js"/>"></script>


</body>
</html>