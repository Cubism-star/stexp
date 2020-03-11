package st.exp1;

public class Pocket {
	/*
	 * There is one 50 yuan, one 20 yuan, one 10 yuan, two 5 yuan bills and three 1
	 * yuan coins in your pocket. Write a program to find out whether you can take
	 * out a given number (x) yuan.
	 */
	int[] constPocket;
	int[] pocket;
	int l;
	
	public Pocket() {
		constPocket = new int[] {50, 20, 10, 5, 5, 1, 1, 1 };
		l = constPocket.length;
	}

	public boolean getMoneySimple(int n) {
		for(int i = 0; i < l; i++) {
			if(n >= pocket[i]) {
				n -= pocket[i];
			}else {//if not taken 
				pocket[i] = 0;
			}
		}
		// check for the last iteration
		return n == 0;
	}
	
	public void pocketInit() {
		pocket = new int[l];
		for (int i = 0; i < l; i++) {
			pocket[i] = constPocket[i];
		}
	}
}
