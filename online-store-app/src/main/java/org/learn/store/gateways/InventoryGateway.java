package org.learn.store.gateways;

import java.util.Optional;
import org.learn.store.entities.Product;

public interface InventoryGateway {

  Product save(Product product);

  Optional<Product> findById(String productId);

}

