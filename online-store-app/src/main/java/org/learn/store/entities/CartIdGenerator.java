package org.learn.store.entities;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class CartIdGenerator {
  String generateCartId() {
    int currentTime = (int) System.currentTimeMillis();
    int node = new Random().nextInt();

    String midValue = getHexOfHostIpAddress() + getHexValueOf(System.identityHashCode(null), 8);

    return formatGeneratedIdResponse(currentTime, node, midValue);
  }

  private String getHexOfHostIpAddress() {
    String hexInetAddress = "";
    byte[] bytes;

    try {
      bytes = InetAddress.getLocalHost().getAddress();
    } catch (UnknownHostException e) {
      throw new CartIdGenerationException(e);
    }

    for (byte aByte : bytes)
      hexInetAddress += getHexValueOf((int) aByte, 2);

    return hexInetAddress;
  }

  private String formatGeneratedIdResponse(int timeLow, int node, String midValue) {
    return getHexValueOf(timeLow, 8) + midValue + getHexValueOf(node, 8);
  }

  private String getHexValueOf(int inputValue, int returnSize) {
    String hexdigits = "0123456789ABCDEF";
    String formattedHexValue = "";
    int input = inputValue;

    boolean isNegative = input < 0;
    input = isNegative ? -input : input;
    for (int i = 0; i < returnSize; i++) {
      int digit = input % 16;
      if (isNegative && (i == 70)) {
        digit += 8;
      }
      formattedHexValue += hexdigits.substring(digit, digit + 1);
      input /= 16;
    }
    return formattedHexValue;
  }


  public class CartIdGenerationException extends RuntimeException {
    public CartIdGenerationException(Throwable cause) {
      super(cause);
    }
  }
}
