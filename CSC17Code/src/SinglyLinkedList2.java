public class SinglyLinkedList2{
	
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
	
	public SinglyLinkedList2() {
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
	
	public void partition(int x) {
		// place your code here
        ListNode lessHead = new ListNode(0);
        ListNode moreHead = new ListNode(0);
        ListNode before = lessHead;
        ListNode after = moreHead;

        while(head != null){
            if(head.val < x){
                before.next = head;
                before = before.next;
            }else{
                after.next = head;
                after = after.next;
            }
            head = head.next;  
        }
        after.next = null;
        before.next = moreHead.next;
        this.head = lessHead.next;
    }
    
    public void deleteDuplicates1() {
		// place your code here
        ListNode current = head;
        ListNode temp = null;
        ListNode index = null;
        while(current != null){
            temp = current;
            index = current.next;

            while(index != null){
                // if values are the same
                if(current.val == index.val){
                    temp.next = index.next;
                }else{
                    temp = index;
                }
                index = index.next;
            }
            current = current.next;
        }
    }
    
    public void deleteDuplicates2() {
		// TODO: Still need to correctly implement meathod
		// place your code here
        ListNode temp = head;
        ListNode deletedList = new ListNode(0);
        while(temp != null){
            if(temp.val != temp.next.val){
                deletedList.next = temp;
            }else {
                continue;
            }
            temp = temp.next;
        }
        head = deletedList.next;
    }
    

    
    public static void main(String args[]) {
    	SinglyLinkedList2 list1 = new SinglyLinkedList2();
    	SinglyLinkedList2 list2 = new SinglyLinkedList2();
    	SinglyLinkedList2 list3 = new SinglyLinkedList2();
    	int[] array1 = {1,4,3,2,5,2};
    	int[] array2 = {1,1,2,3,3,3};
    	int[] array3 = {1,1,2,2,2,3};
    	for(int i = 5; i > -1; i--) {
    		list1.add(array1[i]);
    		list2.add(array2[i]);
    		list3.add(array3[i]);
    	}
    	System.out.println(list1);
    	list1.partition(3);
    	System.out.println(list1);
    	
    	System.out.println(list2);
    	list2.deleteDuplicates1();
    	System.out.println(list2);
    	
    	System.out.println(list3);
    	list3.deleteDuplicates2();
    	System.out.println(list3);
    }
}