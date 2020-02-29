package linked_list;

public class ReverseNodes {
	
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode fakeHead = new ListNode(-1), curHead = head, preHead = null;
		ListNode nextGroupHead = findNextHead(head, k, fakeHead);
		do{
			reverse(curHead, nextGroupHead);
			preHead = curHead;
			curHead = curHead.next;
			nextGroupHead = findNextHead(curHead, k, preHead);
		}while(nextGroupHead != null);
		return fakeHead.next;
    }

	private void reverse(ListNode curHead, ListNode nextGroupHead) {
		ListNode preNode = curHead, curNode = curHead.next, nextNode = curNode.next;
		while(curNode != nextGroupHead){
			curNode.next = preNode;
			preNode = curNode;
			curNode = nextNode;
			nextNode = curNode.next;
		}
		curHead.next = nextGroupHead;
	}

	private ListNode findNextHead(ListNode head, int k, ListNode fakeHead) {
		ListNode resultNode = head;
		while(k > 0 && resultNode != null){
			if(k == 1){
				fakeHead.next = resultNode;
			}
			resultNode = resultNode.next;
			--k;
		}
		return resultNode;
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
