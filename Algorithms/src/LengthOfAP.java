package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class LengthOfAP {
	public static void main(String args[]) throws Exception {

		FasterIO1 sc = new FasterIO1();

		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] ar = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			ar[i] = sc.nextInt();
		}
		int k = 0;
		while (k < q) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int d = sc.nextInt();
			if (l == r) {
				System.out.println("1");
			} else {
				Tuple2 t = (findContigiousAP(ar, l, r, d));
				System.out.println("end : " + t.endIndex + " start : " + t.startIndex + " maxCount: " + t.maxCount);
			}
			k++;
		}

		// Write your code here

	}

	static Tuple2 findContigiousAP(int[] ar, int l, int r, int d) {
		if (r >= l) {
			if (r - l == 1) {
				if (ar[r] - ar[l] == d) {
					return new Tuple2(2, l, r, 2, l, r, 2, l, r);
				} else {
					return new Tuple2(0, -1, -1, 0, -1, -1, 0, -1, -1);
				}
			} else if (r == l) {
				return new Tuple2(1, l, r, 1, l, r, 1, l, r);
			}
			if (l > 0 && r > 0) {
				int mid = r + ((l - r) / 2);
				Tuple2 left = findContigiousAP(ar, l, mid, d);
				Tuple2 right = findContigiousAP(ar, mid + 1, r, d);

				int midCount = 0, midStart = -1, midEnd = -1;
				if(right.leftStart >=0 && left.rightEnd>=0) {
					if (left.rightEnd + 1 == right.leftStart && ar[right.leftStart] - ar[left.rightEnd] == d) {
						midCount = left.rightCount+ right.leftCount;
						midStart = left.rightStart;
						midEnd = right.leftEnd;
					}
				}

				int maxCount = 0;
				int startIndex = -1;
				int endIndex = -1;
				if (left.maxCount > right.maxCount) {
					if (left.maxCount > midCount) {
						maxCount = left.maxCount;
						startIndex = left.startIndex;
						endIndex = left.endIndex;
					} 
					else {
						maxCount = midCount;
						startIndex = midStart;
						endIndex = midEnd;
					}
				} 
				else if (left.maxCount <= right.maxCount) {
					if (right.maxCount > midCount) {
						maxCount = right.maxCount;
						startIndex = right.startIndex;
						endIndex = right.endIndex;
					} 
					else {
						maxCount = midCount;
						startIndex = midStart;
						endIndex = midEnd;
					}
				}
				if(left.leftEnd+1 == right.rightStart && ar[right.rightStart]-ar[left.leftEnd]==d ) {
					return new Tuple2(maxCount, startIndex, endIndex, left.leftCount+right.rightCount, left.leftStart, right.rightEnd, left.leftCount+right.rightCount, left.leftStart, right.rightEnd);
				}
				if(left.rightEnd+1 == right.rightStart && ar[right.rightStart]-ar[left.rightEnd]==d && left.leftEnd+1 == right.leftStart && ar[right.leftStart]-ar[left.leftEnd]==d ) {
					return new Tuple2(maxCount, startIndex, endIndex, left.leftCount+right.leftCount, left.leftStart, right.leftEnd, right.rightCount+ left.rightCount, left.rightStart, right.rightEnd  );
				}
				if(left.rightEnd+1 == right.rightStart && ar[right.rightStart]-ar[left.rightEnd]==d) {
					return new Tuple2(maxCount, startIndex, endIndex, left.leftCount, left.leftStart, left.leftEnd, right.rightCount+ left.rightCount, left.rightStart, right.rightEnd );
				}
				if(left.leftEnd+1 == right.leftStart && ar[right.leftStart]-ar[left.leftEnd]==d ) {
					return new Tuple2(maxCount, startIndex, endIndex, left.leftCount + right.leftCount, left.leftStart, right.leftEnd, right.rightCount, right.rightStart, right.rightStart );
				}
				if(ar[mid+1]-ar[mid]==d) {
					
				}
				return new Tuple2(maxCount, startIndex, endIndex, left.leftCount, left.leftStart, left.leftEnd, right.rightCount, right.rightStart, right.rightEnd);
				

//				if (left.endIndex + 1 == right.startIndex && right.startIndex>=0 && left.endIndex>=0 && (ar[right.startIndex] - ar[left.endIndex] == d)) {
//					return new Tuple2(left.maxCount + right.maxCount, left.startIndex, right.endIndex);
//				} 
//				else if(right.startIndex>=0 && left.endIndex>=0 ) {
//					if (left.maxCount > right.maxCount) {
//						return new Tuple2(left.maxCount, left.startIndex, left.endIndex);
//					} 
//					else {
//						return new Tuple2(right.maxCount, right.startIndex, right.endIndex);
//					}
//				}
//				else {
////					return 
//				}
			} else {
				return new Tuple2(0, -1, -1, 0, -1, -1, 0, -1, -1);
			}
		}
		return new Tuple2(0, -1, -1, 0, -1, -1, 0, -1, -1);
	}

}

class Tuple2 {
	int maxCount;
	int startIndex;
	int endIndex;

	int rightCount;
	int rightStart;
	int rightEnd;

	int leftCount;
	int leftStart;
	int leftEnd;

	Tuple2(int maxCount, int startIndex, int endIndex, int leftCount,
			int leftStart, int leftEnd, int rightCount, int rightStart, int rightEnd) {
		this.maxCount = maxCount;
		this.endIndex = endIndex;
		this.startIndex = startIndex;
		this.rightCount = rightCount;
		this.leftCount = leftCount;
		this.leftStart = leftStart;
		this.leftEnd = leftEnd;
		this.rightStart = rightStart;
		this.rightEnd = rightEnd;
	}
}
/*
10 1
1 2 4 5 8 9 1 13 1 17
1 10 2
2 4 2
 * */

class FasterIO1 {
	 
    private byte[] buf = new byte[8192];
    private int curChar;
    private int numChars;
    private PrintWriter pw;
     
    FasterIO1() {
        pw = new PrintWriter(System.out);
    }
 
    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = System.in.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }
    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
    public void print(long s) {
        pw.print(s);
    }
    public void close() {
        pw.close();
    }
    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }
}
