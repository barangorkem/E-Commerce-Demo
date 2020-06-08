function  addToCart(cartId) {
    console.log("Add To Cart = "+cartId);

    $.ajax({
        url: `/product/addToCart/`+cartId,
        type: 'GET',
        dataType: 'json', // added data type
        success: function(res) {
            console.log("RES",res);
            alert(res.message);
        },
        error: function(xhr, status, error) {
            var err = JSON.parse(xhr.responseText);
            alert(err.Message);
        },
    });
}