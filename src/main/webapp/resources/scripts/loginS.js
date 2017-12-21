var app=angular.module('app',[]);
app.controller('defaultCtrl', function($scope){
  $scope.login=function(){
	 ajaxCheckLogin();
  }
  $scope.logout=function(){
	  ajaxLogout();
  }
  $scope.loginFunction = function(keyEvent) {
  if (keyEvent.which === 13){
    $scope.login();
    }

  }
});
