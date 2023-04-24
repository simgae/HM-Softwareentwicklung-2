package edu.hm.gaertner.simon.lab23.a34;

import edu.hm.cs.rs.se.ss23.Xmark;

import java.util.HashMap;
import java.util.Map;
import java.util.AbstractMap;
import java.util.Set;


/**
 * Task 3.4.
 *
 * @param <K> - type of keys.
 * @param <V> - type of values.
 */
@Xmark("a34")
public class SymmetricMap<K, V> extends AbstractMap<K, V> {

    /**
     * Delegate map.
     */
    private final Map<K, V> delegate = new HashMap<>();

    @Override
    public Set<Entry<K, V>> entrySet() {
        return delegate.entrySet();
    }

    @Override
    public V put(K key, V value) {

        V result = null;
        if (delegate.containsValue(value)) {
            final K keyOfValue = findKeyInMap(value, delegate);
            result = delegate.remove(keyOfValue);
        }
        delegate.put(key, value);
        return result;
    }


    /**
     * Find key by value in map.
     *
     * @param value    value of map.
     * @param <K>      - type of keys
     * @param <V>      - type of values
     * @param delegate - map
     * @return key of value.
     */
    public static <K, V> K findKeyInMap(V value, Map<K, V> delegate) {

        K result = null;

        for (Map.Entry<K, V> entry : delegate.entrySet()) {
            if (entry.getValue().equals(value))
                result = entry.getKey();

        }
        return result;
    }

    /**
     * Revert map. Exchange keys and values.
     *
     * @return new symmetric map with exchanged keys and values.
     */
    public SymmetricMap<V, K> revert() {

        final SymmetricMap<V, K> result = new SymmetricMap<>();

        for (Map.Entry<K, V> entry : delegate.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }

        return result;
    }
}
