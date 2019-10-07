public abstract class AbstractCache implements Cache{

    protected int size;
    protected int hits;
    protected int misses;
    protected Storage storage;

    public AbstractCache(int size) {
        this.size   = size;
        this.hits   = 0;
        this.misses = 0;
        this.storage = new Storage();
    }

    public abstract int get(int e);

    public int getHits() {
        return this.hits;
    }

    public int getMisses() {
        return this.misses;
    }

    public abstract Integer[] getCacheOrder();

    protected abstract void reorganize(int z);
}
