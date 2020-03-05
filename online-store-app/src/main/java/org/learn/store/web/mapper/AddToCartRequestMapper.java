package org.learn.store.web.mapper;

import org.learn.store.usecases.addToCart.AddToCartRequest;
import org.learn.store.web.model.AddToCartWebRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class AddToCartRequestMapper {

    public static final AddToCartRequestMapper INSTANCE = Mappers.getMapper(AddToCartRequestMapper.class);

    public AddToCartRequest toAddToBasketRequest(AddToCartWebRequest addToCartWebRequest) {
        AddToCartRequest addToBasketRequest = new AddToCartRequest();
        addToBasketRequest.cartId = addToCartWebRequest.getCartId();
        return addToBasketRequest;
    }
}
