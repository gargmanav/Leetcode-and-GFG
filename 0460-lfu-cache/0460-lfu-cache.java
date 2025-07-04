import java.util.*;

class LFUCache {
    private int capacity, minFreq;
    private Map<Integer, Integer> keyToVal;
    private Map<Integer, Integer> keyToFreq;
    private Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;

        // Increase frequency
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        // Remove key from current freq bucket
        freqToKeys.get(freq).remove(key);

        // Clean up empty freq bucket
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == minFreq) minFreq++; // update minFreq
        }

        // Add to new freq bucket
        freqToKeys.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);

        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        // If key exists, update value and freq
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key); // increase frequency
            return;
        }

        // If capacity is full, evict LFU key
        if (keyToVal.size() == capacity) {
            int evictKey = freqToKeys.get(minFreq).iterator().next();
            freqToKeys.get(minFreq).remove(evictKey);
            if (freqToKeys.get(minFreq).isEmpty()) {
                freqToKeys.remove(minFreq);
            }
            keyToVal.remove(evictKey);
            keyToFreq.remove(evictKey);
        }

        // Add new key
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFreq = 1; // new key has freq 1
    }
}


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */