import java.util.ArrayList;
import java.util.List;

public class TreeInorderAll {
    static Tree root;
    public static void main(String[] args){
//        Tree tree = new Tree(75);
//        tree.left = new Tree(45);
//        tree.right = new Tree(87);
//        tree.left.left = new Tree(40);
//        tree.left.right = new Tree(50);
//        tree.right.left = new Tree(80);
//        tree.right.right = new Tree(89);
//        inorder(tree);
        Tree tree = new Tree(3);

        tree.left = new Tree(5);
        tree.right = new Tree(1);
        tree.left.left = new Tree(6);
        tree.left.right = new Tree(2);
        tree.right.left = new Tree(0);
        tree.right.right = new Tree(8);
        tree.left.right.left = new Tree(7);
        tree.left.right.right = new Tree(4);


        Tree lca = findLCA(tree, tree.left.left,tree.left.right);
        System.out.println("LCA of the tree : " +lca.value);

        TreeInorderAll treeNode = new TreeInorderAll();
        treeNode.insert(76);
        treeNode.insert(49);
        treeNode.insert(75);
        treeNode.insert(28);
        treeNode.insert(37);
        treeNode.insert(92);
        treeNode.insert(30);
        inorder();
        int element = 21;
        if(searchElement(element)){
            System.out.println("Element found in the tree");
        }
        else{
            System.out.println("Not found");
        }
        int key = 37;
        deleteElement(root, key);
        inorder();
        int k = 2;
        System.out.println(kthMaxEle(root, k));
        System.out.println(kthMinEle(root, k));
        int ele = 28;
        List<Integer> output = findAncestors(ele);
        for(int o : output){
            System.out.println(o);
        }
        System.out.println("The height of the tree" +findHeight(root));
        int distance = 2;
        List<Integer> nodes = findNodesAtKDistance(distance);
        for(int n : nodes){
            System.out.println(n);
        }
        findInvert(root);
        inorder();

        if(findSymmetric(root, root)){
            System.out.println("Miiror tree");
        }
        else{
            System.out.println("Not Symmetric");
        }
        mergeTree(root, root);

        rootEqualsSumChildren(root);

        System.out.println("RIGHT AND LEFT SUM......");
        System.out.println(leftSum());
        System.out.println(rightSum());
        int sum = 103;
        if(hasPathSum(root, sum)){
            System.out.println("Has Path Sum");
        }
        else{
            System.out.println("No path sum");
        }

    }

