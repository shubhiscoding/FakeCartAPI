package com.example.fakeapi.services;

import com.example.fakeapi.FakeCartDto.FakeCart;
import com.example.fakeapi.models.Cart;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

public interface CartService {
    public Cart getSingleCart(@PathVariable("id") Long cart_id);
    public List<Cart> getAllCart();
    public List<Cart> getInDateRange(@PathVariable Date startdate, @PathVariable Date enddate);
    public List<Cart> getUserCart(@PathVariable Long user_id);
    public Cart addNewCart(@RequestBody FakeCart cart);
    public void upadteCart(@RequestBody FakeCart newcart, @PathVariable("id") Long id);
    public void deleteCart(@PathVariable("id") Long id);
}
