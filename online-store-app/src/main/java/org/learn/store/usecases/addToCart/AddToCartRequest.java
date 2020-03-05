package org.learn.store.usecases.addToCart;


import org.learn.store.usecases.UseCaseRequest;

public class AddToCartRequest implements UseCaseRequest {
    public String productId;
    public String cartId;
}
