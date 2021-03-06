package basic_code.basic_class_04;

import java.util.LinkedList;
import java.util.Queue;

public class Code_11_SerializeAndReconstructTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }
    //按先序遍历序列化
    public static String serialByPre(Node head){
        if (head == null){
            return "#!";
        }
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }
    public static Node reconByPreString(String preString){
        String[] values = preString.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }
    public static Node reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
    //按层序列化
    public static String serialByLevel(Node head){
        if (head == null){
            return "#!";
        }
        String res = head.value + "!";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            if (head.left != null){
                res += head.left.value + "!";
                queue.offer(head.left);
            }else{
                res += "#!";
            }
            if (head.right != null){
                res += head.right.value + "!";
                queue.offer(head.right);
            }else{
                res += "#!";
            }
        }
        return res;
    }

    public static Node reconByLevelString(String levelStr){
        String[] values = levelStr.split("!");
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<>();
        if (head != null){
            queue.offer(head);
        }
        Node node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return head;
    }

    public static Node generateNodeByString(String val){
        if (val.equals("#")){
            return null;
        }
        return new Node(Integer.valueOf(val));
    }

    //for test--- print tree
    public static void printTree(Node head){
        System.out.println("binary tree:");
        printInOrder(head , 0 , "H" , 17);
        System.out.println();
    }

    public static void printInOrder(Node head , int height , String to , int len){
        if (head == null){
            return;
        }
        printInOrder(head.right , height+1 , "v" , len);
        String val = to +head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val +getSpace(lenR);
        System.out.println(getSpace(height*len)+val);
        printInOrder(head.left , height+1 , "^" , len);
    }

    public static String getSpace(int num){
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = null;
        printTree(head);

        String pre = serialByPre(head);
        System.out.println("serialize tree by pre-order" + pre);
        head = reconByPreString(pre);
        System.out.println("reconstruct tree by pre-order");
        printTree(head);

        String level = serialByLevel(head);
        System.out.println("缺部分代码");
    }
}
