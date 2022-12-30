import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * LRUCache test class {@link LRUCache}
 */
public class LRUCacheTest {
    private final static int CAPACITY = 5;
    private final static String EXPECTED = "C-A-E-D-Z";
    private final static String DELIMITER = "-";
    private LRUCache<String> cache;

    @Before
    public void before() {
        cache = new LRUCache<>(CAPACITY);
    }

    /**
     * Success scenario
     */
    @Test
    public void getCacheStringRepresentationTestSuccess() {
        String[] arr = new String[]{"A", "B", "C", "D", "A", "E", "D", "Z"};

        Arrays.asList(arr).stream().forEach(cache::cache);

        String actual = cache.getCacheStringRepresentation(DELIMITER);

        Assert.assertEquals(EXPECTED, actual);
    }
}
