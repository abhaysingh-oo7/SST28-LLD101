import java.util.List;

interface DistributionStrategy {
    CacheNode getNode(String key, List<CacheNode> nodes);
}