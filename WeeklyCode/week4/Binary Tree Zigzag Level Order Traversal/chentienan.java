/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        TraverseOrder currentOrder = TraverseOrder.LEFT_RIGHT;
        ArrayList<Integer> currentLevelNodes = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        List<Integer> allNodeVals = buildUpLevelNodesSplitByNull(root);
        for(Integer nodeValue : allNodeVals){
            if(nodeValue == null){
                result.add(currentOrder.build(currentLevelNodes));
                currentLevelNodes = new ArrayList<Integer>();
                currentOrder = currentOrder.change();
                continue;
            }
            currentLevelNodes.add(nodeValue);
        }
        return result;
    }
    
    private List<Integer> buildUpLevelNodesSplitByNull(TreeNode root) {
		LinkedList<TreeNode> levelNodes = new LinkedList<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();
		levelNodes.add(root);
		result.add(root.val);
		// null act as the level boundry
		levelNodes.add(null);
		result.add(null);
		while (levelNodes.size() > 0) {
			TreeNode node = levelNodes.remove(0);
			if (node == null) {
				if(levelNodes.size() == 0){
					break;
				}
				levelNodes.add(null);
				result.add(null);
				continue;
			}
			if (node.left != null) {
				levelNodes.add(node.left);
				result.add(node.left.val);
			}
			if (node.right != null) {
				levelNodes.add(node.right);
				result.add(node.right.val);
			}
		}
		return result;
	}
    
    enum TraverseOrder{
        LEFT_RIGHT, RIGHT_LEFT;
        
        public TraverseOrder change(){
            if(this == LEFT_RIGHT){
                return RIGHT_LEFT;
            }else if(this == RIGHT_LEFT){
                return LEFT_RIGHT;
            }else {
                return null;
            }
        }
        
        public ArrayList<Integer> build(List<Integer> levelNodes){
            ArrayList<Integer> result = new ArrayList<Integer>();
            if(this == LEFT_RIGHT){
                result.addAll(levelNodes);
                return result;
            }
            else if(this == RIGHT_LEFT){
                for(int i = levelNodes.size() - 1; i >= 0; i --){
                    result.add(levelNodes.get(i));
                }
            }    
            return result;
        }
        
    }
    
}