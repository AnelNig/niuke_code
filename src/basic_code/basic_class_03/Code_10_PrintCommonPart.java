package basic_code.basic_class_03;

/**
 * 给定两个有序链表的头指针，然后打印这两个链表的公共部分
 */
public class Code_10_PrintCommonPart {
	//写一个节点类
	public static class Node {
		public int value;
		public Node next;
		public Node(int data) {
			this.value = data;
		}
	}

	public static void printCommonPart(Node head1, Node head2) {
		System.out.print("Common Part: ");
		while (head1 != null && head2 != null) {
			//如果节点2的值比1大，就把1的节点往下，否则把2的节点往下，相等就打印，然后都往下
			if (head1.value < head2.value) {
				head1 = head1.next;
			} else if (head1.value > head2.value) {
				head2 = head2.next;
			} else {
				System.out.print(head1.value + " ");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		System.out.println();
	}

	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node node1 = new Node(2);
		node1.next = new Node(3);
		node1.next.next = new Node(5);
		node1.next.next.next = new Node(6);

		Node node2 = new Node(1);
		node2.next = new Node(2);
		node2.next.next = new Node(5);
		node2.next.next.next = new Node(7);
		node2.next.next.next.next = new Node(8);

		printLinkedList(node1);
		printLinkedList(node2);
		printCommonPart(node1, node2);

	}

}
