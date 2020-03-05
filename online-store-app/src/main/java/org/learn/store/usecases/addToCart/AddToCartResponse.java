package org.learn.store.usecases.addToCart;


import org.learn.store.usecases.UseCaseResponse;

public class AddToCartResponse extends UseCaseResponse {
    public boolean wasFound;
    public String cartId;
}
