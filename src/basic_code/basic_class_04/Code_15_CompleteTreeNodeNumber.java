package basic_code.basic_class_04;

//求完全二叉树的节点个数，要求时间复杂度低于O(n),n为节点个数，这里就是要求不能遍历得到
public class Code_15_CompleteTreeNodeNumber {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }

    //这是主函数，完全二叉树的头结点传进去
    public static int nodeNum(Node head){
        if (head == null){
            return 0;
        }
        return bs(head , 1 , mostLeftLevel(head , 1));
    }

    //node是当前节点，level是当前节点在第几层，头结点就是第一层，h是整个树有几层
    public static int bs(Node node , int level , int h){
        //如果当前节点就是数最大的那层就是叶节点，返回一个节点个数
        if (level == h){
            return 1;
        }
        //如果node节点的右子树能够到最大深度，说明node节点左子树是满的，返回左子树加当前节点的总数加右子树的节点个数
        if (mostLeftLevel(node.right , level+1) == h){
            return (1 << (h - level)) + bs(node.right , level + 1 , h);
            //否则说明node节点的右子树是满的，返回右子树加当前节点的总数加左子树的节点个数
        }else{
            return (level << (h - level - 1)) + bs(node.left , level + 1, h);
        }
    }


    public static int mostLeftLevel(Node node , int level){
        while (node != null){
            level++;
            node = node.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {

        System.out.println("缺一个完全二叉树调用");
    }

}
