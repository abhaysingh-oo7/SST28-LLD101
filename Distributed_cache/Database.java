import java.util.*;

class Database {
    private Map<String, String> storage = new HashMap<>();

    public String get(String key) {
        return storage.getOrDefault(key, "DB_VALUE_" + key);
    }

    public void put(String key, String value) {
        storage.put(key, value);
    }
}