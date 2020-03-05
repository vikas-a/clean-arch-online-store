package org.learn.store.entities;

public abstract class Entity implements Cloneable {
    private String id;

    protected Entity(String id) {
        this.id = id;
    }

    protected Entity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
