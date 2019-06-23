package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * ·Ö²ã±éÀú¶þ²æÊ÷
 * @author hzf
 * @see https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
        	queue.add(root);
        }
        TreeNode head = root;
        
        while(!queue.isEmpty()){
        	TreeNode current = queue.poll();
        	TreeNode left = current.left;
        	if(left != null){
        		queue.add(left);
        	}
        	TreeNode right = current.right;
        	if(right != null){
        		queue.add(right);
        	}
        	if(head == current){
        		//build a new list
        		List<Integer> list = new LinkedList<>();
        		list.add(current.val);
        		res.add(list);
        		//change the head
        		head = left != null ? left : (right != null ? right : null);
        	}else{
        		//add to the first list
        		List<Integer> list = res.get(res.size() - 1);
        		list.add(current.val);
        		//change the head
        		if(head == null){
        			head = left != null ? left : (right != null ? right : null);
        		}
        	}
        }
        return res;
    }
    
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
