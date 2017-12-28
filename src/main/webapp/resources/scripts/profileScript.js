var id;
var app=angular.module('app',[]);
app.controller('defaultCtrl', function($scope, $filter){
  $scope.bookList=[
    
  ];
  $scope.search={title:"", author:'', year:'', rate:''};
  $scope.addBook=function(bookTitle, bookAuthor, bookYear, bookId, bookImg){
	  bookTitle2='';
	  bookAuthor2='';
	  if(bookTitle.indexOf('(')>-1){
		  bookTitle2=bookTitle.substr(0,bookTitle.indexOf('('));
	  }
	  else{
		  bookTitle2=bookTitle;
	  }
	  if(bookTitle2.length>17){
		  bookTitle2=bookTitle2.substr(0,17)+"...";
	  }

    this.bookList.push({
      title: bookTitle2,
      author: bookAuthor,
      year: bookYear,
      id:bookId,
      img:bookImg
    });
  };
  $scope.sortTitlesByAlphabet=function(){
    this.bookList=$filter('orderBy')(this.bookList, 'title');

  };
  $scope.sortAuthorsByAlphabet=function(){
    this.bookList=$filter('orderBy')(this.bookList, 'author');
  };
  $scope.sortByYear=function(){
    this.bookList=$filter('orderBy')(this.bookList,'year');
  };
  $scope.sortByYourRate=function(){
    this.bookList=$filter('orderBy')(this.bookList,'rate');
  };
  $scope.myFilter=function(item){
    //Create mainPage like 1 page witch we can scroll, that long how it is necessary!
    var title=0;
    var author=0;
    var year=0;
    var rate=0;
    if($scope.search.title!=""){
      title=1;
    }
    if($scope.search.author!=""){
      author=1;
    }
    if($scope.search.year!=""){
      year=1;
    }
    if($scope.search.rate!=""){
      rate=1;
    }
    if(title==1){
        var position=item.title.indexOf($scope.search.title);
    }
    if(author==1){
      var position=item.author.indexOf($scope.search.author);
    }
    if(year==1){
      var position=item.year.indexOf($scope.search.year);
    }
    if(rate==1){
      var position=item.rate.indexOf($scope.search.rate);
    }
    if(author==1 && title==1){
      var p1=item.title.indexOf($scope.search.title);
      var p2=item.author.indexOf($scope.search.author);
      if((p1+p2)==0){
        position=1;
      }
      else{
        position=-1;
      }
    }

    if(position!=-1){
      return true;
    }
    else{
      return false;
    }

  };
  $scope.pageLogoFunction=function(){
		var pathArray=window.location.pathname.split('/');
	    window.location.href=pathArray[0]+"/home.html";
  }
  $scope.readBooksFunction=function(){
	this.cleanBooks();
    ajaxLoadYourBooks();
  }
  $scope.wantToReadFunction=function(){
    this.cleanBooks();
    ajaxLoadWantReadBooks();
  }
  $scope.cleanBooks=function(){
	  $scope.bookList.length=0;
  }
  $scope.addBookFunction=function(userId){
		var pathArray=window.location.pathname.split('/');
	    window.location.href=pathArray[0]+"/users/"+userId+"/addbook";
  }

  $scope.selectBook=function(bookId){
	  var pathArray=window.location.pathname.split('/');
	  window.location.href=pathArray[0]+"/books/"+bookId;
  }
  $scope.logout=function(){
	  ajaxLogout();
  }
  });

function loadBooks(title, author, year, img, id) {
	var scope = angular.element(document.getElementById("someCtrl")).scope();
	scope.$apply(function() {
		scope.addBook(title, author, year, id, img);
	});
}
function pathName(){
	var pathArray=window.location.pathname.split('/');
	id=pathArray[2];
}
