import java.util.LinkedHashSet;

class LRUEvictionPolicy implements EvictionPolicy {
    private LinkedHashSet<String> order = new LinkedHashSet<>();

    @Override
    public void keyAccessed(String key) {
        order.remove(key);
        order.add(key);
    }

    @Override
    public String evictKey() {
        String first = order.iterator().next();
        order.remove(first);
        return first;
    }
}