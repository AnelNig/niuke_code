package basic_code.basic_class_04;

//判断一个树是否是平衡二叉树，平衡二叉树的任意一个节点左子树和右子树的高度差不大于1
public class Code_12_IsBT {

    private static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnData {
        public boolean isB;
        public int h;

        public ReturnData(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }
    }


    public static boolean isBalance(Node node){
        return process(node).isB;
    }

    public static ReturnData process(Node node) {
        if (node == null) {
            return new ReturnData(true, 0);
        }
        ReturnData leftData = process(node.left);
        ReturnData rightData = process(node.right);
        if (leftData.isB == false || rightData.isB == false) {
            return new ReturnData(false, 0);
        } else {
            int i = Math.abs(leftData.h - rightData.h);
            if (i > 1) {
                return new ReturnData(false, 0);
            } else {
                return new ReturnData(true, Math.max(leftData.h, rightData.h) + 1);
            }
        }
    }



    public static void main(String[] args) {

    }



}


