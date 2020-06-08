let cartListEl = document.getElementById("cartList");


function editToCart(productId,productCount) {
    console.log("Edit To Cart = "+productId);
    console.log("ProductCount = "+productCount);

    $.ajax({
        url: '/product/editToCart/'+productId+'?productCount='+productCount,
        type: 'GET',
        dataType: 'json', // added data type
        success: function(res) {
            if(res) {
                console.log("res",res);
                let cartList='';
                for (let i=0;i<res.length;i++) {
                    console.log(res[i]);
                    cartList = cartList+"<tr><td>"+res[i].product.title+"</td>"+
                        "<td>"+res[i].product.price+"</td>"+
                        "<td>"+res[i].product.price*res[i].productCount+"</td>"+
                        "<td>"+res[i].productCount+"</td>"+
                        "<td><button type='button'  style='width: 40px;'  class='btn btn-primary' onclick='editToCart("+ res[i].product.id+","+(res[i].productCount+1)+")'"+">+</button>&nbsp&nbsp"+
                        "<button type='button' style='width: 40px;' class='btn btn-danger' onclick='editToCart("+ res[i].product.id+","+(res[i].productCount-1)+")'"+">-</button></td>"+
                        "</tr>"
                }
                console.log("carttListt",cartList);
                cartListEl.innerHTML = cartList;
            }
            else {
                alert(res);
            }

        },
        error: function(xhr, status, error) {
            var err = JSON.parse(xhr.responseText);
            alert(err.Message);
        },
    });
}