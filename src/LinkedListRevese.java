class LinkedNode{
    int data;
    LinkedNode next;
    LinkedNode(int data){
        this.data = data;
        this.next = null;
    }
}



public class LinkedListRevese {
    static LinkedNode head;
    public static void main(String[] args) {
        LinkedListRevese list = new LinkedListRevese();
        list.head = new LinkedNode(2);
        list.head.next = new LinkedNode(4);
        list.head.next.next = new LinkedNode(6);
        list.head.next.next.next = new LinkedNode(10);
        list.head.next.next.next.next = new LinkedNode(11);
        list.head.next.next.next.next.next = new LinkedNode(6);
        //list.reverseNode();
        list.printList();
        LinkedNode middle = list.middle();
        if (middle != null) {
            System.out.println("\nMiddle of the linked list: " + middle.data);
        } else {
            System.out.println("\nThe linked list is empty.");
        }
        boolean result = list.checkLoop();
        if(result == true){
            System.out.println("loop exists");
        }
        else{
            System.out.println("Not exixts");
        }


    }
    public static LinkedNode reverseNode(LinkedNode head){
        LinkedNode current = head;
        LinkedNode prev = null;
        LinkedNode next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        return prev;
    }

    public static boolean checkPalindrome(LinkedNode head){
        if(head == null && head.next == null){
            return true;
        }
        LinkedNode secondHalf = reverseNode(head);
        LinkedNode firstHalf = head;
        while(secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
    public static LinkedNode middle(){
        LinkedNode slow = head;
        LinkedNode fast = head;


        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public static void printList(){
        LinkedNode node = head;
        while(node != null){
            System.out.println(node.data+ " - >");
            node = node.next;

        }
    }
    public static boolean checkLoop(){
        LinkedNode slow = head;
        LinkedNode fast = head;
        if(head == null){
            return false;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow == fast){
            return true;
        }
        return false;
    }
}
