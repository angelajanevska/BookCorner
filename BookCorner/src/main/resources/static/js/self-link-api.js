function bookBySelfLink(){
    var selfID = document.getElementById('selfID').innerHTML
    console.log(selfID)
    // document.getElementById('isbn').innerHTML = ""
    // document.getElementById('title').innerHTML = ""
    // document.getElementById('author').innerHTML = ""
    // document.getElementById('description').innerHTML = ""
    // document.getElementById('release_date').innerHTML = ""
    // document.getElementById('pages').innerHTML = ""
    // document.getElementById('description').innerHTML = ""

    $.ajax({
        url: "https://www.googleapis.com/books/v1/volumes?q="+selfID,
        dataType: "json",
        success: function (data){
            for (let i=0; i<data.items.length; i++){
                document.getElementById('coverURL').innerHTML+="<img class=\"book-image\" src=\"" + data.items[i].volumeInfo.imageLinks.thumbnail + "\">";
                document.getElementById('title').innerHTML+=data.items[i].volumeInfo.title;
                document.getElementById('isbn').innerHTML+=data.items[i].volumeInfo.industryIdentifiers[1].identifier;
                document.getElementById('author').innerHTML+=data.items[i].volumeInfo.authors[0];
                document.getElementById('genre').innerHTML+=data.items[i].volumeInfo.categories[0];
                document.getElementById('pages').innerHTML+=data.items[i].volumeInfo.pageCount;
                if(data.items[i].volumeInfo.description!=null)
                    document.getElementById('description').innerHTML+=data.items[i].volumeInfo.description;
                else
                    document.getElementById('description').innerHTML+="No description";
                document.getElementById('wishlist').innerHTML+=
                    "<form action=\"/book-wishlist/" +data.items[i].volumeInfo.industryIdentifiers[0].identifier+ "\" method=\"post\">" +
                    "<button class=\"btn btn-main\">Add to wishlist</button>" +
                    "</form>";
            }
        },
        type: 'GET'
    });
}
window.onload=bookBySelfLink();