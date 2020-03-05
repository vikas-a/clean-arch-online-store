package org.learn.store.gateways;

import java.util.Optional;
import org.learn.store.entities.Cart;

public interface CartGateway {

  Cart save(Cart cart);

  Optional<Cart> findById(String id);

  Cart create();

}
