package org.learn.store.gateways.cart.nosql;

import java.lang.invoke.MethodHandles;
import java.util.Optional;
import org.learn.store.entities.Cart;
import org.learn.store.gateways.CartGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class NoSqlCartGateway implements CartGateway {
  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private CartRepository cartRepository;
  private OrderIdSequenceGateway orderIdSequenceGateway;

  @Autowired
  public void setCartRepository(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  @Autowired
  public void setOrderIdSequenceGateway(OrderIdSequenceGateway orderIdSequenceGateway) {
    this.orderIdSequenceGateway = orderIdSequenceGateway;
  }


  @Override
  public Cart save(Cart cart) {
    return cartRepository.save(cart);
  }

  @Override
  public Optional<Cart> findById(String id) {
    return cartRepository.findById(id);
  }

  @Override
  public Cart create() {
    NoSqlCart noSqlCart = new NoSqlCart();
    noSqlCart.setOrderId(orderIdSequenceGateway.getNextOrderId());
    LOGGER.info("Cart created : {} ", noSqlCart);
    return noSqlCart;
  }
}
