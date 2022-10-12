public class SinglyLinkedList {
	
	// reference that points to the list head
	public ListNode head;
	
	// nested class for singly-list node
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
		ListNode(int x, ListNode nextIn) { 
			this.val = x;
			this.next = nextIn;
		}
	}
	
	public SinglyLinkedList() {
		head = null;
	}
	
	// add node to the head of list
	private void add(int val) {
		ListNode e = new ListNode(val, head);
		head = e;
		
	}
	
	public String toString() {
   	 	String mylist = "";
   	 	ListNode e = head;
   	 	while(e != null) {
   	 		mylist = mylist + e.val + " ";
   	 		e = e.next;
   	 }
   	 return mylist;
	}
	
    private void reverseList() {
        ListNode headPointer = head;
        ListNode previous = null;
        ListNode current = null;

        while(headPointer != null){
            current = headPointer;
            headPointer = headPointer.next;

            // reverse the link
            current.next = previous;
            previous = current;
            head = current;
        }
    }

    public int getCount()
    {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    private ListNode reverse(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode restPart = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return restPart;
    }
    
    private void reverseBetween(int m, int n) throws Exception{
        int listLength = this.getCount();
		if(m < 0 || n > listLength){
            System.out.println("Out of index!");
        } else if(m != n){
            int count = 1;

            ListNode current = this.head;
            ListNode reversePrev = null;
            
            while(count<m){
                reversePrev = current;
                current = current.next;
                count = count + 1;   
            }
            ListNode reverseStart = current;
            while(count<n){
                current = current.next;
                count = count + 1;
            }
            ListNode reverseEnd = current;
            ListNode reverseNext = current.next;
            current.next = null;
            ListNode reversePart = reverse(reverseStart);
            if(reversePrev!=null){
                reversePrev.next.next = reverseNext;
                reversePrev.next = reversePart;
            }else{
                if(reverseNext!=null){
                    head.next = reverseNext;
                }
            }
        }
    }
    
    public static void main(String args[]) throws Exception {
    	SinglyLinkedList list1 = new SinglyLinkedList();
    	for(int i = 10; i > 0; i--) {
    		list1.add(i);
    	}
    	System.out.println(list1);
    	list1.reverseList();
    	System.out.println(list1);
    	list1.reverseList();
    	System.out.println(list1);
    	list1.reverseBetween(3,7);
    	System.out.println(list1);
    }
}