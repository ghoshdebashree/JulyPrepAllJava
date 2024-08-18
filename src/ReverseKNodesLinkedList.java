public class ReverseKNodesLinkedList {
    public static void main(String[] args){
        ReverseKNodesLinkedList list = new ReverseKNodesLinkedList();
        Nodes head = new Nodes(1);
        head.next = new Nodes(2);
        head.next.next = new Nodes(3);
        head.next.next.next = new Nodes(4);
        head.next.next.next.next = new Nodes(5);
        head.next.next.next.next.next = new Nodes(6);
        int k = 2;
        Nodes result = reverseKNodes(head, k);
        printList(result);

    }

    private static Nodes reverseKNodes(Nodes head, int k) {
        Nodes dummy = new Nodes(0);
        dummy.next = head;
        Nodes current = head;
        Nodes prevGroupEnd = dummy;
        while(current != null) {
            Nodes groupStarts = current;
            Nodes groupEnds = current;
            for (int i = 1; i < k && groupEnds != null; i++) {
                groupEnds = groupEnds.next;
            }

            if (groupEnds == null) break;
            Nodes nextGroupStart = groupEnds.next;
            reverseData(groupStarts, groupEnds);
            prevGroupEnd.next = groupEnds;
            groupStarts.next = nextGroupStart;
            prevGroupEnd = groupStarts;
            current = nextGroupStart;
        }
        return dummy.next;
     }

    private static void reverseData(Nodes starts, Nodes ends) {
        Nodes prev = null;
        Nodes current = starts;
        Nodes next;
        while(prev != ends){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

    }
    public static void printList(Nodes head){
        Nodes node = head;
        while(node != null){
            System.out.println(node.data+ " -> ");
            node = node.next;
        }
    }


}
class Nodes{
    int data;
    Nodes next;
    Nodes(int data){
        this.data = data;
    }
}