public class QueueUsingCircularArray {
    int maxSize;
    int front;
    int rear;
    int [] queue;
    QueueUsingCircularArray(int size){
        maxSize=size;
        front=-1;
        rear=-1;
        queue=new int[maxSize];
    }
    public int add(int ele){
        if(((rear+1)%maxSize)==front){
            System.out.println("Queue is full from Circular Array");
            return -1;
        }else{
            rear=(rear+1)%maxSize;
            if(front==-1){
                front=0;
            }
            queue[rear]=ele;
            return 1;
        }
    }
    public int pop(){
        if(front==-1){
            System.out.println("Queue is empty from Circular Array");
            return -1;
        }else{
            int data=queue[front];
            if(front==rear){
                front=rear=-1;
            }else {
                front = (front + 1) % maxSize;
            }
            return data;
        }
    }
    public int peek(){
        if(front==-1){
            System.out.println("Queue is empty from Circular Array");
            return -1;
        }else {
            return queue[front];
        }
    }

    public static void main(String[] args) {
        QueueUsingCircularArray qu=new QueueUsingCircularArray(7);
        qu.add(18);
        qu.add(20);
        qu.add(18);
        qu.add(18);
        qu.add(20);
        qu.add(18);
        qu.add(18);
        System.out.println(qu.peek());
        qu.add(19);
        System.out.println(qu.pop());
        System.out.println(qu.peek());
        qu.add(20);
        System.out.println(qu.peek());
        qu.add(89);
        System.out.println(qu.pop());
        qu.add(18);
        qu.add(29);
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        System.out.println(qu.peek());
    }
}
