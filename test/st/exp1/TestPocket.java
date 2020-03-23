package st.exp1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestPocket {

	Pocket p = null;
	private int n;

	public TestPocket(int n) {
		// TODO Auto-generated constructor stub
		System.out.println("constructor");
		this.n = n;
	}

	@Before
	public void setUp() {
		p = new Pocket();
		p.pocketInit();
	}

	@Parameters
	public static Collection prepareData() {
		System.out.println("prepare data");
		// test 0 ~ 100 cases
		Object[][] testList = new Object[100][1];
		for (int i = 0; i < 100; i++) {
			testList[i][0] = i;
		}
		return Arrays.asList(testList);
	}

	@Test
	public void test() {
		System.out.println("test" + n);
		p.pocketInit();
		boolean flag = p.getMoneySimple(n);
		int cnt = 0;
		for (int j = 0; j < p.l; j++) {
			cnt += p.pocket[j];
		}
		if (flag) {
			assertEquals(cnt, n);
		}
	}

}
