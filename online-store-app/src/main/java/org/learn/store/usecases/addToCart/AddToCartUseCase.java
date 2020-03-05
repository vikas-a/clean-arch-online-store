package org.learn.store.usecases.addToCart;


import java.lang.invoke.MethodHandles;
import java.util.Optional;
import org.learn.store.entities.Cart;
import org.learn.store.entities.Product;
import org.learn.store.gateways.CartGateway;
import org.learn.store.gateways.InventoryGateway;
import org.learn.store.usecases.UseCase;
import org.learn.store.usecases.UseCaseRequest;
import org.learn.store.usecases.UseCaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddToCartUseCase implements UseCase {

  private CartGateway cartGateway;
  private InventoryGateway inventoryGateway;
  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @Override
  public UseCaseResponse execute(UseCaseRequest useCaseRequest) {
    AddToCartRequest req = (AddToCartRequest) useCaseRequest;

    Cart cart = loadOrCreateCart(req.cartId);
    cartGateway.save(cart);

    LOGGER.info("cart " + cart.getId() +" Created");

    Optional<Product> optionalProduct = inventoryGateway.findById(req.productId);
    optionalProduct.ifPresent(cart::addProduct);
    LOGGER.info("cart " + cart.getId() +" Product added");
    cartGateway.save(cart);
    return createUseCaseResponse(cart, optionalProduct);
  }

  private Cart loadOrCreateCart(String cartId) {
    Optional<Cart> cart = cartGateway.findById(cartId);
    return cart.orElse(cartGateway.create());
  }


  private AddToCartResponse createUseCaseResponse(Cart cart, Optional<Product> product) {
    AddToCartResponse resp = new AddToCartResponse();
    resp.wasFound = product.isPresent();
    resp.cartId = cart.getId();
    return resp;
  }

  public void setCartGateway(CartGateway cartGateway) {
    this.cartGateway = cartGateway;
  }

  public void setInventoryGateway(InventoryGateway inventoryGateway) {
    this.inventoryGateway = inventoryGateway;
  }
}
