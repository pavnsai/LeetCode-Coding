 class QueueUsingStackNormalApproachUsingLinkedList {
     StackUsingLinkedList st1=new StackUsingLinkedList();
     StackUsingLinkedList st2=new StackUsingLinkedList();
     public int add(int ele){
         if(st1.isEmpty()){
             st1.push(ele);
         }else{
             while (!st1.isEmpty()&&!st1.isFull()){
                 st2.push(st1.pop());
             }
             st1.push(ele);
             while (!st2.isEmpty() ){
                 st1.push(st2.pop());
             }
         }
         return 1;
     }
     public int peek(){
         if(st1.isEmpty()){
             System.out.println("Stack is empty");
             return -1;
         }else{
             return st1.peek();
         }
     }
     public int pop(){
         if(st1.isEmpty()){
             System.out.println("Stack is empty");
             return -1;
         }else{
             return st1.pop();
         }
     }

     public static void main(String[] args) {
         QueueUsingStackNormalApproachUsingLinkedList qu=new QueueUsingStackNormalApproachUsingLinkedList();
         qu.add(18);
         qu.add(20);
         qu.add(18);
         qu.add(18);
         qu.add(20);
         qu.add(18);
         qu.add(20);
//         System.out.println(qu.peek());
         qu.add(19);
         System.out.println(qu.pop());
         System.out.println(qu.pop());
         System.out.println(qu.pop());
         System.out.println(qu.pop());
         System.out.println(qu.pop());
         System.out.println(qu.pop());
         System.out.println(qu.pop());
//         System.out.println(qu.peek());
         System.out.println(qu.pop());
         System.out.println(qu.peek());
         System.out.println(qu.peek());
     }
}
