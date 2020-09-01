package src;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

	private static List<Integer> minHeap = new ArrayList<>();

	public static void main(String ar[]) {
		insertMinHeap(11);
		insertMinHeap(2);
		insertMinHeap(1);
		insertMinHeap(15);
		insertMinHeap(5);
		insertMinHeap(4);
		insertMinHeap(45);
		System.out.println(minHeap);
	}

	public static void insertMinHeap(Integer data) {
		minHeap.add(data);
		if (!minHeap.isEmpty()) {
			heapify(minHeap.size() - 1);
		}
	}

	public static Integer extractMin() {
		Integer root = minHeap.get(0);
		Integer lastEle = minHeap.get(minHeap.size() - 1);
		minHeap.set(0, lastEle);
		minHeap.set(minHeap.size() - 1, root);
		heapify(minHeap.size() - 1);
		return root;
	}

	public static void changeKey(Integer index, Integer newValue) {
		Integer lastEle = minHeap.get(minHeap.size() - 1);
		minHeap.set(index, lastEle);
		minHeap.set(minHeap.size() - 1, newValue);
		heapify(minHeap.size() - 1);
	}

	private static void heapify(Integer index) {
		int currentIndex = index;
		int parentIndex = (currentIndex - 1) / 2;
		while (currentIndex > 0) {
			Integer parentEle = minHeap.get(parentIndex);
			Integer currentEle = minHeap.get(currentIndex);
			if (parentEle > currentEle) {
				minHeap.set(parentIndex, currentEle);
				minHeap.set(currentIndex, parentEle);
			}
			if (parentIndex == 0) {
				break;
			}
			currentIndex = parentIndex;
			parentIndex = (parentIndex - 1) / 2;
		}
	}
}
