package org.bench4q.agent.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Solution {
	private Map<Integer, Integer> valueIndexMap = new HashMap<Integer, Integer>();
	private Map<Integer, TreeNode> preIndexNodes = new HashMap<Integer, TreeNode>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null) {
			return null;
		}
		if (preorder.length != inorder.length) {
			return null;
		}
		buildValueIndexMap(inorder);
		buildIndexNodeMap(preorder);
		int begin = 0, end = preorder.length - 1;
		return buildTree(0, preorder, inorder, begin, end);
	}

	private TreeNode buildTree(int currentPreIndex, int[] preorder,
			int[] inorder, int begin, int end) {
		int currentValue = preorder[currentPreIndex];
		int rootIndexInOrder = getIndex(currentValue);
		int rightChildIndex = -1;
		TreeNode currentNode = this.preIndexNodes.get(currentPreIndex);
		// For left
		if (begin < 0 || end > preorder.length - 1) {
			return null;
		}
		if (rootIndexInOrder > begin) {
			currentNode.left = this.preIndexNodes.get(currentPreIndex + 1);
			buildTree(currentPreIndex + 1, preorder, inorder, begin,
					currentPreIndex - 1);
		}
		if (rootIndexInOrder < end) {
			rightChildIndex = findRightChild(currentPreIndex, preorder, end,
					rootIndexInOrder);
			currentNode.right = this.preIndexNodes.get(rightChildIndex);
			buildTree(rightChildIndex, preorder, inorder, currentPreIndex + 1,
					end);
		}
		return currentNode;
	}

	private int findRightChild(int currentPreIndex, int[] preorder, int end,
			int rootIndexInOrder) {
		for (int i = currentPreIndex; i < end; i++) {
			int value = preorder[i];
			if (this.valueIndexMap.get(value) > rootIndexInOrder) {
				return i;
			}
		}
		return -1;
	}

	private int getIndex(int withValue) {
		return this.valueIndexMap.get(withValue);
	}

	private void buildValueIndexMap(int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			this.valueIndexMap.put(inorder[i], i);
		}
	}

	private void buildIndexNodeMap(int[] preorder) {
		for (int i = 0; i < preorder.length; i++) {
			this.preIndexNodes.put(i, new TreeNode(preorder[i]));
		}
	}

	@Test
	public void test_1() {
		TreeNode treeNode = this.buildTree(new int[] { 1 }, new int[] { 1 });
		assertNull(treeNode.left);
		assertNull(treeNode.right);
		assertEquals(1, treeNode.val);
	}

	@Test
	public void test_2() {
		TreeNode treeNode = this.buildTree(new int[] { 1, 2, 4, 5, 3, 6, 7 },
				new int[] { 4, 2, 5, 1, 6, 3, 7 });
		assertNotNull(treeNode);
		assertEquals(1, treeNode.val);
		assertEquals(2, treeNode.left.val);
		assertEquals(3, treeNode.right.val);
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
