class LinkedListForQueue{
    Node front=null;
    Node rear=null;
    public int add(int ele){
        if(front==null){
            front=new Node(ele);
            rear=front;
        }else {
            rear.next=new Node(ele);
            rear=rear.next;
        }
        return 1;
    }
    public int pop(){
        if(front==null){
            System.out.println("Queue is empty from Linked List");
            return -1;
        }else{
            int data=front.value;
            if(front==rear){
                front=null;
                rear=null;
            }
            else {
                front = front.next;
            }
            return data;
        }
    }
    public int peek(){
        if(front==null){
            System.out.println("Queue is empty from Linked List");
            return -1;
        }else{
            int data=front.value;
            return data;
        }
    }
}
class QueueUsingLinkedList {
    LinkedListForQueue qu=new LinkedListForQueue();
    public int add(int ele){
        return qu.add(ele);
    }
    public int pop(){
        return qu.pop();
    }
    public int peek(){
        return qu.peek();
    }

    public static void main(String[] args) {
        QueueUsingLinkedList qu=new QueueUsingLinkedList();
//        System.out.println(qu.peek());
        qu.add(18);
//        System.out.println(qu.peek());
        qu.add(20);
        qu.add(18);
        qu.add(18);
        qu.add(20);
        qu.add(18);
        qu.add(18);
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        System.out.println(qu.peek());
        qu.add(18);
        qu.add(20);
        System.out.println(qu.peek());
    }
}
