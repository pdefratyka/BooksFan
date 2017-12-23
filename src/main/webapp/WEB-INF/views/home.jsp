<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<c:url value="/resources/styles/homeSe.css"/>">
<title>BooksFan</title>
</head>
<body data-ng-controller="homeCtrl" id="home">
    <div id="head">
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
  	  <div id="pageHeader">
        <div id="pageLogo" ng-click="pageLogoFunction()">
          <img src="https://image.ibb.co/ivTmc6/logo.png" id="logoIcon">
          <h2>BooksFan</h2>
        </div>
    		<input type="text" placeholder="Title or Author..." class="Search"
    			ng-model="searchValue" ng-keypress="searchFunction($event)">
    	  <input type="button" ng-click="search()">
  	  </div>
      <div id="login">
        <a href="login">Log in</a><span>  /  </span><a href="register">Register</a>
      </div>
      <div id="mainBar">
       <h2 ng-click="ranking()">Ranking</h2><h2 ng-click="recentlyRead()">Recently Read</h2>
      </div>
     </div>


     <div id="center">
       <div id="slidePanel">
         <i class="arrow right" ng-click="nextSlide()"></i>
         <i class="arrow left" ng-click="previousSlide()"></i>
         <div class="circles">
           <div class="circleBase type1" ng-click="slide(this,0)"></div>
           <div class="circleBase type1" ng-click="slide(this,1)"></div>
           <div class="circleBase type1" ng-click="slide(this,2)"></div>
           <div class="circleBase type1" ng-click="slide(this,3)"></div>
           <div class="circleBase type1" ng-click="slide(this,4)"></div>
         </div>
       </div>
       <div class="article header" >
         <span ng-click="article(currentHeader)">{{currentHeader}}</span>
       </div>
       <div class="article description" >
         <span ng-click="article(currentHeader)">{{currentArticle}}</span>
       </div>
     </div>
  <div id="slider">
  </div>
  <div id="footer">
    <span>This page has been created by Pawel Defratyka just for learn purposes</span><br>
    <span>Contact:p.defratyka28@gmail.com</span>
  </div>
	<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.0-beta.5/angular.min.js"></script>
		<script type="text/javascript"
		src="<c:url value="/resources/scripts/ajaxScript.js"/>"></script>
		<script type="text/javascript"
		src="<c:url value="/resources/scripts/homeS.js"/>"></script>

</body>
</html>