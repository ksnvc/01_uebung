
import java.util.Random;

public class RandomCache extends AbstractCache {

    private Integer[] cache;
    private Random rnd = new Random();

    public RandomCache(int size) {
        super(size);
        this.cache  = new Integer[size];
    }

    @Override
    public int get(int e) {
        int element;

        for (int i = 0; i < this.cache.length; i++) {
            if (this.cache[i] != null && this.cache[i] == e) {
                element = this.cache[i];
                this.hits++;
                return element;
            }
        }

        element = storage.get(e);
        this.misses++;
        reorganize(element);
        return element;
    }

    @Override
    public Integer[] getCacheOrder() {
        return this.cache;
    }

    @Override
    protected void reorganize(int z) {
        int i = rnd.nextInt(this.size);
        this.cache[i] = z;
    }
}
