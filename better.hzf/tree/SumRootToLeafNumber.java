package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 129. Sum Root to Leaf Numbers
 * 计算根结点到叶子结点的路径代表的数字之和
 * @author hzf
 * @see https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRootToLeafNumber {
	public int sumNumbers(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root != null){
        	list = myDeep(root);
        }
        //calculate the sum
        int sum = 0;
        for(String str : list){
        	sum += Integer.parseInt(str);
        }
        return sum;
    }
	
	private List<String> myDeep(TreeNode root) {
		List<String> list = new ArrayList<>();
		if(root.left != null){
			List<String> leftList = myDeep(root.left);
			for(String str : leftList){
				list.add(root.val + str);
			}
		}
		if(root.right != null){
			List<String> rightList = myDeep(root.right);
			for(String str : rightList){
				list.add(root.val + str);
			}
		}
		if(list.isEmpty()){
			list.add(String.valueOf(root.val));
		}
		return list;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
