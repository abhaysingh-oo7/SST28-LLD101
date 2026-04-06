import java.util.*;

class DistributedCache {
    private List<CacheNode> nodes;
    private DistributionStrategy strategy;
    private Database database;

    public DistributedCache(int numNodes, int nodeCapacity,
                            DistributionStrategy strategy,
                            Database database) {
        this.nodes = new ArrayList<>();
        this.strategy = strategy;
        this.database = database;

        for (int i = 0; i < numNodes; i++) {
            nodes.add(new CacheNode(nodeCapacity, new LRUEvictionPolicy()));
        }
    }

    public String get(String key) {
        CacheNode node = strategy.getNode(key, nodes);
        String value = node.get(key);

        if (value != null) return value;

        value = database.get(key);
        node.put(key, value);
        return value;
    }

    public void put(String key, String value) {
        CacheNode node = strategy.getNode(key, nodes);
        node.put(key, value);

        database.put(key, value);
    }
}