public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
		if (n == 0) {
		    ArrayList result = new ArrayList<TreeNode>();
			result.add(null);
			return result;
		}
		return generateTrees_0(1, n);
	}

	private ArrayList<TreeNode> generateTrees_0(int begin, int end) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (begin > end) {
		    result.add(null);
			return result;
		}
		
		for (int rootIndex = begin; rootIndex <= end; rootIndex++) {
			ArrayList<TreeNode> leftRoots = new ArrayList<TreeNode>();
			leftRoots.addAll(generateTrees_0(begin, rootIndex - 1));
			ArrayList<TreeNode> rightRoots = new ArrayList<TreeNode>();
			rightRoots.addAll(generateTrees_0(rootIndex + 1, end));

			for (int i = 0; i < leftRoots.size(); i++) {
				for (int j = 0; j < rightRoots.size(); j++) {
					TreeNode root = new TreeNode(rootIndex);
					root.left = copy(leftRoots.get(i));
					root.right = copy(rightRoots.get(j));
					result.add(root);
				}
			}
		}
		return result;
	}
    
    private TreeNode copy(TreeNode input){
        if(input == null){
            return null;
        }
        TreeNode result = new TreeNode(input.val);
        result.left = copy(input.left);
        result.right = copy(input.right);
        return result;
    }
}