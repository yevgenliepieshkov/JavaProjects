package stacksAndQueues;

public class Stacks {
    Node top;

    Object pop(){
        if(top != null){
            Object item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }

    void push(Object item){
        Node topp = new Node(item);
        topp.next = top;
        top = topp;
    }

    Object peek(){
        return top.data;
    }
}
