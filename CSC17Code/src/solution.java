/*
    Detect cycle in Linked List
    Given head, the head of a linked list, determine if the linked list has a cycle in it.
    There is a cycle in a linked list if there is some node in the list that can be reached again by
    continuously following the next pointer.
*/

import java.util.HashSet;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class solution {
    public static boolean hasCycle(ListNode head){
        HashSet <ListNode> list = new HashSet<ListNode>();
        while(head != null){
            if(list.contains(head)){
                return true;
            }else{
                list.add(head);
                head = head.next;
            }
        }
        return false;
    }

	public static void main(String args[]){
		ListNode head = null;
		ListNode tmp = null;
		System.out.println(hasCycle(head));
		head = new ListNode(3);
		head.next = head;
		System.out.println(hasCycle(head));
		tmp = head.next = new ListNode(1);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(7);
		System.out.println(hasCycle(head));
		head.next.next.next.next = tmp;
		System.out.println(hasCycle(head));
	}
}