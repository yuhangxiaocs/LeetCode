/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class RangeSumofBST {

    /**
     * v1：就是遍历一下tree，比较慢，因为没有使用二叉搜索树的性质
     * 
     * 
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)
            return 0;
        if (root.val >= L && root.val <= R)
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        else
            return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    /**
     * 这种就是利用了二叉搜索书的一些性质 进行一些剪枝
     * 100% 5.23%
     */

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)
            return 0;
        if (root.val < L)
            return rangeSumBST(root.right, L, R);
        else if (root.val > R)
            return rangeSumBST(root.left, L, R);
        else
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);

    }

}