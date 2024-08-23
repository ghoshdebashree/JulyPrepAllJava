public class DeleteMafterNLINKEDLIST {
    Node head;
    public void printList() {
    Node current = head;
    while (current != null) {
        System.out.print(current.data + " -> ");
        current = current.next;
    }
    System.out.println("null");
}

    public static void main(String[] args) {
        DeleteMafterNLINKEDLIST list = new DeleteMafterNLINKEDLIST();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(8);
        list.append(9);

        System.out.println("Original List:");
        list.printList();

        int M = 2, N = 3;
        list.deleteNNodesAfterMNodes(M, N);

        System.out.println("Modified List after deleting " + N + " nodes after every " + M + " nodes:");
        list.printList();
    }

    private void deleteNNodesAfterMNodes(int m, int n) {
        Node current = head;
        for(int i = 1; i < m && current != null ; i++){
            current = current.next;
        }
        if(current == null){
            return;
        }
        Node temp = current.next;
        for(int i = 1; i < n && temp != null; i++){
            temp = temp.next;
        }
        current.next =  temp;
        current = temp;

    }

    private void append(int data) {
        if(head == null){
            head = new Node(data);
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(data);
    }
}
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}