$(document).ready(function(e) {
	// Check login
	window.onpageshow = function(event) {
		if (event.persisted) {
			window.location.reload()
		}
	};
	var user = $("#profileButton").attr('value');
	if (user.length > 2) {
		$("#login").css('visibility', 'hidden');
		$(".profile").css('visibility', 'visible')
		$("#logoutButton").css('visibility', 'visible');
		$("#profileButton").css('visibility', 'visible');

	} else {
		$(".profile").css('visibility', 'hidden');
		$("#login").css('visibility', 'visible');
		$("#logoutButton").css('visibility', 'hidden');
		$("#profileButton").css('visibility', 'hidden');

	}

});

var app = angular.module('app', []);
app
		.controller(
				'defaultCtrl',
				function($scope) {

					$scope.bookList = [ {
						title : "First",
						author : "FirstAuthor",
						year : "1923",
						img : "http://images.amazon.com/images/P/0195153448.01.MZZZZZZZ.jpg",
						id : "1"
					} ];

					$scope.addBook = function(bookTitle, bookAuthor, bookYear,
							bookImg, bookId) {
						this.bookList.push({
							title : bookTitle,
							author : bookAuthor,
							year : bookYear,
							img : bookImg,
							id : bookId
						});
					};
					$scope.search = function() {
						window.location.href = "books?query="
								+ $scope.searchValue;
					};

					$scope.pageLogoFunction = function() {
						window.location.href = "home.html";
					};
					$scope.profile = function(userId) {
						window.location.href = "/users/" + userId;
					};
					$scope.logout = function() {
						ajaxLogout();
					}
					$scope.searchFunction = function(keyEvent) {
						if (keyEvent.which === 13) {
							$scope.search();
						}

					};
					$scope.selectBook = function(id) {
						window.location.href = "books/" + id;
					};
					$scope.mouseOver = function($event, bool) {
						if (bool === true)
							$($event.target).css("background-color", "");
						else
							$($event.target).css("background-color", "");
					}
				});

function loadBooks(title, author, year, img, id) {
	var scope = angular.element(document.getElementById("mainCtrl")).scope();
	scope.$apply(function() {
		scope.addBook(title, author, year, img, id);
	});
}
function ajaxLoadBooksW() {
	$.ajax({
		type : 'GET',
		dataType : 'JSON',
		success : function(book) {
			if (book.length < 1) {
				$("#emptyList img").css("visibility", "hidden");
				$("#emptyList h5").css("visibility", "visible");

			} else {
				$("#emptyList img").css("visibility", "hidden");
			}

			$.each(book, function(index, book) {
				loadBooks(book.title, book.author, book.year, book.imageM,
						book.id);
			});
		},
		error : function() {
			alert("FailMan");
			
			window.location.reload();
		}
	});
}
