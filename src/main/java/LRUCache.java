import java.util.LinkedList;

public class LRUCache extends AbstractCache {

    private LinkedList<Integer> cache;

    public LRUCache(int size) {
        super(size);
        this.cache  = new LinkedList();
    }

    @Override
    public int get(int e) {
        int element;
        int index = this.cache.indexOf(e);
        if (index >= 0) {
            element = this.cache.get(index);
            this.cache.remove(index);
            this.hits++;
        }
        else {
            element = storage.get(e);
            this.misses++;
        }
        reorganize(element);
        return element;
    }

    @Override
    public Integer[] getCacheOrder() {
        Integer[] a = new Integer[this.cache.size()];
        return this.cache.toArray(a);
    }

    @Override
    protected void reorganize(int z) {
        this.cache.addFirst(z);
        if (this.cache.size() > this.size) {
            this.cache.removeLast();
        }
    }
}
