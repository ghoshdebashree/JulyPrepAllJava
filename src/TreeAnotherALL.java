public class TreeAnotherALL {
    static TreeNodeList root;

    public static void main(String[] args) {
        TreeAnotherALL tree = new TreeAnotherALL();
        tree.root = new TreeNodeList(56);
        tree.root.left = new TreeNodeList(52);
        tree.root.right = new TreeNodeList(58);
        tree.root.left.left = new TreeNodeList(43);
        tree.root.left.right = new TreeNodeList(60);
        tree.root.right.left = new TreeNodeList(23);
        tree.root.right.right = new TreeNodeList(71);
        treeToLinkedList(root);
        treePrintList(root);
    }

    private static void treePrintList(TreeNodeList root) {

        while(root != null){
            System.out.print(root.data+ " ");
            root = root.right;
        }
    }

    private static void  treeToLinkedList(TreeNodeList root) {

        if (root == null) {
            return;
        }
        treeToLinkedList(root.left);
        treeToLinkedList(root.right);
        TreeNodeList tempNode = root.right;
        root.right = root.left;
        root.left = null;
        TreeNodeList currentNode = root;

        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        currentNode.right = tempNode;
    }

}
class TreeNodeList{
    int data;
    TreeNodeList left, right;
    TreeNodeList(int data){
        this.data = data;
        this.left = this.right = null;
    }

}
