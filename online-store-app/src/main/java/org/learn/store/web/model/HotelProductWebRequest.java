package org.learn.store.web.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class HotelProductWebRequest extends AddToCartWebProduct {

  private String accommodationCode;

  public String getAccommodationCode() {
    return accommodationCode;
  }

  public void setAccommodationCode(String accommodationCode) {
    this.accommodationCode = accommodationCode;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof HotelProductWebRequest) {
      HotelProductWebRequest other = (HotelProductWebRequest) obj;
      EqualsBuilder builder = new EqualsBuilder();
      builder.append(getAccommodationCode(), other.getAccommodationCode());
      return builder.isEquals();
    }
    return false;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();
    builder.append(getAccommodationCode());
    return builder.toHashCode();
  }

  @Override
  public String toString() {
    return "HotelProductWebRequest [" + "accommodationCode=" + accommodationCode + "]";
  }
}
