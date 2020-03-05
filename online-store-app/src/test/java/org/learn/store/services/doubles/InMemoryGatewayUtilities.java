package org.learn.store.services.doubles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.learn.store.entities.Entity;

public class InMemoryGatewayUtilities<T extends Entity> {
    protected Map<String, T> entities = new HashMap<>();

    public void empty() {
        entities = new HashMap<>();
    }

    public Optional<T> findById(String id) {
        T e = entities.get(id);
        return (e == null) ? Optional.empty() : Optional.of(getClone(e));
    }


    public boolean checkAvailability(String reference) {
        return false;
    }

    public T save(T entity) {
        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID().toString());
        }
        entities.put(entity.getId(), getClone(entity));
        return entities.get(entity.getId());
    }

    protected T getClone(T e) {
        try {
            return (T) e.clone();
        } catch (CloneNotSupportedException e1) {
            throw new NonClonableEntity();
        }
    }

    public Map<String, T> findAll() {
        Map<String, T> clonedEntities = new HashMap<>();
        for (String key : entities.keySet())
            clonedEntities.put(key, getClone(entities.get(key)));
        return clonedEntities;
    }

    public List<T> listAll() {
        List<T> clonedList = new ArrayList<>();
        for (String key : entities.keySet())
            clonedList.add(getClone(entities.get(key)));
        return clonedList;
    }

    private static class NonClonableEntity extends RuntimeException {
    }
}
