
public class LRUCache implements Cache {

    private int size;
    private Storage storage;
    private int hits, misses;

    public LRUCache(int size) {
        this.storage = new Storage();

    }

}
