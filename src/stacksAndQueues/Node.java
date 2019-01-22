package stacksAndQueues;

public class Node {
    Node next = null;
    Object data;

    public Node(Object d){
        data = d;
    }

    void appendToTail(int d){
        Node end = new Node(d);
        Node current = this;

        while (current.next != null){
            current = current.next;
        }

        current.next = end;
    }

}
