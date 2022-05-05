package basic_code.basic_class_03;

import com.sun.xml.internal.ws.api.pipe.NextAction;

/**
 * 翻转单向和双向链表
 */
public class Code_15_ReverseList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    //迭代版
    public static Node reverseList(Node head) {
        //pre指向转换后当前节点要指向的节点，比如，当前要变化1节点，那pre就是0节点
        Node pre = null;
        //next记录下次要变化next属性的节点，如，当前要变化1节点，那next是2节点
        Node next = null;
        while (head != null) {
            //下次要翻转head.next位置的节点，供这次循环最后一步使用
            next = head.next;
            //当前节点的下个节点指向pre节点，即翻转了
            head.next = pre;
            //pre节点变成当前节点，下次循环指向这个节点
            pre = head;
            //当前节点变成要翻转的下一个节点，供下次循环使用
            head = next;
        }
        return pre;
    }

    //递归版
    public static Node reverseList1(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node next = head.next;
		Node node = reverseList1(next);
        next.next = head;
        head.next = null;
        return node;
    }

    //1->2->6->9->11 next=2,head.next=null,pre=1,head=2,next=6,head.next=1,pre=2,head=6
    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    public static DoubleNode reverseList(DoubleNode head) {
        //这里的pre和next的作用和单向链表类似
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            //主要就是下面的两步，将当前节点下一个节点变成上一个节点，上一个节点变成下一个节点
            head.next = pre;
            //相对单向链表只多了下面这一步
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkedList(head1);
        head1 = reverseList(head1);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(reverseList(head2));

    }

}
