import java.util.*;

/**
 * LRUCache implementation
 * @param <T>
 */
public class LRUCache<T> {
    private int capacity;
    private Deque<T> deque;
    private Set<T> set;

    /**
     * ctor
     * @param capacity cache size
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        deque = new LinkedList<>();
        set = new HashSet<>();
    }

    /**
     * Cache last recently used element
     * @param element element to be cached
     */
    public void cache(T element) {
        if (!set.contains(element)) {
            if (deque.size() == capacity) {
                T removed = deque.removeLast();
                set.remove(removed);
            }
        } else {
            deque.remove(element);
        }

        set.add(element);
        deque.push(element);
    }

    /**
     * Get string representation of current cache contents
     * @param delimiter delimiter char sequence
     * @return string representation
     */
    public String getCacheStringRepresentation(String delimiter) {
        StringJoiner joiner = new StringJoiner(delimiter);
        Iterator<T> iterator = deque.descendingIterator();

        while (iterator.hasNext()) {
            joiner.add(iterator.next().toString());
        }

        return joiner.toString();
    }
}
