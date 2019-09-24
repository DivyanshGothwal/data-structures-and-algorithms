package src;

import java.util.*;
import static java.util.Objects.*;

public class DLLInsertion {

	public static void main(String[] args) {
		Dll head = null, temp = null;
		head = insetDllAfterGivenNode(head, null, 23);
		head = insertDllAtEnd(head, 10);
		head = insertDllAtFront(head, 5);
		head = insertDllAtFront(head, 41);
		head = insertDllAtEnd(head, 30);
		head = insertDllAtFront(head, 5);
		head = insetDllbeforeGivenNode(head, head.next, 20);
		temp = printDll(head, true);
		printRev(temp);
	}

	private static void printRev(Dll lastNode) {
		while (nonNull(lastNode)) {
			System.out.print(lastNode.data + " ");
			lastNode = lastNode.prev;
		}
	}

	private static Dll printDll(Dll head, boolean ...isPrint) {
		Dll temp = head;
		Dll prev = temp;
		while (nonNull(temp)) {
			if(isPrint[0]) {
				System.out.print(temp.data + " ");
			}
			prev = temp;
			temp = temp.next;

		}

		System.out.println();
		return prev;
	}

	private static Dll insetDllbeforeGivenNode(Dll head, Dll givenNode, int data) {
		Dll newNode = new Dll(data);
		if (isNull(head)) {
			return head;
		} else if (head == givenNode) {
			newNode.next = head;
			head.prev = newNode;
			return newNode;
		} else if (isNull(givenNode)) {
			return head;
		}
		if (nonNull(givenNode.prev)) {
			givenNode.prev.next = newNode;
		}
		newNode.prev = givenNode.prev;
		newNode.next = givenNode;
		givenNode.prev = newNode;
		return head;
	}

	private static Dll insetDllAfterGivenNode(Dll head, Dll givenNode, int data) {
		Dll newNode = new Dll(data);
		if (isNull(head)) {
			return newNode;
		} else if (head == givenNode) {
			newNode.next = head.next;
			if (nonNull(head.next)) {
				head.next.prev = newNode;
			}
			head.next = newNode;
			newNode.prev = head;
			return head;
		} else if (isNull(givenNode)) {
			return head;
		}
		newNode.next = givenNode.next;
		if (nonNull(givenNode.next)) {
			givenNode.next.prev = newNode;
		}
		givenNode.next = newNode;
		newNode.prev = givenNode;
		return head;
	}

	private static Dll insertDllAtEnd(Dll head, int data) {
		Dll newNode = new Dll(data);
		if (isNull(head)) {
			return newNode;
		}
		Dll lastNode = printDll(head, false);
		lastNode.next = newNode;
		newNode.prev = lastNode;
		return head;
	}

	private static Dll insertDllAtFront(Dll head, int data) {
		Dll temp = new Dll(data);
		if (isNull(head)) {
			return temp;
		}
		temp.next = head;
		head.prev = temp;
		return temp;
	}
}

class Dll {
	Integer data;
	Dll next, prev;

	public Dll(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}
