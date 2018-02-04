var app=angular.module('app',[]);
app.controller('defaultCtrl', function($scope){
  $scope.login=function(){
	 ajaxCheckLogin();
  }
  $scope.logout=function(){
	  ajaxLogout();
  }
  $scope.back=function(){
		var pathArray = window.location.pathname.split('/');
		window.location.href = pathArray[0] + "/home.html";
  }
  $scope.loginFunction = function(keyEvent) {
  if (keyEvent.which === 13){
    $scope.login();
    }

  }
});
