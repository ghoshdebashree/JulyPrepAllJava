
class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}

public class ConvertBinaryToDecimalLINKEDLIST {
    static ListNode head ;
    public static void main(String[] args){
        ConvertBinaryToDecimalLINKEDLIST list = new ConvertBinaryToDecimalLINKEDLIST();
        list.insert(1);
        list.insert(0);
        list.insert(1);
       System.out.println(fetchOutput(head));
    }

    private static int fetchOutput(ListNode head) {
        int result = 0;
        ListNode current = head;
        while(current != null){
            result = result << 1 | current.data;
            current = current.next;
        }
        return result;
    }

    private void insert(int value) {
        if(head == null){
            head = new ListNode(value);
            return;
        }
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
         current.next = new ListNode(value);
    }
}
