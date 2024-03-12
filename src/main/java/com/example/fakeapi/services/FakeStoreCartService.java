package com.example.fakeapi.services;

import com.example.fakeapi.FakeCartDto.FakeCart;
import com.example.fakeapi.models.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    @Override
    public Cart addNewCart(FakeCart cart) {
        Date date = null;
        try {
            date = formatter.parse(cart.getDate());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Cart newcart = new Cart();
        newcart.setDate(date);
        newcart.setProducts(cart.getProducts());
        newcart.setId(cart.getId());
        newcart.setUserId(cart.getUserId());
        Cart addedcart = restTemplate.postForObject(
            "https://fakestoreapi.com/carts",
                newcart,
                Cart.class
        );
        return addedcart;
    }

    @Override
    public void upadteCart(FakeCart cart, Long id) {
        Date date = null;
        try {
            date = formatter.parse(cart.getDate());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Cart newcart = new Cart();
        newcart.setDate(date);
        newcart.setProducts(cart.getProducts());
        newcart.setId(cart.getId());
        newcart.setUserId(cart.getUserId());
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
