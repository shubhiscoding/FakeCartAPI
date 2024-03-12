package com.example.fakeapi.services;

import com.example.fakeapi.models.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Date;
@Service
public class FakeStoreCartService implements CartService{
    private RestTemplate restTemplate = new RestTemplate();
    @Override
    public Cart getSingleCart(Long cart_id) {
        Cart mycart = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/" + cart_id,
                Cart.class
        );
        return mycart;
    }

    @Override
    public List<Cart> getAllCart() {
        Cart[] allcarts = restTemplate.getForObject(
                "https://fakestoreapi.com/carts",
                Cart[].class
        );
        assert allcarts != null;
        ArrayList<Cart> cartList = new ArrayList<>(Arrays.asList(allcarts));
        return cartList;
    }

    @Override
    public List<Cart> getInDateRange(Date startdate, Date enddate) {
        Cart[] carts = restTemplate.getForObject(
                "https://fakestoreapi.com/carts?startdate=" + startdate +"&enddate="+enddate,
                Cart[].class
        );
        assert carts != null;
        ArrayList<Cart> cartListInDate = new ArrayList<>(Arrays.asList(carts));
        return cartListInDate;
    }

    @Override
    public List<Cart> getUserCart(Long user_id) {
        Cart[] carts = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/user/" + user_id,
                Cart[].class
        );
        assert carts != null;
        ArrayList<Cart> cartListInDate = new ArrayList<>(Arrays.asList(carts));
        return cartListInDate;
    }

    @Override
    public Cart addNewCart(Cart cart) {
        Cart addedcart = restTemplate.postForObject(
            "https://fakestoreapi.com/carts",
                cart,
                Cart.class
        );
        return addedcart;
    }

    @Override
    public void upadteCart(Cart newcart, Long id) {
       restTemplate.put(
                "https://fakestoreapi.com/carts/"+id,
                    newcart
       );
    }

    @Override
    public void deleteCart(Long id) {
        restTemplate.delete(
                "https://fakestoreapi.com/carts/"+id
        );
    }
}
