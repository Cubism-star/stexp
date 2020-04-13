import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackPackTest {
    BackPack backPack;

    @Test
    public void backPack_Solution() {
        //最大容量为10
        int m = 10;
        int n = 3;
        /*
        放入的三个物体重量分别为3， 4， 5；价值分别为4， 5， 6
         */
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
        int[][] exepct = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4},
                {0, 0, 0, 4, 5, 5, 5, 9, 9, 9, 9},
                {0, 0, 0, 4, 5, 6, 6, 9, 10, 11, 11}
        };
        backPack = new BackPack();
        int[][] t = backPack.BackPack_Solution(m, n, w, p);
        assertArrayEquals(exepct, backPack.BackPack_Solution(m, n, w, p));
    }
}

