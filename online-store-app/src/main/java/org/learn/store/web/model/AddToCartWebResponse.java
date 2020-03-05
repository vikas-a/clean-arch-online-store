package org.learn.store.web.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class AddToCartWebResponse {
    private String cartId;

    public AddToCartWebResponse(String cartId) {
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AddToCartWebResponse) {
            AddToCartWebResponse other = (AddToCartWebResponse) obj;
            EqualsBuilder builder = new EqualsBuilder();
            builder.append(getCartId(), other.getCartId());
            return builder.isEquals();
        }
        return false;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(getCartId());
        return builder.toHashCode();
    }

    @Override
    public String toString() {
        return "AddToCartWebResponse [" + "cartId=" + cartId + "]";
    }
}
