package org.learn.store.usecases;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.learn.store.entities.Cart;
import org.learn.store.entities.Product;
import org.learn.store.gateways.CartGateway;
import org.learn.store.gateways.InventoryGateway;
import org.learn.store.services.doubles.InMemoryCartSpyGateway;
import org.learn.store.services.doubles.InMemoryInventoryGateway;
import org.learn.store.services.doubles.PlainCart;
import org.learn.store.usecases.addToCart.AddToCartRequest;
import org.learn.store.usecases.addToCart.AddToCartResponse;
import org.learn.store.usecases.addToCart.AddToCartUseCase;


@RunWith(HierarchicalContextRunner.class)
public class AddToCartUseCaseTest {
    AddToCartUseCase useCase;
    CartGateway cartGateway;
    InventoryGateway inventoryGateway;
    AddToCartRequest req;

    @Before
    public void setUp() throws Exception {
        useCase = new AddToCartUseCase();
        cartGateway = new InMemoryCartSpyGateway();
        inventoryGateway = new InMemoryInventoryGateway();
        useCase.setCartGateway(cartGateway);
        useCase.setInventoryGateway(inventoryGateway);
        req = new AddToCartRequest();
    }

    public class GivenNoBasketId {
        @Test
        public void whenSpecifiedProductDoesntExists_ReturnNewCartAnyWithoutProducts() throws Exception {
            req.productId = "product-1";

            AddToCartResponse resp = (AddToCartResponse) useCase.execute(req);

            assertThat(resp.cartId, is(notNullValue()));
            assertThat(resp.successful, is(true));
            assertThat(resp.wasFound, is(false));
        }

        @Test
        public void whenSpecifiedProductExists_ReturnNewCartWithValidId() throws Exception {
            inventoryGateway.save(new Product("product-1"));
            req.productId = "product-1";

            AddToCartResponse resp = (AddToCartResponse) useCase.execute(req);

            assertThat(resp.cartId, is(notNullValue()));
            assertThat(resp.successful, is(true));
        }
    }

    public class GivenAnExistingCartId {
        @Before
        public void setUp() throws Exception {
            cartGateway.save(new PlainCart("cart-1"));
        }

        @Test
        public void whenSpecifiedProductDoesntExist_ReturnCartInCurrentState() throws Exception {
            req.cartId = "cart-1";
            req.productId = "product-1";
            cartGateway.save(new PlainCart("cart-1"));
            ((InMemoryCartSpyGateway) cartGateway).resetSpy();

            AddToCartResponse resp = (AddToCartResponse) useCase.execute(req);

            assertThat(((InMemoryCartSpyGateway) cartGateway).wasSaveCalled(), is(true));
            assertThat(resp.cartId, is(req.cartId));
            assertThat(resp.successful, is(true));
        }

        @Test
        public void whenBasketAlreadyContainsOneProductAndWhenSpecifiedProductToAddExists_returnCartWithTwoProduct() throws Exception {
            req.cartId = "cart-1";
            req.productId = "new-product-2";
            inventoryGateway.save(new Product("existing-product-1"));
            inventoryGateway.save(new Product("new-product-2"));
            Cart cart = new PlainCart("cart-1");
            cart.addProduct(new Product("existing-product-1"));
            cartGateway.save(cart);

            AddToCartResponse resp = (AddToCartResponse) useCase.execute(req);

            assertThat(resp.cartId, is(req.cartId));
            assertThat(resp.successful, is(true));
            assertThat(cartGateway.findById("cart-1").get().getProducts().size(), is(2));

        }

    }
}
