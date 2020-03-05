package org.learn.store.web.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "productType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = HotelProductWebRequest.class, name = "hotel") })
public class AddToCartWebProduct {

    @Override
    public String toString() {
        return "";
    }
}

