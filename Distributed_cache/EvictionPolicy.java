interface EvictionPolicy {
    void keyAccessed(String key);
    String evictKey();
}