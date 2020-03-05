package org.learn.store.entities;

public abstract class Customer extends Entity {

  public abstract String getName();

  public abstract String getEmailAddress();

  public interface Builder {

    Builder name(String name);

    Builder emailAddress(String emailAddress);

    Customer build();
  }
}
