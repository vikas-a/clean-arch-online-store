package org.learn.store.services.doubles;

import org.learn.store.entities.Cart;
import org.learn.store.gateways.CartGateway;

public class InMemoryCartGateway extends InMemoryGatewayUtilities<Cart> implements CartGateway {
    public Cart create() {
        return new PlainCart();
    }
}
