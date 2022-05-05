package basic_code.basic_class_04;
//补充：二叉树的序列化和反序列化在剑指offer中有
//判断是否是平衡二叉树，是否是完全二叉树，是否是搜索二叉树，已知完全二叉树求其节点个数这几道的代码没有
/**
 * 二叉树的节点有指向父节点的指针，打印二叉树中一个节点的后继节点，中序遍历时当前节点的下一个节点为后继节点
 * 前驱节点类似
 *
 */
public class Code_07_DescendantNode {

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node getNextNode(Node node) {
		if (node == null) {
			return node;
		}
		//如果有右节点，则这个节点的后继节点是右子树中最左面那个节点
		if (node.right != null) {
			return getLeftMost(node.right);
		//如果没有右节点，后继节点就是这个节点往上找其父节点中，节点的左节点不是这个节点的那个节点
		} else {
			Node parent = node.parent;
			while (parent != null && parent.left != node) {
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}

	public static Node getLeftMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public static void main(String[] args) {
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;

		Node test = head.left.left;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.left.left.right;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.left;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.left.right;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.left.right.right;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.right.left.left;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.right.left;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.right;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.right.right; // 10's next is null
		System.out.println(test.value + " next: " + getNextNode(test));
	}

}
