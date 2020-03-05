package org.learn.store.gateways.product.nosql;

import java.util.Optional;
import org.learn.store.entities.Product;
import org.learn.store.gateways.InventoryGateway;

public class NoSQLInventoryGateway implements InventoryGateway {

  @Override
  public Product save(Product product) {
    return null;
  }

  @Override
  public Optional<Product> findById(String productId) {
    return Optional.empty();
  }
}
