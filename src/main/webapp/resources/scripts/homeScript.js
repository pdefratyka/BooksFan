$( document ).ready( function() {
	var pathArray=window.location.pathname.split('/');
	if(pathArray[1]!="home" || pathArray[1]!="home.html"){
		window.location.href=pathArray[0]+"/home";
	}
    
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

var time=intervalTrigger();
function intervalTrigger(){
  return setInterval(function(){changeSlide();},5000);
}
var app=angular.module('app',[]);
app.controller('homeCtrl', function($scope, $timeout){
  var _timeout;
  $scope.articleList=[
    {image:'https://image.ibb.co/is0Skb/tower.jpg', header:"Gunslinger returns", article:"Roland from Gilead and Jake Chambers from NY are going to protect Dark Tower. The biggest enemy is Man in black. Let's get ready to epic adventure.  ", url:""},
    {image:'https://image.ibb.co/knkhJw/game.jpg', header:"Next chapter", article:"George R.R Martin finished The winds of winter. ", url:""},
    {image:'https://image.ibb.co/e9nwdw/it.jpg', header:"IT scares in cinema", article:"Adaptation IT from Stephen King earns a lot of many on the world.", url:""},
    {image:'https://writersforensicsblog.files.wordpress.com/2015/02/astronaut-moon.jpg', header:"BooksFan rocommends", article:"Apollo 13 by James Lovell and Jeffrey Kluger", url:""},
    {image:'https://image.ibb.co/mPpnkb/detective.jpg', header:"True Serial", article:"True detective has been chosen as the best TV serial of all time by BooksFan users.", url:""}
  ];

  $scope.slideNumber=0;
  $scope.currentArticle=$scope.articleList[$scope.slideNumber].article;
  $scope.currentHeader=$scope.articleList[$scope.slideNumber].header;
  $scope.searchValue='';
  //Slider
  $scope.nextSlide=function(){
    window.clearInterval(time);
    time=intervalTrigger();
    $scope.slideNumber=$scope.slideNumber+1;
    if($scope.slideNumber>=$scope.articleList.length){
      $scope.slideNumber=0;
    }
    $("#slider").animate({opacity:0},300, function(){
        $(this).css("background-image","url("+$scope.articleList[$scope.slideNumber].image+")").animate({opacity: 1});
      });
    this.FilterByName();
  };
  $scope.previousSlide=function(){
    window.clearInterval(time);
    time=intervalTrigger();
    $scope.slideNumber=$scope.slideNumber-1;
    if($scope.slideNumber<0){
      $scope.slideNumber=$scope.articleList.length-1;
    }
    $("#slider").animate({opacity:0},300, function(){
        $(this).css("background-image","url("+$scope.articleList[$scope.slideNumber].image+")").animate({opacity: 1});
      });
      this.FilterByName();
  };
  $scope.slide=function(item,number){
    window.clearInterval(time);
    time=intervalTrigger();
    $scope.slideNumber=number;
    $("#slider").animate({opacity:0},300, function(){
        $(this).css("background-image","url("+$scope.articleList[$scope.slideNumber].image+")").animate({opacity: 1});
      });
      this.FilterByName();
  };

  $scope.FilterByName = function() {

    if(_timeout) { // if there is already a timeout in process cancel it
        $timeout.cancel(_timeout);
    }
    _timeout = $timeout(function() {
        $scope.currentArticle=$scope.articleList[$scope.slideNumber].article;
        $scope.currentHeader=$scope.articleList[$scope.slideNumber].header;
        _timeout = null;
      }, 300);
  };
  //Clickers
  $scope.search=function(){
    window.location.href = "books?query="+$scope.searchValue;
  };
  $scope.ranking=function(){
	  window.location.href="/ranking";
  };
  $scope.recentlyRead=function(){
    window.location.href="/recentlyread";
  };
  $scope.logout=function(){
    ajaxLogout();
  };
  $scope.pageLogoFunction=function(){
    window.location.href="/home";
  };
  $scope.profile=function(userId){
    window.location.href = "/users/"+userId;
  };
  $scope.article=function(articleHeader){
	  window.location.href="/articles/"+articleHeader;
  };
  $scope.searchFunction = function(keyEvent) {
  if (keyEvent.which === 13){
    $scope.search();
    }

  }


  });
function loadBooks(title, author, year, img, id) {
    var scope = angular.element(document.getElementById("homeCtrl")).scope();
    scope.$apply(function() {
      scope.addBook(title, author, year, img, id);
    });
  };
function changeSlide(){
  angular.element(document.getElementById("home")).scope().nextSlide();
};

//Some style in JQuery
$(function() {
  $(".article span").hover(function() {
  $('.article').css('color', 'orange');
  $('.article').css('cursor', 'pointer');
    }, function() {
      // on mouseout, reset the background colour
      $('.article').css('color', 'white');
  		$('.article').css('cursor', 'default');
    });
});
