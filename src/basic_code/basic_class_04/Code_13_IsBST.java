package basic_code.basic_class_04;

import java.util.Stack;

//判断一棵树是否是搜索二叉树，即二叉树中序遍历是递增的
public class Code_13_IsBST {

    private static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBST(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            int preNum = Integer.MIN_VALUE;
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    if (head.value < preNum){
                        return false;
                    }
                    head = head.right;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
