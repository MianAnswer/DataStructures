public class LinkedListAlgorithm {
    private Node head;
        
    //Node class
    class Node {
        int value;
        Node next;
        //Node Constructor
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
        //Node Constructor
        public Node() {
            this.next = null;
        }
    }
       
    //Linked List Constructor
    public LinkedListAlgorithm() {
        head = new Node();
    }
    
    public boolean Delete(int value) {
        Node current = head;
        while(current.next != null) {
            if(current.next.value == value) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public int Insert(int value) {
        Node current = head;
        if(current.next == null) {
            current.next = new Node(value);
        } else {
            while(current.next != null) {
                current = current.next;
            }
            current.next = new Node(value);
        }
        return current.next.value;
    }
    
    public boolean Search(int value) {
        Node current = head;
        while(current.next != null) {
            if(current.next.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public void list() {
        Node current = head;
        while(current.next != null) {
            System.out.println(current.next.value);
            current = current.next;
        }
    }
    
}
