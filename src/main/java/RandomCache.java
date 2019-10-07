
import java.util.Random;

public class RandomCache implements Cache {

    private Storage storage;
    private int size;
    private int hits;
    private int misses;
    private Random rnd = new Random();



    public RandomCache(int size) {
        this.storage = new Storage();

    }

}
