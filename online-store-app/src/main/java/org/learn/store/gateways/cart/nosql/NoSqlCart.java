package org.learn.store.gateways.cart.nosql;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.learn.store.entities.Cart;
import org.learn.store.entities.Cart.CartStatus;
import org.learn.store.entities.Customer;
import org.learn.store.entities.Product;

//Add @Document to improve document persistent
public class NoSqlCart extends Cart {
    private List<Product> products = new ArrayList<>();
    private NoSqlCustomer customerDetails;
    private CartStatus cartStatus;


   protected long orderId;

   public NoSqlCart() {
        super();
    }

    @Override
    protected void setCartStatus(CartStatus created) {

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
        this.customerDetails = (NoSqlCustomer) customerDetails;
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
    public String toString() {
        return "Cart {" +
                "Cart ID=" + getId() +
                " Order ID=" + getOrderId() +
                " Cart Status=" + getCartStatus() + '}';
    }
}