package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. Validate Binary Search Tree
 * �ж�һ�����Ƿ��Ƕ���������
 * @author hzf
 * @see https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
	
	public boolean isValidBST(TreeNode root) {
		if(root == null){
			return true;
		}
		List<Integer> trace = new ArrayList<Integer>();
		inOrder(root, trace);
		
		//��֤�Ƿ�˳��
		for(int i = 0; i < trace.size() - 1; i++){
			if(trace.get(i) >= trace.get(i+1)){
				return false;
			}
		}
		return true;
	}
	
	private void inOrder(TreeNode root, List<Integer> trace) {
		if(root.left != null){
			inOrder(root.left, trace);
		}
		trace.add(root.val);
		if(root.right != null){
			inOrder(root.right, trace);
		}
	}

	//TODO:��������
	public boolean isValidBSTWrong(TreeNode root) {
		if(root == null){
			return true;
		}else{
			boolean result = true;
			if(root.left != null){
				result = result && (root.val > root.left.val);
			}
			if(root.right != null){
				result = result && (root.val < root.right.val);
			}
			return result && isValidBSTWrong(root.left) && isValidBSTWrong(root.right);
		}
    }
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
