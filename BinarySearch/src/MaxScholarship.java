package src;

public class MaxScholarship {

	public static void main(String ar[]) {
		int numOfStudents = 10;
		int numOfDiscountCoupons = 20;
		int numberOfRequiredCouponsForDiscount = 4;
		int numberOfcouponsFromWeekStudents = 4;
		System.out.println(findMaxStudentsToGetDiscounts(numOfStudents, numOfDiscountCoupons,
				numberOfRequiredCouponsForDiscount, numberOfcouponsFromWeekStudents));
	}

	private static int findMaxStudentsToGetDiscounts(int n, int m, int x, int y) {
		int start = 1;
		int end = n;
		int ans = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			ans = mid;
			if (solve(mid, n, m, x, y)) {
				start = mid + 1;

			} else {
				end = mid - 1;
			}
		}
		return ans;
	}

	private static boolean solve(int mid, int n, int m, int x, int y) {
		return (mid * x) <= (m + ((n - mid) * y));
	}
}
