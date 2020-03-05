package org.learn.store.entities;

import java.util.List;

public abstract class Cart extends Entity {
  public enum CartStatus {
    CREATED, PRODUCT_ADDED, BASKET_STATUS, BUY_NOW_STARTED, BUY_NOW_COMPLETED
  }

  public Cart(String id) {
    super(id);
  }

  public Cart() {
    super();
    CartIdGenerator cartIdGenerator = new CartIdGenerator();
    this.setId(cartIdGenerator.generateCartId());
    this.setCartStatus(CartStatus.CREATED);
  }

  public abstract CartStatus getCartStatus();

  protected abstract void setCartStatus(CartStatus created);

  public abstract List<Product> getProducts();

  public abstract void addProduct(Product product);

  public abstract long getOrderId();

  public abstract void setOrderId(long orderId);

  public abstract Customer getCustomerDetails();

  public abstract void setCustomerDetails(Customer customerDetails);

}
