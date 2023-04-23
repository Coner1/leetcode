public class  TreeTest {
    /**
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。ps:树中节点数目范围在 [0, 100] 内
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode layer1R = new TreeNode(3);
        layer1R.right = new TreeNode(4);
        root.right = layer1R;


        TreeNode flipped = new TreeTest().flipTree(root);
        System.out.println(flipped);
//        System.out.println(flipped);
//        System.out.println(flipped);

    }
    public TreeNode flipTree(TreeNode treeNode){
        if(treeNode == null){
            return null;
        }
        TreeNode temp = treeNode.right;

        treeNode.right = flipTree(treeNode.left);
        treeNode.left = flipTree(temp);
        return treeNode;
    }

}
