package com.example.demo.controllers;


import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
@RequestMapping("product")
public class ProductController {

    static List<Product> productList;

    static List<Cart> cartList;

    public ProductController(){
        if(productList==null) {
            productList = new ArrayList<Product>();
            productList.add(new Product(new Random().nextInt(100000),"Title1",100.0,"https://i.picsum.photos/id/43/500/325.jpg"));
            productList.add(new Product(new Random().nextInt(100000),"Title2",200.0,"https://i.picsum.photos/id/44/500/325.jpg"));
            productList.add(new Product(new Random().nextInt(100000),"Title3",300.0,"https://i.picsum.photos/id/45/500/325.jpg"));
            productList.add(new Product(new Random().nextInt(100000),"Title4",400.0,"https://i.picsum.photos/id/46/500/325.jpg"));
            productList.add(new Product(new Random().nextInt(100000),"Title5",500.0,"https://i.picsum.photos/id/47/500/325.jpg"));
            productList.add(new Product(new Random().nextInt(100000),"Title6",600.0,"https://i.picsum.photos/id/48/500/325.jpg"));
            productList.add(new Product(new Random().nextInt(100000),"Title7",700.0,"https://i.picsum.photos/id/49/500/325.jpg"));
            productList.add(new Product(new Random().nextInt(100000),"Title8",800.0,"https://i.picsum.photos/id/50/500/325.jpg"));
        }

        if(cartList==null) {
            cartList = new ArrayList<Cart>();
        }
    }

    @RequestMapping("productList")
    public String ProductList(ModelMap model) {
        model.addAttribute("productList",productList);
        return "ProductList";
    }
    @RequestMapping("cartList")
    public String CartList(ModelMap model) {
        model.addAttribute("cartList",cartList);
        return "CartList";
    }

    @RequestMapping("editToCart/{productId}")
    @ResponseBody
    public List<Cart> EditToCart(@PathVariable("productId") int productId, @RequestParam int productCount) {

        if(productCount == 0) {
            Cart cartProduct = cartList.stream().filter(x->x.getProduct().getId()==productId).findFirst().get();
            int index = cartList.indexOf(cartProduct);
            cartList.remove(index);
        }
        else {
            cartList.stream().filter(x->x.getProduct().getId()==productId).collect(Collectors.toList()).get(0).setProductCount(productCount);
        }
        return  cartList;
    }


    @RequestMapping("addToCart/{productId}")
    @ResponseBody
    public BaseResponse AddToCart(@PathVariable("productId") int productId) {
        List<Product> product = productList.stream().filter(x->x.getId()==productId).collect(Collectors.toList());
        if(product.size()==0) {
            return new BaseResponse("Böyle bir ürün bulunamadı");
        }
       List<Cart> cartProduct = cartList.stream().filter(x->x.getProduct().getId()==productId).collect(Collectors.toList());

        if(cartProduct.size()==0) {
            Product newProduct = product.get(0);
            cartList.add(new Cart(newProduct,1));
            return new BaseResponse("Ürün sepete eklendi");
        }
        else {
            return new BaseResponse("Bu ürün zaten sepette bulunmaktadır.");
          /*  Cart cart = cartProduct.get(0);
            int productCount = cartProduct.get(0).getProductCount();
            cartList.stream().filter(x->x.getProduct().getId()==productId).collect(Collectors.toList()).get(0).setProductCount(productCount+1);*/
        }
    }
}
