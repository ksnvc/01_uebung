import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Test cases for random cache.
 */
public class RandomCacheTest {

    @Test
    public void testRandomCacheSimple() {
        Cache c = new RandomCache(3);

        // get 2 which was not in the cache (= miss)
        int v = c.get(2);
        Assert.assertEquals(2, v);
        Assert.assertEquals(1, c.getMisses());

        // get 3 which was not in the cache (= miss)
        v = c.get(3);
        Assert.assertEquals(3, v);
        Assert.assertEquals(2, c.getMisses());

        // get 2 again  ... now it should be a hit
        v = c.get(2);
        Assert.assertEquals(2, v);
        Assert.assertEquals(2, c.getMisses());
        Assert.assertEquals(1, c.getHits());
    }

    @Test
    public void testLRUCacheComplex() {
        Cache c = new RandomCache(4);

        int v = c.get(0);
        Assert.assertEquals(0, v);
        Assert.assertEquals(1, c.getMisses());
        Assert.assertEquals(0, c.getHits());
        System.out.println(Arrays.toString(c.getCacheOrder()));

        v = c.get(1);
        Assert.assertEquals(1, v);
        Assert.assertEquals(2, c.getMisses());
        Assert.assertEquals(0, c.getHits());
        System.out.println(Arrays.toString(c.getCacheOrder()));

        v = c.get(2);
        Assert.assertEquals(2, v);
        Assert.assertEquals(3, c.getMisses());
        Assert.assertEquals(0, c.getHits());
        System.out.println(Arrays.toString(c.getCacheOrder()));

        v = c.get(4);
        Assert.assertEquals(4, v);
        Assert.assertEquals(4, c.getMisses());
        Assert.assertEquals(0, c.getHits());
        System.out.println(Arrays.toString(c.getCacheOrder()));

        v = c.get(4);
        Assert.assertEquals(4, v);
        Assert.assertEquals(4, c.getMisses());
        Assert.assertEquals(1, c.getHits());
        System.out.println(Arrays.toString(c.getCacheOrder()));

        v = c.get(1);
        Assert.assertEquals(1, v);
        Assert.assertEquals(4, c.getMisses());
        Assert.assertEquals(2, c.getHits());
        System.out.println(Arrays.toString(c.getCacheOrder()));

        v = c.get(5);
        Assert.assertEquals(5, v);
        Assert.assertEquals(5, c.getMisses());
        Assert.assertEquals(2, c.getHits());
        System.out.println(Arrays.toString(c.getCacheOrder()));

        v = c.get(4);
        Assert.assertEquals(4, v);
        Assert.assertEquals(5, c.getMisses());
        Assert.assertEquals(3, c.getHits());
        System.out.println(Arrays.toString(c.getCacheOrder()));

        v = c.get(7);
        Assert.assertEquals(7, v);
        Assert.assertEquals(6, c.getMisses());
        Assert.assertEquals(3, c.getHits());
        System.out.println(Arrays.toString(c.getCacheOrder()));
    }
}