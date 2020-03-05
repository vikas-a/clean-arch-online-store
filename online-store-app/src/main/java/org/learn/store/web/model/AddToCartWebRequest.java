package org.learn.store.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class AddToCartWebRequest {

    @JsonIgnore
    private String cartId;

    private List<AddToCartWebProduct> products;


    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
    
    public List<AddToCartWebProduct> getProducts() {
        return products;
    }

    public void setProducts(List<AddToCartWebProduct> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AddToCartWebRequest) {
            AddToCartWebRequest other = (AddToCartWebRequest) obj;
            EqualsBuilder builder = new EqualsBuilder();
            builder.append(getCartId(), other.getCartId());
            builder.append(getProducts(), other.getProducts());
            return builder.isEquals();
        }
        return false;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(getCartId());
        builder.append(getProducts());
        return builder.toHashCode();
    }

    @Override
    public String toString() {
        return "AddToCartWebRequest ["
                + ", cartId=" + cartId
                + ", products=" + products
                + "]";
    }
}
