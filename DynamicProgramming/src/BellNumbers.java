package src;

public class BellNumbers {

	public static void main(String[] ar) {
		Integer n = 8;
		System.out.println(findBellNumbers(n));
	}

	/**
	 * DP solution sets[i][j] -> number of ways to partition i elements by forming j
	 * sets
	 * 
	 * sets[i][j] = sets[i-1][j-1] + (j*sets[i-1][j])
	 * 
	 * 
	 * for sets[i][j] there are two possibilities
	 * 
	 * 1) let ith element form its own set and let i-1 elements form j-1 sets
	 * 
	 * 2) let i-1 elements for j sets and include ith element to these sets to form
	 * distinct sets which is equivalent to (k * sets[i-1][j])
	 * 
	 * eg: i=3 and j=2 sets[3][2] = sets[2][1]+sets[2][2]*2;
	 * 
	 * sets[2][1]= {1,2} , now if we include 3 to these sets then it will form 2
	 * unique sets. {13,2} {1,23}
	 * 
	 * @param n
	 * @return
	 */
	public static Integer findBellNumbers(int n) {
		int[][] sets = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j == 1) {
					sets[i][j] = 1;
					continue;
				}
				sets[i][j] = sets[i - 1][j - 1] + (j * sets[i - 1][j]);
			}
		}
		int sol = 0;
		for (int i = 0; i <= n; i++) {
			sol += sets[n][i];
		}
		return sol;
	}
}
