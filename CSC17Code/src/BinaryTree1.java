import java.util.*;

class TreeNode {
	public int key;
	public TreeNode left, right;

	public TreeNode(int item) {
		key = item;
		left = right = null;
	}
}

public class BinaryTree1 {

	public static List<String> binaryTreePaths(TreeNode node) {
        List<String> answer = new LinkedList<>();
        if(node==null){ return answer; }
        depthForSearch(node, "", answer);

        return answer;
	}

    private static void depthForSearch(TreeNode node, String path, List<String> answer) {
        path += node.key;
        if(isLeaf(node)){
            answer.add(path);
        }
        if(node.left!=null){
            depthForSearch(node.left, path + "->", answer);
        }
        if(node.right!=null){
            depthForSearch(node.right, path + "->", answer);
        }
    }

    private static boolean isLeaf(TreeNode node) {
        return (node.left==null && node.right==null);
    }

    public static List<Double> averageOfLevels(TreeNode node) {
        double total = 0.0;
        double count = 0.0;
		Queue<TreeNode> queue = new LinkedList<>();
        List<Double> answer = new LinkedList<>();
        queue.add(node);
        // While root is not null
        while(!queue.isEmpty()){
            total = 0;
            count = 0.0;

            Queue<TreeNode> temp = new LinkedList<>();
            // Add value to total, add left and right child to queue
            while(!queue.isEmpty()){
                TreeNode n = queue.peek();
                queue.remove();
                total += n.key;
                count++;
                if(n.left != null){ temp.add(n.left); }
                if(n.right != null){ temp.add(n.right); }
            }
            queue = temp;
            // add answer two our linked list
            answer.add((total/count));
        }
        return answer;
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

		System.out.println(binaryTreePaths(root));
		System.out.println(averageOfLevels(root));

	}
}