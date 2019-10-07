public interface Cache {

    /**
     * Gets an element e from cache
     * @param e Element to retrieve from cache
     * @return Element e
     */
    int get(int e);

    /**
     * Returns the numbers of cache hits
     * @return Cache hits
     */
    int getHits();

    /**
     * Returns the numbers of cache hits
     * @return Cache hits
     */
    int getMisses();

    /**
     * Should return the internal cache order as Integer[].
     * @return Integer[]
     */
    Integer[] getCacheOrder();

}
