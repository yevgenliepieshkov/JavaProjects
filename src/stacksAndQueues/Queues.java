package stacksAndQueues;

public class Queues {
    Node first, last;

    void enqueue(Object o){
        if(first == null){
            last = new Node(o);
            first = last;
        }
        else{
            last.next = new Node(o);
            last = last.next;
        }
    }

    Object dequeue(){
        if(first != null){
            Object o = first.data;
            first = first.next;
            return o;
        }
        return null;
    }
}
