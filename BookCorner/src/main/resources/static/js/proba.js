function bookSearch(){
    var search = document.getElementById('search').value
    document.getElementById('result').innerHTML = ""

    $.ajax({
        url: "https://www.googleapis.com/books/v1/volumes?q="+search,
        dataType: "json",
        success: function (data){
            for (let i=0; i<data.items.length; i++){
                result.innerHTML+=
                    "<h3>" + data.items[i].volumeInfo.title + "</h3>" +
                    "<h5>Author: "+ data.items[i].volumeInfo.authors +"</h5>" + "<br>"
            }
        },
        type: 'GET'
    });
}
document.getElementById('button').addEventListener('click',bookSearch,false)