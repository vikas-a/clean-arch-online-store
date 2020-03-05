package org.learn.store.gateways.cart.nosql;

import java.util.Optional;
import org.learn.store.entities.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, String> {
  Optional<Cart> findById(String id);
}
