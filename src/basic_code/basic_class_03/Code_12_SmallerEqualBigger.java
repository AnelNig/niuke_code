package basic_code.basic_class_03;

/**
 * 类似荷兰国旗，将链表左边为小于num的数，中间等于，右边小于
 */
public class Code_12_SmallerEqualBigger {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	//方法1是将这个链表元素拷贝进数组，按荷兰国旗问题排好序后再排成链表
	public static Node listPartition1(Node head, int pivot) {
		if (head == null) {
			return head;
		}
		Node cur = head;
		int i = 0;
		//下面的循环计算数组的长度
		while (cur != null) {
			i++;
			cur = cur.next;
		}
		Node[] nodeArr = new Node[i];
		i = 0;
		cur = head;
		for (i = 0; i != nodeArr.length; i++) {
			nodeArr[i] = cur;
			cur = cur.next;
		}
		arrPartition(nodeArr, pivot);
		for (i = 1; i != nodeArr.length; i++) {
			nodeArr[i - 1].next = nodeArr[i];
		}
		nodeArr[i - 1].next = null;
		return nodeArr[0];
	}

	public static void arrPartition(Node[] nodeArr, int pivot) {
		int small = -1;
		int big = nodeArr.length;
		int index = 0;
		while (index != big) {
			if (nodeArr[index].value < pivot) {
				swap(nodeArr, ++small, index++);
			} else if (nodeArr[index].value == pivot) {
				index++;
			} else {
				swap(nodeArr, --big, index);
			}
		}
	}

	public static void swap(Node[] nodeArr, int a, int b) {
		Node tmp = nodeArr[a];
		nodeArr[a] = nodeArr[b];
		nodeArr[b] = tmp;
	}
   // 方法2是将链表从头向后遍历，小于就放到小于链表里，大于放到大于的链表里，等于就放到等于的链表里
   // 最后将三个链表接起来，这种方式具有稳定性
	public static Node listPartition2(Node head, int pivot) {
		Node sH = null; // small head
		Node sT = null; // small tail
		Node eH = null; // equal head
		Node eT = null; // equal tail
		Node bH = null; // big head
		Node bT = null; // big tail
		Node next = null; // save next node
		//every node distributed to three lists
		//1.Node next = null;2.next = head.next;3.head.next = null;4.head = next;
		//这几步必须要,不能被省略,每次要处理head节点时,要将head.next置空,如不将head.next置空,会造成链表链接的死循环
		//排好遍历的时候，大于链表的最后一个head.next是原来链表的下一个，就循环了
		while (head != null) {
			next = head.next;
			head.next = null;
			if (head.value < pivot) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.value == pivot) {
				if (eH == null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = head;
				}
			} else {
				if (bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = head;
				}
			}
			head = next;
		}
		// small and equal reconnect
		if (sT != null) {//如果链表的头或者尾任意一个有值,那另一个也肯定有值
			sT.next = eH;
			eT = eT == null ? sT : eT;
		}
		// all reconnect
		if (eT != null) {
			eT.next = bH;
		}
		return sH != null ? sH : eH != null ? eH : bH;
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
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);
		printLinkedList(head1);
		// head1 = listPartition1(head1, 4);
		head1 = listPartition2(head1, 5);
		printLinkedList(head1);

	}

}
