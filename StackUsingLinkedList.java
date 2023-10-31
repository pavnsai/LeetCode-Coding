
class LinkedListForStack{
    Node head=null;
    public int push(int ele){
        if(head==null){
            head=new Node(ele);
            return 1;
        }
        else{
            Node temp=head;
            head=new Node(ele);
            head.next=temp;
            return 1;
        }
    }
    public int pop(){
        if(head==null){
            System.out.println("Stack is empty from linkedlist");
            return -1;
        }else{
            int data=head.value;
            head=head.next;
            return data;
        }
    }
    public int peek(){
        if(head==null){
            System.out.println("Stack is empty from linkedlist");
            return -1;
        }else{
            int data=head.value;
            return data;
        }
    }
    public boolean isEmpty(){
        return head==null;
    }
    public boolean isFull(){
        return false;
    }
}
 class StackUsingLinkedList {
    LinkedListForStack st=new LinkedListForStack();
    public int push(int ele){
        return st.push(ele);
    }
    public int pop(){
        return st.pop();
    }
    public int peek(){
        return st.peek();
    }
    public boolean isFull(){
        return st.isFull();
    }
    public boolean isEmpty(){
        return st.isEmpty();
    }
     public static void main(String[] args) {
         StackUsingLinkedList stll=new StackUsingLinkedList();
         stll.push(20);
         stll.push(18);
         System.out.println(stll.peek());
         System.out.println(stll.pop());
         System.out.println(stll.pop());
         System.out.println(stll.pop());
     }

}
