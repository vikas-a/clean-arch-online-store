package org.learn.store.services.doubles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.learn.store.entities.Cart;
import org.learn.store.entities.Customer;
import org.learn.store.entities.Product;

public class PlainCart extends Cart {

    private List<Product> products = new ArrayList<>();
    private Customer customerDetails;
    private long orderId;
    private CartStatus cartStatus;

    public PlainCart(String id) {
        super(id);
    }

    public PlainCart() {
        super();
    }

    @Override
    public List<Product> getProducts() {
        return this.products;
    }
    
    @Override
    public void addProduct(Product product) {
        products.add(product);
        this.setCartStatus(CartStatus.PRODUCT_ADDED);
    }
    

    @Override
    public Customer getCustomerDetails() {
        return customerDetails;
    }

    @Override
    public void setCustomerDetails(Customer customerDetails) {
        this.customerDetails = customerDetails;
    }


    @Override
    public long getOrderId() {
        return orderId;
    }

    @Override
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
    
    @Override
    public CartStatus getCartStatus() {
        return cartStatus;
    }

    @Override
    public void setCartStatus(CartStatus cartStatus) {
        this.cartStatus = cartStatus;
    }
    
}
