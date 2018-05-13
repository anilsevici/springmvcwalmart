function loadProducts() {
    var xhttp = new XMLHttpRequest();
    var url= contextPath + "search/";

    var search = document.getElementById("searchText").value;
    var parameters = "?query=" + search;

    xhttp.open("GET", url + parameters, true);

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            createProductsTable(this);
        }
    };

    xhttp.send();
}

function createProductsTable(xhttp) {
    var i;
    var jsonObj = JSON.parse(xhttp.responseText);
    var table="<tr><th>Product Image</th><th>Product Name</th><th>Product Price</th></tr>";

    for (i = 0; i <jsonObj.length; i++) {
        table += "<tr><td>" +
            "<img src=" +jsonObj[i].thumbnailImage + ">" +
            "</td><td>" +
            "<a href=" + contextPath + "product/" +jsonObj[i].itemId + "><p>" + jsonObj[i].name + "</p></a>" +
            "</td><td>" +
            jsonObj[i].salePrice +
            "</td></tr>";
    }
    document.getElementById("products").innerHTML = table;
}
