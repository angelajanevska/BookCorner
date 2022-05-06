function exampleBooks(){
    document.getElementById('result').innerHTML = ""
    document.getElementById('resultSubject').innerHTML = ""
    $.ajax({
        url: "https://www.googleapis.com/books/v1/volumes?q=Stephen+King",
        dataType: "json",
        success: function (data){
            for (let i=0; i<data.items.length-2; i++){
                result.innerHTML+=
                    "<div class=\"col-md-2 col-sm-6 col-xs-12 book-item\">" +
                    "<img class=\"book-image\" src=\"" + data.items[i].volumeInfo.imageLinks.thumbnail + "\">" +
                    "<h3>" + data.items[i].volumeInfo.title + "</h3>" +
                    "<h5>Author: "+ data.items[i].volumeInfo.authors +"</h5>" +
                    "<form action=\"/book/single/" +data.items[i].id+ "\" method=\"GET\">" +
                        "<button class=\"btn btn-main\">Read more</button>" +
                    "</form>" +
                    "</div>"
            }
        },
        type: 'GET'
    });
}
function bookSearchByAuthorOrTitle(){
    var search = document.getElementById('search').value
    document.getElementById('result').innerHTML = ""

    $.ajax({
        url: "https://www.googleapis.com/books/v1/volumes?q="+search,
        dataType: "json",
        success: function (data){
            for (let i=0; i<data.items.length; i++){
                result.innerHTML+=
                    "<div class=\"col-md-2 col-sm-6 col-xs-12 book-item\">" +
                    "<img class=\"book-image\" src=\"" + data.items[i].volumeInfo.imageLinks.thumbnail + "\">" +
                    "<h3>" + data.items[i].volumeInfo.title + "</h3>" +
                    "<h5>Author: "+ data.items[i].volumeInfo.authors +"</h5>" +
                    "<form action=\"/book/single/" +data.items[i].id+ "\" method=\"GET\">" +
                    "<button class=\"btn btn-main\">Read more</button>" +
                    "</form>" +
                    "</div>"
            }
        },
        type: 'GET'
    });
}
function bookSearchByGenre(){
    var search = document.getElementById('searchSubject').value
    document.getElementById('result').innerHTML = ""

    $.ajax({
        url: "https://www.googleapis.com/books/v1/volumes?q=subject:"+search,
        dataType: "json",
        success: function (data){
            for (let i=0; i<data.items.length; i++){
                resultSubject.innerHTML+=
                    "<div class=\"col-md-2 col-sm-6 col-xs-12 book-item\">" +
                    "<img class=\"book-image\" src=\"" + data.items[i].volumeInfo.imageLinks.thumbnail + "\">" +
                    "<h3>" + data.items[i].volumeInfo.title + "</h3>" +
                    "<h5>Author: "+ data.items[i].volumeInfo.authors +"</h5>" +
                    "<form action=\"/book/single/" +data.items[i].id+ "\" method=\"GET\">" +
                    "<button class=\"btn btn-main\">Read more</button>" +
                    "</form>" +
                    "</div>"
            }
        },
        type: 'GET'
    });
}
document.getElementById('button').addEventListener('click',bookSearchByAuthorOrTitle,false)
document.getElementById('buttonSubject').addEventListener('click',bookSearchByGenre,false)
window.onload=exampleBooks()