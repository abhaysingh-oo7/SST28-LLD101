public class Main {
    public static void main(String[] args) {

        Database db = new Database();
        DistributionStrategy strategy = new ModuloDistributionStrategy();

        DistributedCache cache = new DistributedCache(
                3,      // number of nodes
                2,      // capacity per node
                strategy,
                db
        );

        System.out.println("---- PUT OPERATIONS ----");
        cache.put("A", "Apple");
        cache.put("B", "Ball");
        cache.put("C", "Cat");

        System.out.println("---- GET OPERATIONS ----");
        System.out.println(cache.get("A")); // from cache
        System.out.println(cache.get("B")); // from cache

        System.out.println("---- CACHE MISS ----");
        System.out.println(cache.get("D")); // from DB

        System.out.println("---- EVICTION TEST ----");
        cache.put("E", "Elephant"); // may trigger eviction

        System.out.println(cache.get("C")); // check if evicted or not
    }
}