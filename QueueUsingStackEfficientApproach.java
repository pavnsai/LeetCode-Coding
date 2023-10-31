public class QueueUsingStackEfficientApproach {
    StackUsingLinkedList input=new StackUsingLinkedList();
    StackUsingLinkedList output=new StackUsingLinkedList();
    public int add(int ele){
        input.push(ele);
        return 1;
    }
    public int pop(){
        if(output.isEmpty()){
            while (!input.isEmpty()){
                output.push(input.pop());
            }
            return output.pop();
        }else{
            return output.pop();
        }
    }
    public int peek(){
        if(output.isEmpty()){
            while (!input.isEmpty()){
                output.push(input.pop());
            }
            return output.peek();
        }else{
            return output.peek();
        }
    }

    public static void main(String[] args) {
        QueueUsingStackEfficientApproach qu=new QueueUsingStackEfficientApproach();
        System.out.println(qu.pop());
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
        System.out.println(qu.pop());
        System.out.println(qu.pop());
    }
}
