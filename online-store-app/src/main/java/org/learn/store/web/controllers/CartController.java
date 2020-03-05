package org.learn.store.web.controllers;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.validation.Valid;
import org.learn.store.usecases.addToCart.AddToCartRequest;
import org.learn.store.usecases.addToCart.AddToCartResponse;
import org.learn.store.usecases.addToCart.AddToCartUseCase;
import org.learn.store.web.mapper.AddToCartRequestMapper;
import org.learn.store.web.model.AddToCartWebRequest;
import org.learn.store.web.model.AddToCartWebResponse;
import org.learn.store.web.model.CartStatusWebResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class CartController {
     private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final int THREAD_POOL_SIZE = 50;

    @Autowired
    private AddToCartUseCase addToCartUseCase;


    private ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    

    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "Create a new cart and add product(s) to cart",
            notes = "Create a new cart and add product(s) to cart",
            response = AddToCartResponse.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Created a new cart and added product(s) to the cart"),
            @ApiResponse(code = 500, message = "Failed to create the cart")
    })
    public AddToCartWebResponse createCart(
            @ApiParam(value = "Create cart request with product details", required = true)
            @Valid @RequestBody final AddToCartWebRequest addToCartWebRequest) {
        LOGGER.info("CreateCart request {} ", addToCartWebRequest);
        AddToCartRequest addToCartReq = AddToCartRequestMapper.INSTANCE.toAddToBasketRequest(addToCartWebRequest);
        AddToCartResponse addToCartResponse = (AddToCartResponse) addToCartUseCase.execute(addToCartReq);

        String cartId = addToCartResponse.cartId;
        LOGGER.info("CreateCart response {} ", new AddToCartWebResponse(cartId).toString());
        return new AddToCartWebResponse(cartId);
    }


}