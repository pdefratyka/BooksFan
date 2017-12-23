/*Most common ajax functions used in the project*/

function ajaxAddBook(){
	initBook();
	$.ajax({
		type : 'POST',
		url: '/books/addbook',
		data: JSON.stringify(book),
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		success : function(response) {
			alert("Succsses");
			window.location.href = "home";
		},
		error: function(){
			alert("Fail");
		}

	});
}
function ajaxLoadBooks(){
    $.ajax({
      type : 'GET',
      dataType : 'JSON',
      success : function(book) {
        $.each(book,
            function(index, book) {
              loadBooks(book.title, book.author, book.year, book.imageM,
                  book.id);
            });
      },
    });
};

function ajaxLogout(){
    $.ajax({
      type : 'DELETE',
      url: '/users/logout',
      contentType: "application/json; charset=utf-8",
      success : function() {
        alert("Succsses");
        window.location.href = "home";
      },
      error: function(){
        alert("Fail");
      }

    });
}

function ajaxCheckLogin(){
	$.ajax({
		type : 'GET',
		url: 'users/login',
		data: {
			"login":$('#login').val(),
			"password":$('#password').val()
		},
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		success : function(response) {
			alert("Succsses");
			window.location.href = "/home";
		},
		error: function(){
			alert("Fail");
		}

	});
}

function ajaxAddUser(){
initUser();
$.ajax({
	type : 'POST',
	url: 'users',
	data: JSON.stringify(user),
	contentType: "application/json; charset=utf-8",
	dataType:'json',
	success : function(response) {
		alert("Succsses");
		window.location.href = "/home";
	},
	error: function(){
		alert("Fail");
	}

});
}
function ajaxLoadWantReadBooks(){
	pathName();
	$.ajax({
		type : 'GET',
		url: id[3]+'/wantread',
		dataType : 'JSON',
		success : function(book) {
			$.each(book,
					function(index, book) {
						loadBooks(book.title, book.author, book.year, book.imageM, book.id
								);
					});
		},
	});
}

function ajaxLoadYourBooks(){
	pathName();
	$.ajax({
		type : 'GET',
		url: id[3]+'/books',
		dataType : 'JSON',
		success : function(book) {
			$.each(book,
					function(index, book) {
						loadBooks(book.title, book.author, book.year, book.imageM, book.id
								);
					});
		},
	});
}