    private static boolean hasPathSum(Tree root, int sum) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return sum == root.value;
        }
        int remainingSum = sum - root.value;
        return hasPathSum(root.left ,remainingSum) || hasPathSum(root.right, remainingSum);
    }

    private static int rightSum() {
        return rightSumRec(root, false);
    }

    private static int rightSumRec(Tree root, boolean b) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        if(b){
            sum += root.value;
        }
        sum += rightSumRec(root.right, true);
        sum += rightSumRec(root.left, false);
        return sum;
    }

    private static int leftSum() {
        return leftSumRec(root, false);
    }

    private static int leftSumRec(Tree root, boolean isLeft) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        if(isLeft){
            sum += root.value;
        }
        sum += leftSumRec(root.left, true);
        sum += leftSumRec(root.right, false);
        return sum;
    }

    private static boolean rootEqualsSumChildren(Tree root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        int leftSum = root.left.value;
        int rightSum = root.right.value;
        if(root.value != leftSum + rightSum){
            return false;
        }
        return rootEqualsSumChildren(root.left) && rootEqualsSumChildren(root.right);
    }

    private static Tree mergeTree(Tree root1, Tree root2) {
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        if(root1 == null && root2 == null){
            return null;
        }
        Tree mergerdRoot = new Tree(root1.value + root2.value);
        mergerdRoot.left = mergeTree(root1.left, root2.left);
        mergerdRoot.right = mergeTree(root1.right, root2.right);
        return mergerdRoot;
    }

    private static boolean findSymmetric(Tree root1, Tree root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return root1.value == root2.value && findSymmetric(root1.left, root2.right) && findSymmetric(root1.right, root2.left);
    }

    private static Tree findInvert(Tree root) {
        if(root == null){
            return null;
        }

            Tree temp = root.left;
            root.left = root.right;
            root.right = temp;
            findInvert(root.left);
            findInvert(root.right);

        return root;
    }

    private static List<Integer> findNodesAtKDistance(int distance) {
        List<Integer> result = new ArrayList<>();
        findNodesKdistanceRecursive(root, distance, result);
        return result;
    }

    private static void findNodesKdistanceRecursive(Tree root, int distance, List<Integer> result) {
        if(root == null) return ;
        if(distance  == 0){
            result.add(root.value);
            return;
        }
        findNodesKdistanceRecursive(root.left, distance - 1, result);
        findNodesKdistanceRecursive(root.right, distance - 1, result);
    }

    private static int findHeight(Tree root) {
        if(root == null){
            return -1;
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }

    private static Tree findLCA(Tree root, Tree left, Tree right) {
        if(root == null){
            return null;
        }
        if(left == null || right == null){
            return root;
        }
        Tree leftLCA = findLCA(root.left, left, right);
        Tree rightLCA = findLCA(root.right, left, right);
        if(leftLCA != null || rightLCA == null){
            return root;
        }
        return leftLCA != null ? leftLCA : rightLCA;

    }

    private static List<Integer> findAncestors(int ele) {
        List<Integer> ancestors = new ArrayList<>();
        findAncestorsRec(root, ele, ancestors);
        return ancestors;
    }

    private static boolean findAncestorsRec(Tree root, int ele, List<Integer> ancestors) {
        if(root == null) return false;
        if(root.value == ele)
            return true;
        if(findAncestorsRec(root.left, ele, ancestors) || findAncestorsRec(root.right, ele, ancestors)){
            ancestors.add(root.value);
            return true;
        }
    return false;
    }

    private static Integer kthMinEle(Tree root, int k) {
        Integer[] kthMin = {null};
        int[] count = {0};
        kthMinEleRecursion(root, k, count, kthMin);
        return kthMin[0];
    }

    private static void kthMinEleRecursion(Tree root, int k, int[] count, Integer[] kthMin) {
        if(root == null || kthMin[0] != null){
            return;
        }
        kthMinEleRecursion(root.left, k, count, kthMin);
        count[0] ++;
        if(count[0] == k){
            kthMin[0] = root.value;
        }
        kthMinEleRecursion(root.right, k, count, kthMin);
    }

    private static Integer kthMaxEle(Tree root, int k) {
        int[] count = {0};
        Integer[] kthMax = {null};
        kthMaxRecursion(root, k, count, kthMax);
        return kthMax[0];
    }

    private static void kthMaxRecursion(Tree root, int k, int[] count, Integer[] kthMax) {
        if(root == null || kthMax[0] != null)
            return;
        kthMaxRecursion(root.right, k, count, kthMax );
        count[0]++;

        if(count[0] == k){
            kthMax[0] = root.value;
        }
        kthMaxRecursion(root.left, k, count, kthMax);
    }

    private static Tree deleteElement(Tree root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.value){
            root.left = deleteElement(root.left, key);
        }
        else if(key > root.value){
            root.right = deleteElement(root.right, key);
        }
        else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.value = findminValue(root.right);
            root.right = deleteElement(root.right, root.value);
        }
        return root;

    }

    private static int findminValue(Tree right) {
        int minValue = root.value;
        while(root.left != null){
            root = root.left;
            minValue = root.value;
        }
        return minValue;
    }

    private static boolean searchElement(int element) {
        return searcheleRec(root, element);

    }

    private static boolean searcheleRec(Tree root, int element) {
        if (root == null) return false;
        if (root.value == element)
            return true;
        if (element > root.value) {
            return searcheleRec(root.right, element);
            }
            return searcheleRec(root.left, element);
    }

    private void insert(int key) {
        root = insertionData(root, key);
    }

    private Tree insertionData(Tree root, int key) {
        if(root == null){
            root = new Tree(key);
            return root;
        }
        if(key < root.value){
            root.left = insertionData(root.left, key);
        }
        else if(key > root.value){
            root.right = insertionData(root.right , key);
        }
        return root;
    }

    private static void insertion() {
    }
    private static void inorder(){
        inorderRec(root);
    }

    private static void inorderRec(Tree root) {
        if(root == null) return;
        if(root != null){
            inorderRec(root.left);
            System.out.println(root.value+ " ");
            inorderRec(root.right);

        }
    }
}
class Tree{
    int value;
    Tree right, left;
    Tree(int value){
        this.value = value;
        this.right = null;
        this.left = null;
    }
}
