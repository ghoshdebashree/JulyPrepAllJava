public class HouseRobberIIITreeDP {
    public static void main(String[] args){
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(1);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(9);
        System.out.println(rob(tree));


    }

    private static int rob(TreeNode tree) {
        int[] result = rootCalculate(tree);
        return Math.max(result[0], result[1]);
    }

    private static int[] rootCalculate(TreeNode tree) {
        if(tree == null ){
            return new int[2];
        }
        int[] left = rootCalculate(tree.left);
        int[] right = rootCalculate(tree.right);
        int rootTaken = tree.data + left[0] + right[0];
        int rootSkipped = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{rootTaken, rootSkipped};

    }
}

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
    }
}
