var user='';
var app=angular.module('app',[]);
app.controller('defaultCtrl', function($scope){
  $scope.register=function(){
	 ajaxAddUser();
  }
  $scope.registerFunction = function(keyEvent) {
  if (keyEvent.which === 13){
    $scope.register();
    }

  }
});
initUser=function(){
	user={"userName": $('#userName').val(), "userPassword":$('#userPassword').val(), "email": $('#userEmail').val()};
}

