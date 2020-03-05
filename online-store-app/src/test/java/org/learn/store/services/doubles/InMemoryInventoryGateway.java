package org.learn.store.services.doubles;


import org.learn.store.entities.Product;
import org.learn.store.gateways.InventoryGateway;

public class InMemoryInventoryGateway extends InMemoryGatewayUtilities<Product> implements
    InventoryGateway {
}
