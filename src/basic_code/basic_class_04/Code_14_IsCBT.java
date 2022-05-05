package basic_code.basic_class_04;

import java.util.LinkedList;
import java.util.Queue;

//判断一棵树是否是完全二叉树
public class Code_14_IsCBT {

    private static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static boolean isCBT(Node node) {
        if (node == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            l = node.left;
            r = node.right;
            if ((l == null && r != null) || (leaf && (l != null || r != null))) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
