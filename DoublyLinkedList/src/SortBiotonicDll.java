package src;

import static java.util.Objects.*;
public class SortBiotonicDll {

	public static void main(String[] args) {
		Dll head = new Dll(2);
		head.prev = null;
		head.next = new Dll(53);
		head.next.prev = head;
		head.next.next = new Dll(27);
		head.next.next.prev = head.next;
		head.next.next.next = new Dll(12);
		head.next.next.next.prev = head.next.next;
		head.next.next.next.next = new Dll(10);
		head.next.next.next.next.prev = head.next.next.next;
		head.next.next.next.next.next = new Dll(6);
		head.next.next.next.next.next.prev = head.next.next.next.next;
		head.next.next.next.next.next.next = new Dll(4);
		head.next.next.next.next.next.next.prev = head.next.next.next.next.next;
		head.next.next.next.next.next.next.next = new Dll(1);
		head.next.next.next.next.next.next.next.prev = head.next.next.next.next.next.next;
		head.next.next.next.next.next.next.next.next = new Dll(0);
		head.next.next.next.next.next.next.next.next.prev = head.next.next.next.next.next.next.next;
		Dll inflectionNode = findInfletionNode(head);
		head = sortDll(head, inflectionNode, head.next.next.next.next.next.next.next.next);
		printDll(head);
	}
	private static void printDll(Dll head) {
		Dll temp = head;
		while(nonNull(temp)) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}

	private static Dll sortDll(Dll head, Dll inflectionNode, Dll prev) {
		if(isNull(inflectionNode)) {
			return head;
		}
		Dll temp1 = head;
		Dll temp2 = prev;
		while(temp1!=inflectionNode && temp2!=inflectionNode.prev && temp2!=temp1) {
			if(temp1.data>temp2.data) {
				if(temp1 == head) {
					head = temp2;
				}
				Dll temp2Prev = temp2.prev;
				temp2.prev = temp1.prev;
				temp2.next = temp1;
				if(nonNull(temp1.prev)) {
					temp1.prev.next = temp2;
				}
				temp1.prev = temp2;
				temp2 = temp2Prev;
				temp2.next = null;
			}
			else {
				temp1 = temp1.next;
			}
		}
		while(temp2!=inflectionNode) {
			Dll temp2Prev = temp2.prev;
			temp2.prev = temp1.prev;
			temp2.next = temp1;
			if(nonNull(temp1.prev)) {
				temp1.prev.next = temp2;
			}
			temp1.prev = temp2;
			temp2 = temp2Prev;
			temp2.next = null;
		}	
		return head;
	}

	private static Dll findInfletionNode(Dll head) {
		Dll temp = head;
		Dll inflectionNode = null;
		while(nonNull(temp)) {
			if(nonNull(temp.prev) && nonNull(temp.next)) {
				if(temp.prev.data <= temp.data && temp.data > temp.next.data){
					return temp;
				}
			}
			temp = temp.next;
		}
		return inflectionNode;
	}

}
