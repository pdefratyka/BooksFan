$( document ).ready( function() {
  //Check login
	var user=$("#profileButton").attr('value');
	if(user.length>2){
		$("#login").css('visibility','hidden');
		$(".profile").css('visibility','visible')
		$("#logoutButton").css('visibility','visible');
		$("#profileButton").css('visibility','visible');

	}
	else{
		$(".profile").css('visibility','hidden');
		$("#login").css('visibility','visible');
		$("#logoutButton").css('visibility','hidden');
		$("#profileButton").css('visibility','hidden');

	}
});

var wantToRead=0;
var rate;
var userId;
var comment="";
var app=angular.module('app',[]);
app.controller('defaultCtrl', function($scope){
	  $scope.book={
			    title:"",
			    author:"",
			    year:"",
			    rate:0,
			    views:0,
			    personalRate:"",
			    id:"",
			    img:""
	  };
	  $scope.comment='';
	  $scope.rateList=['10','9','8','7','6','5','4','3','2','1'];
	  $scope.userRate=function(rate){
		$scope.book.personalRate=rate;
		loadRateValue();
	    $scope.personalRate=$scope.book.personalRate;
	    ajaxRateBook($("#profileButton").attr('value'));
	  };
	  $scope.logout=function(){
		  ajaxLogout();
	  };
	  $scope.profile=function(userId){
		  var pathArray=window.location.pathname.split('/');
			window.location.href =pathArray[0]+"users/"+userId;
		};
		$scope.pageLogoFunction=function(){
				var pathArray=window.location.pathname.split('/');
			    window.location.href=pathArray[0]+"/home.html";
			  };
			  $scope.saveComment=function(){
			    ajaxSaveComment($("#profileButton").attr('value'));
			  };
  $scope.search=function(){
	var pathArray=window.location.pathname.split('/');
    location.href = pathArray[0]+"/books?query="+$scope.searchValue;
  };
	$scope.addBook = function(title, author, year,views, img, rate, manyOfRead) {
		$scope.book.title=title;
		$scope.book.author=author;
		$scope.book.year=year;
		$scope.book.views=views;
		$scope.book.img=img;
		$scope.book.rate=rate;
		$scope.book.views=manyOfRead;
		
};
$scope.addToProfile=function(login){
	ajaxRateBook(login);
};
$scope.wantToRead=function(){
	if(wantToRead==0){
		wantToRead=1;
	}
	else{
		wantToRead=0;
	}
	ajaxWantRead(wantToRead,$("#profileButton").attr('value'));
}
  $scope.searchFunction = function(keyEvent) {
  if (keyEvent.which === 13){
    $scope.search();
    }

  };
});
function loadBook(title, author, year, views, img, rate, manyOfRead) {
	var scope = angular.element(document.getElementById("mainCtrl")).scope();
	scope.$apply(function() {
		scope.addBook(title, author, year, views, img, rate, manyOfRead);
	});
}
function ajaxLoadBook(id){
	userId=id;
	ajaxLoadRate();
	ajaxLoadComment();
	$.ajax({
		type : 'GET',
		dataType : 'JSON',
		success : function(book) {
			loadBook(book.title, book.author, book.year,
					book.views, book.imageL, book.rate, book.manyOfRead);		
		},

	});
}
function ajaxLoadRate(){
	var pathArray=window.location.pathname.split('/');
	$.ajax({
		type: 'GET',
		url:pathArray[2]+'/rate/'+userId,
		dataType: 'JSON',
		success: function(rate){
			var scope = angular.element(document.getElementById("mainCtrl")).scope();
			scope.personalRate=rate[0];
			wantToRead=rate[1];
			if(wantToRead==1){
				$('#wantReadCheck').prop('checked', true);
			}
		},
	});

}
function loadComment(){
	var scope = angular.element(document.getElementById("mainCtrl")).scope();
	comment=scope.comment;
}
function loadRateValue() {
	var scope = angular.element(document.getElementById("mainCtrl")).scope();
	rate=scope.book.personalRate;
}
function ajaxRateBook(login){
	loadRateValue();
	var pathArray=window.location.pathname.split('/');
	alert(pathArray[1]);
	alert(pathArray[2]);
	$.ajax({
		type : 'POST',
		url: pathArray[2]+'/rate/'+rate,
		data: {
			"login":login
		},
		dataType:'json',
		success : function(response) {
			
		},
		error: function(){
			
		}

	});
}
function ajaxWantRead(wantRead, login){
	var pathArray=window.location.pathname.split('/');
	$.ajax({
		type : 'POST',
		url: pathArray[2]+'/wantread/'+wantRead,
		data: {
			"login":login
		},
		dataType:'json',
		success : function(response) {
			
		},
		error: function(){
			
		}

	});
}
function ajaxSaveComment(login){
	loadComment();
	var pathArray=window.location.pathname.split('/');
	$.ajax({
		type : 'POST',
		url: pathArray[2]+'/'+login+'/comment',
		data: {
			"comment":comment
		},
		dataType:'json',
		success : function(response) {
			
		},
		error: function(){
			
		}

	});
}
function ajaxLoadComment(){
	var pathArray=window.location.pathname.split('/');
	$.ajax({
		type: 'GET',
		url:pathArray[2]+'/'+userId+'/comment',
		dataType: 'JSON',
		success: function(comment){
			var scope = angular.element(document.getElementById("mainCtrl")).scope();
			scope.comment=comment[0];
		},
		error:function(){
		}
	});
}
