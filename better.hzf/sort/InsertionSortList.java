package sort;

import sort.SortList.ListNode;

/**
 * 147. 对链表进行插入排序
 * @author hzf
 * @see https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class InsertionSortList {
	
	public ListNode insertionSortList(ListNode head) {
        ListNode preHead = new ListNode(Integer.MIN_VALUE);
        
        ListNode cur = head, next = null;
        while(cur != null){
        	cur = doInsert(cur, preHead);
        }
        return preHead.next;
    }

	private ListNode doInsert(ListNode cur, ListNode preHead) {
		ListNode next = cur.next, finder = preHead;
		while(finder.next != null && cur.val > finder.next.val){
			finder = finder.next;
		}
		
		cur.next = finder.next;
		finder.next = cur;
		
		return next;
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
