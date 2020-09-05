


import java.util.ArrayList;

public class DataTree {


    public static TreeNode getTreeNode() {

        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);


        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;

        return a1;
    }

    public static TreeNode getTreeNode(int flag) {

        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);


        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = null;
        a3.left = a5;
        a5.left = a6;
        a5.right = a7;

        return a1;
    }

    public static Node getNode(){
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node a3 = new Node(3);
        Node a4 = new Node(4);
        Node a5 = new Node(5);
        Node a6 = new Node(6);

        //a1.children = new ArrayList<>();

        a1.children.add(a2);
        a1.children.add(a3);
        a1.children.add(a4);

        //a3.children = new ArrayList<>();
        a3.children.add(a5);
        a3.children.add(a6);

        return a1;

    }

    public static ListNode getListNode(){
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        return a1;
    }

}
===


public class ListNode {
    public int val;
    public ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

    public static void traverse(ListNode listNode) {
        while (listNode != null){
//            Thread.sleep(1000);
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
===



import java.util.ArrayList;
import java.util.List;


public class Node {
    public int val;
    public List<Node> children =  new ArrayList<>();// 初始化为空数组

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
===


public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
===
