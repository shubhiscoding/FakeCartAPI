package com.example.fakeapi.controller;

import com.example.fakeapi.models.Cart;
import com.example.fakeapi.services.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;
@RestController
public class CartController {

    private CartService cartService;

    public CartController(CartService cartService){this.cartService = cartService;}
    @GetMapping("/cart/{id}")
    public Cart getSingleCart(@PathVariable("id") Long cart_id){
        return cartService.getSingleCart(cart_id);
    }

    @GetMapping("/carts")
    public List<Cart> getAllCart(){
        return cartService.getAllCart();
    }
    @GetMapping("/carts?startdate={starter}&enddate={ending}")
    public List<Cart> getInDateRange(@PathVariable("starter") Date startdate, @PathVariable("ending") Date enddate){
        return cartService.getInDateRange(startdate, enddate);
    }
    @GetMapping("/carts/user/{id}")
    public List<Cart> getUserCart(@PathVariable("id") Long user_id){
        return cartService.getUserCart(user_id);
    }

    @PostMapping("/carts")
    public Cart addNewCart(@RequestBody Cart cart){
        return cartService.addNewCart(cart);
    }

    @PutMapping("/carts/{id}")
    public String upadteCart(@RequestBody Cart newcart, @PathVariable("id") Long id){
        cartService.upadteCart(newcart, id);
        return "Cart Updated";
    }
    @DeleteMapping("/carts/{id}")
    public String deleteCart(@PathVariable("id") Long id){
        cartService.deleteCart(id);
        return "Cart Deleted";
    }
}
