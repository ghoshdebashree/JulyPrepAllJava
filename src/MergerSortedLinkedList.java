public class MergerSortedLinkedList {
    List root1, root2;
    public static void main(String[] args){
       //mergerSortedList(root1, root2);
    }

    private static List mergerSortedList(List root1, List root2) {
        List dummy = new List(0);
        List current = dummy;
        while(root1 != null && root2 != null){
            if(root1.data <= root2.data){
                current.next = root1;
                root1 = root1.next;
            }
            else{
                current.next = root2;
                root2 = root2.next;
            }
            current = current.next;
        }
        if(root1 != null){
            current.next = root1;
        }
        else{
            current.next = root2;
        }
        return dummy.next;
    }
}
class List{
    int data;
    List next;
    List(int data){
        this.data = data;
        next = null;
    }
}
