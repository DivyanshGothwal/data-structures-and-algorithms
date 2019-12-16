package src;

import java.util.*;

public class CircularTourOfPetrolPump {

	public static int findFirstpetrolPump(List<petrolPump> arr) {
		Queue<Integer> queue = new LinkedList<>();
		int totalPetrolSum = 0;
		int j = 0, n = arr.size();
		int i = j, lastEleIndex = 0;
		int start = 0;
		do {
			petrolPump petrolPump = arr.get(i);
			totalPetrolSum += (petrolPump.petrol - petrolPump.distanceToNextELe);
			if (totalPetrolSum >= 0) {
				queue.add(i);
			} else {
				if (i < j) {
					return -1;
				}
				totalPetrolSum = 0;
				while (queue.size() != 0) {
					queue.poll();
				}
				queue.add(i);
				j = i;
				start = i + 1;
			}
			i = (i + 1) % n;

		} while (i != j);
		lastEleIndex = i;
		totalPetrolSum += arr.get(lastEleIndex).petrol - arr.get(lastEleIndex).distanceToNextELe;
		if (queue.size() == n && totalPetrolSum >= 0) {
			return (start) % n;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		List<petrolPump> arr = Arrays.asList(new petrolPump(50, 25), 
				new petrolPump(57, 83), new petrolPump(30, 15),
				new petrolPump(65, 35), new petrolPump(16, 44),
				 new petrolPump(1, 88),
				new petrolPump(79, 77), 
				new petrolPump(65, 23));

		System.out.println(findFirstpetrolPump(arr));
	}
}

class petrolPump {
	Integer petrol;
	Integer distanceToNextELe;

	petrolPump(Integer petrol, Integer distanceToNextELe) {
		this.petrol = petrol;
		this.distanceToNextELe = distanceToNextELe;
	}
}