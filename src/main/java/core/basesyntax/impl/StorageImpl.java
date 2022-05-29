package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private final Object [] keys;
    private final Object [] values;
    private int numberOfElements;

    public StorageImpl() {
        keys = new Object[MAX_ELEMENTS];
        values = new Object[MAX_ELEMENTS];
        numberOfElements = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            if (values[i] == null) {
                values[i] = value;
                keys[i] = key;
                numberOfElements++;
                return;
            }
            if (key == null && keys[i] == null || keys[i] != null && key != null
                    && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < numberOfElements; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

}
