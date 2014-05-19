public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null) {
			return null;
		}
		if (preorder.length != inorder.length) {
			return null;
		}
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1, buildValueIndexMapInOrder(inorder));
	}

	private TreeNode buildTree(int[] preorder, int preBegin, int preEnd,
			int[] inorder, int inBegin, int inEnd, Map<Integer, Integer> valueIndexMapInOrder) {
		if (preBegin > preEnd || inBegin > inEnd) {
			return null;
		}
		TreeNode result = new TreeNode(preorder[preBegin]);
		int inRoot = valueIndexMapInOrder.get(preorder[preBegin]);
		result.left = buildTree(preorder, preBegin + 1, preBegin + inRoot
				- inBegin, inorder, inBegin, inRoot - 1, valueIndexMapInOrder);
		result.right = buildTree(preorder, preBegin + inRoot - inBegin + 1,
				preEnd, inorder, inRoot + 1, inEnd, valueIndexMapInOrder);
		return result;
	}
	
	private Map<Integer, Integer> buildValueIndexMapInOrder(int[] inorder){
	    Map<Integer, Integer> result = new HashMap<Integer, Integer>(inorder.length);
	    for(int i= 0; i < inorder.length ; i++){
	        result.put(inorder[i], i);
	    }
	    return result;
	}
} 