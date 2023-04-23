import java.util.*;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
//        System.out.println(new Test().removeDuplicates(new int[]{1,2,2,3}));
//        System.out.println(new Test().buildTree(new int[]{1,2}, new int[]{2,1}));
//        Collections.sw
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
//        new Test().generateAll(3, result, sb, 0, 0);
        new Test().generateAll(new char[2*3], 0, result);
        for (String item:
        result) {
            int c1 = 0;
            int c2 = 0;
            for (char c: item.toCharArray()
                 ) {
                if(c == '(') c1 ++;
                if(c == ')') c2 ++;
            }
            System.out.println("c1="+c1+",c2="+c2);
        }
        System.out.println("length="+result.size()+", "+Arrays.toString(result.toArray()));
    }

    public void generateAll(int n, List<String> result, StringBuilder cur, int left, int right){
//        System.out.printf("n=%d,cur=%s,left=%d,right=%d%n", n,cur,left,right);
        if(right > left){
            return;
        }
        if(left > n -1 && right > n -1){
            result.add(cur.toString());
            return;
        }

        if(left < n){
            generateAll(n, result, new StringBuilder(cur).append("("), left + 1, right);
        }
        if(right < n) {
            generateAll(n, result, new StringBuilder(cur).append(")"), left, right + 1);
        }
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            result.add(new String(current));
            return;
        }

            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
    }




    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode treeNode = buildTree0(preorder, inorder, 0, preorder.length - 1,  0, inorder.length - 1);
        System.out.println(treeNode);
        return treeNode;
    }
    /**
     pre [root,left, right]
     in [left,root, right]
     */
    public TreeNode buildTree0(int [] preorder, int[] inorder,  int preLeft, int preRight, int inLeft, int inRight){
        System.out.println("preLeft="+preLeft+",preRight="+preRight+",inLeft="+inLeft+",inRight="+inRight);
        if(preLeft == preRight){
            return new TreeNode(preorder[preLeft]);
        }
        if(preLeft > preRight){
            return null;
        }
        int preRoot = preorder[preLeft];
        int inRootIndex = searchRootIndex(inorder, inLeft, inRight, preRoot);
        int leftLength = inRootIndex - inLeft;
        int rightLength = inRight - inRootIndex;
        System.out.println("inRootIndex="+inRootIndex+",leftLength="+leftLength+",rightLength="+rightLength);
        TreeNode root = new TreeNode(inorder[inRootIndex]);
         root.left = buildTree0(preorder, inorder, preLeft + 1, preLeft + leftLength, inLeft, inLeft + leftLength -1);
        root.right = buildTree0(preorder, inorder, preLeft + leftLength + 1, preRight, inLeft + leftLength + 1, inRight);
        return root;
    }

    public int searchRootIndex(int[] inorder, int inLeft, int inRight, int preRoot){
        for(int i = inLeft; i < inRight + 1 ;i ++){
            if(preRoot == inorder[i]){
                return i;
            }
        }
        return -1;
    }
    static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }



}
