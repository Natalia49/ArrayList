import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestArray {
    private Array<Integer> array;

    @Before
    public void init() {
        array = new Array<>();
    }
    @After
    public void destroy() {
        array = null;
    }
    @Test
    public void addTest() {
        array.add(1);
        Assert.assertTrue(array.getByIndex(0) == 1);
        Assert.assertTrue(array.size() == 1);
    }
    @Test
    public void isEmptyTest() {
        Assert.assertTrue(array.isEmpty());
    }
    @Test(expected = IllegalArgumentException.class)
    public void getTest() {
        array.add(4);
        Assert.assertTrue(array.getByIndex(0) == 4);
        array.getByIndex(50);
    }
    @Test(expected = IllegalArgumentException.class)
    public void removeTest() {
        int prev = array.size();
        array.removeByIndex(0);
        Assert.assertFalse(prev == array.size());
        array.removeByIndex(20);
    }
    @Test
    public void sizeTest() {
        array = new Array<>(1);
        array.add(2);
        array.add(5);
        Assert.assertTrue(array.size() == 2);
    }
    @Test
    public void addAllTest() {
        Integer [] mass = {5, 8, 3, 9, 0, 7};
        array.addAll(mass);
        Assert.assertTrue(array.getByIndex(0) == 5);
        Assert.assertTrue(array.size() == 6);
    }
    @Test
    public void addByIndexTest() {
        array.addByIndex(1, 0);
        Assert.assertTrue(array.getByIndex(0) == 1);
        Assert.assertTrue(array.size() == 1);
        array.addByIndex(4, 0);
        Assert.assertTrue(array.getByIndex(0) == 4);
        Assert.assertTrue(array.getByIndex(1) == 1);
    }
}
