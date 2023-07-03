package pro.sky.AlgorithmsPart3;

import exception.ArrayIndexOutBondsException;
import exception.ElementMissingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.IntegerListService;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerListTest {
    private final IntegerListService IntegerList = new IntegerListService();
    @BeforeEach
    public void List() {
        IntegerList.add(33);
        IntegerList.add(15);
        IntegerList.add(1);
    }

    @Test
    @AfterEach
    public void clear() {
        assertNull(IntegerList.clear());
    }
    @Test
    public void add() {
        IntegerList.add(6);
        IntegerList.add(8);
        Integer expected = 7;
        Integer actual = IntegerList.add(7);
        assertEquals(expected, actual);
    }
    @Test
    public void addIndex() {
        assertEquals(66, IntegerList.add(1, 66));
    }
    @Test
    public void addIndexException() {
        assertThrows(ArrayIndexOutBondsException.class, () -> IntegerList.add(4, 90));
    }
    @Test
    public void set() {
        assertEquals(85, IntegerList.set(1, 85));
    }
    @Test
    public void setIndexException() {
        assertThrows(ArrayIndexOutBondsException.class, () -> IntegerList.set(4, 76));
    }
    @Test
    public void remove() {
        Integer actual = 15;
        assertEquals(15,IntegerList.remove(actual));
    }
    @Test
    public void removeIndex() {
        assertEquals(15,IntegerList.remove(1));
    }
    @Test
    public void removeIndexException() {
        assertThrows(ElementMissingException.class, () -> IntegerList.remove(4));
        assertThrows(ArrayIndexOutBondsException.class, () -> IntegerList.remove(5));
    }
    @Test
    public void contains() {
        assertTrue(IntegerList.contains(33));
        assertFalse(IntegerList.contains(75));
    }
    @Test
    public void indexOf() {
        assertEquals(-1,IntegerList.indexOf(76));
        assertEquals(0,IntegerList.indexOf(33));
    }
    @Test
    public void LastIndexOf() {
        assertEquals(-1,IntegerList.lastIndexOf(76));
    }
    @Test
    public void get() {
        assertEquals(15,IntegerList.get(1));
        assertNull(IntegerList.get(4));
    }
    @Test
    public void getException() {
        assertThrows(ArrayIndexOutBondsException.class, () -> IntegerList.get(6));
    }
    @Test
    public void size() {
        assertEquals(3,IntegerList.size());
    }

    @Test
    public void isEmptyTrue() {
        IntegerList.clear();
        assertTrue(IntegerList.isEmpty());
    }
    @Test
    public void isEmptyFalse() {
        assertFalse(IntegerList.isEmpty());
    }

    @Test
    public void toArray() {
        Integer[] expected = {33, 15, 1, null, null};
        Integer[] actual = IntegerList.toArray();
        assertArrayEquals(expected,actual);
    }

    @Test
    public void grow() {
        assertEquals(7, IntegerList.grow());
    }
}
