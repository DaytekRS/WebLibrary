function listBooks(arr) {
    for (var i = 0; i < arr.length; i++) {
        var div = document.createElement('figure');
        div.classList.add("text-center")
        div.classList.add("col-sm-6");
        div.classList.add("col-md-4");
        div.classList.add("col-lg-3");
        div.classList.add("pulse");
        div.classList.add("card");

        var html = "";

        if (arr[i].image != null) {
            html += "<img class='image-book'  src=\"" + arr[i].image + "\" alt=\"" + arr[i].name + "\">";
        } else html = "<img class='image-book'  src=\"img/noImage.png\" alt=\"noImage\">";

        div.innerHTML = "<a style='text-decoration:none' href=/book?id=" + arr[i].id + ">" + html + "<br>" + "<p class='book'>" + arr[i].name + "</p></a>";
        list_books.appendChild(div);
    }
}

$(document).ready(function () {
    var params = window
        .location
        .search
        .replace('?', '')
        .split('&')
        .reduce(
            function (p, e) {
                var a = e.split('=');
                p[decodeURIComponent(a[0])] = decodeURIComponent(a[1]);
                return p;
            },
            {}
        );
    if (params['search'] != null) {
        $.ajax({
            url: "/api/books?name=" + params['search'],
            method: "GET",
            success: function (data) {
                listBooks(data);
            }
        });
    } else {
        $.ajax({
            url: "/api/books",
            method: "GET",
            success: function (data) {
                listBooks(data);
            }
        });
    }
});
