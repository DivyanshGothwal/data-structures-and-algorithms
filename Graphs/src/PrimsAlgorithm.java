package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimsAlgorithm {
	static List<Edge> edges = null;

	public static void main(String ar[]) {
		List<List<Edge>> graph = new ArrayList<>();
		int m = 8;
		for (int i = 0; i <= m; i++) {
			graph.add(new ArrayList<>());
		}
		edges = new ArrayList<>();
		addUndirectedEdge(graph, 1, 2, 10);
		addUndirectedEdge(graph, 2, 4, 5);
		addUndirectedEdge(graph, 4, 8, 12);
		addUndirectedEdge(graph, 8, 5, 1);
		addUndirectedEdge(graph, 1, 5, 8);
		addUndirectedEdge(graph, 5, 3, 6);
		addUndirectedEdge(graph, 3, 6, 5);
		addUndirectedEdge(graph, 6, 7, 7);
		addUndirectedEdge(graph, 1, 7, 4);
		addUndirectedEdge(graph, 1, 3, 4);
		addUndirectedEdge(graph, 1, 4, 2);
		findMST(graph);
		/**
		 * from: 1 to: 2 from: 1 to: 5 from: 1 to: 7 from: 1 to: 3 from: 1 to: 4 from: 8
		 * to: 5 from: 7 to: 6 from: 4 to: 2
		 */
		Heap h = new Heap(20);
		h.insert(10, 12);
		h.insert(10, 65);
		h.insert(10, 21);
		h.insert(10, 54);
		h.insert(10, 56);
		h.insert(10, 12);
		h.insert(10, 54);
		h.insert(10, 76);
		h.insert(10, 87);
		h.insert(10, 98);
		h.insert(10, 23);
		h.insert(10, 1);
		h.insert(10, 2);
		h.insert(10, 3);
		h.insert(10, 4);
		h.insert(10, 5);
		h.insert(10, 6);
		h.insert(10, 7);
		h.insert(10, 43);
		Heap.HeapEle g1 = h.new HeapEle(10, 23);
		h.decreasePriority(g1, 14);
		while (!h.isEmpty()) {
			Heap.HeapEle g = h.extractMin();
//			System.out.println(g.priority);
		}
	}

	public static void addUndirectedEdge(List<List<Edge>> graph, int u, int v, int w) {
		graph.get(u).add(new Edge(u, v, w));
		graph.get(v).add(new Edge(v, u, w));
	}

	public static void findMST(List<List<Edge>> graph) {
		Heap h = new Heap(graph.size() + 1);
		int label[] = new int[graph.size()];
		for (int i = 1; i < graph.size(); i++) {
			h.insert(i, Integer.MAX_VALUE);
			label[i] = Integer.MAX_VALUE;
		}
		int set[] = new int[graph.size()];
		set[1] = 1;
		h.decreasePriority(h.new HeapEle(1, Integer.MAX_VALUE), 0);
		label[1] = 0;
		while (!h.isEmpty()) {
			Heap.HeapEle top = h.extractMin();
			List<Edge> list = graph.get(top.e);
			System.out.println("from: " + top.e + " to: " + top.priority);
			for (int i = 0; i < list.size(); i++) {
				Edge adjecentEdge = list.get(i);
				if (set[adjecentEdge.v] == 0 && label[adjecentEdge.v] > adjecentEdge.weight) {
					h.decreasePriority(h.new HeapEle(adjecentEdge.v, label[adjecentEdge.v]), adjecentEdge.weight);
					label[adjecentEdge.v] = list.get(i).weight;
				}
			}
			set[top.e] = 1;
		}
	}
}

class Heap {
	HeapEle[] ele = null;
	Integer size = 0;
	Map<HeapEle, Integer> map = new HashMap<>();

	Heap(int size) {
		ele = new HeapEle[size + 1];
	}

	public void insert(Integer e, Integer priority) {
		size++;
		ele[size] = new HeapEle(e, priority);
		map.put(ele[size], size);
		heapify(size);
	}

	public HeapEle extractMin() {
		HeapEle last = ele[size];
		HeapEle top = ele[1];
		HeapEle temp = new HeapEle(top.e, top.priority);
		top.e = last.e;
		top.priority = last.priority;
		map.remove(ele[size]);
		map.put(ele[1], 1);
		size--;
		topHeapify(1);
		return temp;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public void decreasePriority(HeapEle e, Integer value) {
		Integer index = map.get(e);
		if (index == null) {
			return;
		}
		HeapEle parentEle = ele[index];
		parentEle.priority = value;
		heapify(index);
	}

	public void topHeapify(Integer i) {
		if (i > size) {
			return;
		}
		HeapEle currEle = ele[i];
		Integer leftI = 2 * i;
		Integer rightI = 2 * i + 1;
		if (leftI <= size) {
			HeapEle leftEle = ele[leftI];
			if (leftEle.priority < currEle.priority) {
				HeapEle temp = new HeapEle(currEle.e, currEle.priority);
				currEle.e = leftEle.e;
				currEle.priority = leftEle.priority;
				leftEle.e = temp.e;
				leftEle.priority = temp.priority;
				map.put(currEle, i);
				map.put(leftEle, leftI);
				topHeapify(leftI);
			}
		}
		currEle = ele[i];
		if (rightI <= size) {
			HeapEle rightEle = ele[rightI];
			if (rightEle.priority < currEle.priority) {
				HeapEle temp = new HeapEle(currEle.e, currEle.priority);
				currEle.e = rightEle.e;
				currEle.priority = rightEle.priority;
				rightEle.e = temp.e;
				rightEle.priority = temp.priority;
				map.put(currEle, i);
				map.put(rightEle, rightI);
				topHeapify(rightI);
			}
		}
	}

	public void heapify(Integer i) {
		Integer parentI = (i) / 2;
		while (parentI > 0) {
			HeapEle parentEle = ele[parentI];
			HeapEle curr = ele[i];
			if (parentEle.priority > curr.priority) {
				HeapEle temp = new HeapEle(parentEle.e, parentEle.priority);
				parentEle.e = curr.e;
				parentEle.priority = curr.priority;
				curr.e = temp.e;
				curr.priority = temp.priority;
				map.put(curr, i);
				map.put(parentEle, parentI);
			} else {
				return;
			}
			i = parentI;
			parentI = (i) / 2;
		}
	}

	public class HeapEle {
		Integer e, priority;

		HeapEle(Integer e, Integer priority) {
			this.e = e;
			this.priority = priority;
		}

		@Override
		public int hashCode() {
			int hash = 7;
			hash = 31 * hash + (int) e;
			hash = 31 * hash + (priority == null ? 0 : priority.hashCode());
			return hash;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			if (obj instanceof HeapEle) {
				HeapEle heap = (HeapEle) obj;
				if (heap.e.equals(this.e) && heap.priority.equals(this.priority)) {
					return true;
				}
				return false;
			} else {
				return false;
			}
		}
	}
}