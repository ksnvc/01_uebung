
import java.util.Random;

public class RandomCache implements Cache {

    private Storage storage;
    private int size;
    private int hits=0;
    private int misses=0;
    private Random rnd = new Random();
    private Integer[] cache;


    public RandomCache(int size) {
        this.storage = new Storage();
        this.cache = new java.lang.Integer[size];
    }

    @Override
    public int get(int e) {
        for(int i : cache){
        if(cache[i]==null){
            continue;}
           if(cache[i]== e){
               hits+=1;
               return(cache[i]);
           }
        }
        int random = rnd.nextInt(size);
        cache[random-1] = storage.get(e);
            misses+=1;
        return(cache[random]);
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
        return cache;
    }
}
