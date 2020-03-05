package org.learn.store.services.doubles;


import org.learn.store.entities.Cart;

public class InMemoryCartSpyGateway extends InMemoryCartGateway {
    private boolean saveCalled = false;

    @Override
    public Cart save(Cart entity) {
        saveCalled = true;
        return super.save(entity);
    }

    public boolean wasSaveCalled() {
        return saveCalled;
    }

    public void resetSpy() {
        saveCalled = false;
    }
}
