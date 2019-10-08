import java.util.LinkedList;

public class LRUCache implements Cache {

    private int size;
    private Storage storage;
    private int hits, misses;
    private LinkedList<Integer> cache = new LinkedList();

    public LRUCache(int size) {
        this.storage = new Storage();

    }

    @Override
    public int get(int e) {
        int index = cache.indexOf(e);
        if(index >=0){
            int el = cache.get(index);
            cache.remove(el);
            cache.addFirst(el);
            if(size>4){
            cache.removeLast();}
            hits += 1;
            return(el);
        }
        int el = storage.get(e);
        cache.addFirst(el);
        cache.removeLast();
        misses +=1;
        return(el);

    }

    @Override
    public int getHits() {
        return hits;
    }

    @Override
    public int getMisses() {
        return misses;
    }

    @Override
    public Integer[] getCacheOrder() {
        Integer[]array = cache.toArray(new Integer[cache.size()]);
        for (int i = 0; i < cache.size(); i++) {
            array[i] = cache.get(i);
        }
      return array;
    }
}
