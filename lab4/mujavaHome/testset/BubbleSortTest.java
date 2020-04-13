import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {
    @Test
    public void bubbleSort() {
        int arr[] = new int[]{1, 6, 2, 2, 5};
        int[] expect = {1, 2, 2, 5, 6};
        assertArrayEquals(expect, BubbleSort.BubbleSort(arr));
    }
}
