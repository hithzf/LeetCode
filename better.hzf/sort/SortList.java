package sort;

/**
 * 148. 排序链表
 * @author hzf
 * @see https://leetcode-cn.com/problems/sort-list/
 * TODO: 这题应该用归并算法实现
 */
public class SortList {
	
	public ListNode sortList(ListNode head) {
		if(head == null){
			return head;
		}
		ListNode pre = head, cur = head.next;
		while(cur != null){
			if(cur.val < head.val){
				pre.next = cur.next;
				cur.next = head;
				head = cur;
			}else{
				ListNode realPre = findPre(head, cur);
				if(realPre != null){
					pre.next = cur.next;
					cur.next = realPre.next;
					realPre.next = cur;
				}else{
					pre = cur;
				}
			}
			cur = pre.next;
		}
		return head;
    }

	private ListNode findPre(ListNode head, ListNode des) {
		ListNode node = head;
		while(node.next != des){
			if(node.val == des.val || (node.val < des.val &&  node.next.val > des.val)){
				return node;
			}
			node = node.next;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
}
