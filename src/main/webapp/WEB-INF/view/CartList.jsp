<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/cart-list.css"></link>
</head>
<body>

<div class="container">

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Ürün Adı</th>
            <th scope="col">Birim Fiyatı</th>
            <th scope="col">Toplam Fiyat</th>
            <th scope="col">Adet</th>
            <th scope="col">Ekle/Çıkar</th>
        </tr>
        </thead>
        <tbody id="cartList">
        <c:forEach items="${cartList}" var="cart">
            <tr>
                <td>${cart.product.title}</td>
                <td>${cart.product.price}</td>
                <td>${cart.product.price*cart.productCount}</td>
                <td>${cart.productCount}</td>
                <td>
                    <button type="button" id="editButton" class="btn btn-primary"
                            onclick="editToCart(${cart.product.id},${cart.productCount+1})">+
                    </button>
                    &nbsp&nbsp
                    <button type="button" id="editButton" class="btn btn-danger"
                            onclick="editToCart(${cart.product.id},${cart.productCount-1})">-
                    </button>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
    <a href="/product/productList" class="returnProductList">Ürün Listesine Dön</a>
</div>
</body>


<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
<script type="text/javascript" src="/js/cart-list.js"></script>
</body>
</html>