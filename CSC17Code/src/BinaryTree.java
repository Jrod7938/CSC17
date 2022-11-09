class TreeNode {
	public int key;
	public TreeNode left, right;

	public TreeNode(int item) {
		key = item;
		left = right = null;
	}
}

public class BinaryTree {

	public static int maxDepth(TreeNode node) {
        // if node is empty return 0
		if(node == null) return 0;

        // Calculate the depth of left and right subtree
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);

        // return the larger value
        if(leftDepth > rightDepth){
            return (leftDepth + 1);
        }else{
            return (rightDepth + 1);
        }
	}

    // Recursive meathod used to check adjacent nodes
    public static boolean isMirror(TreeNode node1, TreeNode node2){
        // Base case: Tree is empty
        if(node1 == null && node2 == null) return true;

        // If node1 doesn't match node 2, return false
        else if(node1 == null || node2 == null) return false;
        else{ // Recursive: if node 1 matches node 2 return true
            return node1.key == node2.key && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
        }
    }

	public static boolean isSymmetric(TreeNode node) {
		if(node == null) return true;
		return isMirror(node.left, node.right);
	}

	public static void main(String args[]) {
		/*
		 *      4   <-- root
		 *     / \
		 *    3   1
		 *       / \
		 *      2   2
		 *     / \ / \
		 *    3  4 4  3
		 */

		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(2);
		root.right.left.left = new TreeNode(3);
		root.right.left.right = new TreeNode(4);
		root.right.right.left = new TreeNode(4);
		root.right.right.right = new TreeNode(3);

		System.out.println(isSymmetric(root));
		System.out.println(isSymmetric(root.right));

		System.out.println(maxDepth(root));
		System.out.println(maxDepth(root.right));
	}
}