var book='';
var app=angular.module('app',[]);
app.controller('defaultCtrl', function($scope){
  $scope.addBook=function(){
	 ajaxAddBook();
  };
  $scope.back=function(){
      var pathArray=window.location.pathname.split('/');
      window.location.href = pathArray[0]+"/home";
  }
});
function initBook(){
	book={"title": $('#title').val(), "author": $('#author').val(), "year": $('#year').val(),
			"imageS": $('#image').val(), "imageM":$('#image').val(), "imageL": $('#image').val()};
}