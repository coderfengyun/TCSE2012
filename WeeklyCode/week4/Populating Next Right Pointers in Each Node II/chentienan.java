/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
	    levelOrderTraverse(root);
	}

    private void levelOrderTraverse(TreeLinkNode root){
        int height = getBTreeHeight(root);
        for(int i = 1; i <= height; i++){
            levelTraverse(root, i);
        }
    }
    
    private void levelTraverse(TreeLinkNode node, int level){
        if(node == null){
            return;
        }
        if(level == 1){
            connectChildren(node);
	    	connectToBrother(node);
        }else{
            levelTraverse(node.left, level - 1);
            levelTraverse(node.right, level - 1);
        }
    }

    private void connectChildren(TreeLinkNode node) {
		if (node.left == null || node.right == null) {
			return;
		}
		node.left.next = node.right;
	}

	private void connectToBrother(TreeLinkNode node) {
	    if (node.next == null) {
			return;
		}
		if (node.right == null && node.left == null) {
			return;
		} else if (node.right != null) {
			node.right.next = getNearestBrotherChild(node.next);
		} else {
			node.left.next = getNearestBrotherChild(node.next);
		}

	}

	private TreeLinkNode getNearestBrotherChild(TreeLinkNode firstBrother) {
		for (; firstBrother != null; firstBrother = firstBrother.next) {
			if (firstBrother.left == null && firstBrother.right == null) {
				continue;
			} else {
				return firstBrother.left != null ? firstBrother.left
						: firstBrother.right;
			}
		}
		return null;
	}

    private int getBTreeHeight(TreeLinkNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftChildHeight = getBTreeHeight(root.left);
        int rightChildHeight = getBTreeHeight(root.right);
        return (leftChildHeight > rightChildHeight ? leftChildHeight : rightChildHeight) + 1;
    }
	
}