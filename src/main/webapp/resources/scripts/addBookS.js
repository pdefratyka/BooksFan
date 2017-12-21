var book='';
var app=angular.module('app',[]);
app.controller('defaultCtrl', function($scope){
  $scope.addBook=function(){
	 ajaxAddBook();
  }
});
function initBook(){
	book={"title": $('#title').val(), "author": $('#author').val(), "year": $('#year').val(),
			"imageS": $('#image').val(), "imageM":$('#image').val(), "imageL": $('#image').val()};
}