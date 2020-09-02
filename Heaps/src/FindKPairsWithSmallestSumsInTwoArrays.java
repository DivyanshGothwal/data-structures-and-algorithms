package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindKPairsWithSmallestSumsInTwoArrays {

	public static void main(String[] args) {
		Integer ar1[] = { 1, 2, 4, 5, 6 };
		Integer ar2[] = { 3, 5, 7, 9 };
		int k = 20;
		FindKPairsWithSmallestSumsInTwoArrays t = new FindKPairsWithSmallestSumsInTwoArrays();
		t.findKSmallestPair(ar1, ar2, k);
	}

	public void findKSmallestPair(Integer[] ar1, Integer[] ar2, int k) {
		CustomHeap c = new CustomHeap(ar1.length);
		c.insert(ar1[0] + ar2[0], 0, 0);
		int l = 0;
		Map<DataHolder, Integer> map = new HashMap<>();
		map.put(new DataHolder(ar1[0] + ar2[0], 0, 0), 1);
		while (l < k) {
			DataHolder data = c.deleteRootAndGetMin();
			if (data == null) {
				return;
			}
			int i = data.i;
			int j = data.j;
			if (i + 1 < ar1.length) {
				Integer left = map.get(new DataHolder(ar1[i + 1] + ar2[j], i + 1, j));
				if (left == null) {
					c.insert(ar1[i + 1] + ar2[j], i + 1, j);
					map.put(new DataHolder(ar1[i + 1] + ar2[j], i + 1, j), 1);
				}
			}
			if (j + 1 < ar2.length) {
				Integer right = map.get(new DataHolder(ar1[i] + ar2[j + 1], i, j + 1));
				if (right == null) {
					c.insert(ar1[i] + ar2[j + 1], i, j + 1);
					map.put(new DataHolder(ar1[i] + ar2[j + 1], i, j + 1), 1);
				}
			}
			l++;
		}
	}
}

class CustomHeap {
	List<DataHolder> minHeap = null;

	CustomHeap(int size) {
		minHeap = new ArrayList<>(size);
	}

	public DataHolder deleteRootAndGetMin() {
		if (minHeap.size() == 0) {
			return null;
		}
		DataHolder min = minHeap.get(0);
		DataHolder lastEle = minHeap.get(minHeap.size() - 1);
		minHeap.remove(minHeap.size() - 1);
		if (minHeap.size() != 0) {
			minHeap.set(0, lastEle);
			downHeapify(0);
		}
		return min;
	}

	public void insert(Integer sum, Integer i, Integer j) {
		minHeap.add(new DataHolder(sum, i, j));
		upHeapify();
	}

	private void upHeapify() {
		int currentIndex = minHeap.size() - 1;
		int parentIndex = (currentIndex - 1) / 2;
		while (currentIndex > 0) {
			DataHolder currentEle = minHeap.get(currentIndex);
			DataHolder parentEle = minHeap.get(parentIndex);
			if (parentEle.sum > currentEle.sum) {
				minHeap.set(parentIndex, currentEle);
				minHeap.set(currentIndex, parentEle);
			}
			currentIndex = parentIndex;
			parentIndex = (currentIndex - 1) / 2;
		}
	}

	private void downHeapify(int index) {
		if (index >= minHeap.size()) {
			return;
		}
		int currentIndex = index;
		int leftIndex = (2 * currentIndex) + 1;
		int rightIndex = (2 * currentIndex) + 2;
		DataHolder currentEle = minHeap.get(currentIndex);
		if (leftIndex < minHeap.size() && minHeap.get(leftIndex).sum < minHeap.get(currentIndex).sum) {
			DataHolder leftEle = minHeap.get(leftIndex);
			minHeap.set(currentIndex, leftEle);
			minHeap.set(leftIndex, currentEle);
			downHeapify(leftIndex);
		}
		currentEle = minHeap.get(currentIndex);
		if (rightIndex < minHeap.size() && minHeap.get(rightIndex).sum < minHeap.get(currentIndex).sum) {
			DataHolder rightEle = minHeap.get(rightIndex);
			minHeap.set(currentIndex, rightEle);
			minHeap.set(rightIndex, currentEle);
			downHeapify(rightIndex);

		}
	}
}

class DataHolder {
	Integer sum, i, j;

	DataHolder(Integer sum, Integer i, Integer j) {
		this.sum = sum;
		this.i = i;
		this.j = j;
	}

	@Override
	public int hashCode() {
		int hash = this.i + this.j + this.sum;
		return hash;
	}

	@Override
	public boolean equals(Object d) {
		if (d == null) {
			return false;
		}
		if (d instanceof DataHolder) {
			DataHolder newD = (DataHolder) d;
			DataHolder currentD = this;
			if (newD.i.equals(currentD.i) && newD.j.equals(currentD.j)) {
				return true;
			}
		}
		return false;
	}
}