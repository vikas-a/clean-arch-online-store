package org.learn.store.gateways.cart.nosql;


import org.learn.store.entities.Customer;

public class NoSqlCustomer extends Customer {
    private String name;
    private String emailAddress;


    public NoSqlCustomer() {
    }

    public NoSqlCustomer(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }


    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getEmailAddress() {
        return null;
    }
    public static class Builder implements Customer.Builder {
        private String name;
        private String emailAddress;

        @Override
        public Customer.Builder name(String name) {
            this.name = name;
            return this;
        }


        @Override
        public Customer.Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        @Override
        public Customer build() {
            return new NoSqlCustomer(name, emailAddress);
        }
    }

    @Override
    public String toString() {
        return "PlainCustomer{" +
            ", name='" + name + '\'' +
            ", emailAddress='" + emailAddress + '\'' +
            '}';
    }
}
