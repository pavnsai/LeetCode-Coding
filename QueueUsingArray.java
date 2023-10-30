//do using circular queue also
class QueueUsingArray {
    int maxSize;
    int front;
    int rear;
    int [] queue;
    QueueUsingArray(int size){
        maxSize=size;
        front=-1;
        rear=-1;
        queue=new int[maxSize];
    }
    public int add(int ele){
        if(rear==maxSize-1){
            System.out.println("Queue is full from Array");
            return 0;
        }else {
            if(rear==-1){
                front=0;
            }
            queue[++rear] = ele;
            return 1;
        }
    }
    public int peek(){
        if(front==-1){
            System.out.println("queue is empty from Array");
            return -1;
        }else {
            return queue[front];
        }
    }
    public int pop(){
        if(front==-1){
            System.out.println("queue is empty from Array");
            return -1;
        }else {
            if(front==rear){
                int value=queue[front];
                front=rear=-1;
                return value;
            }
            return queue[front++];
        }
    }

    public static void main(String[] args) {
        QueueUsingArray qu=new QueueUsingArray(7);
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
        qu.add(20);
        System.out.println(qu.peek());
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        System.out.println(qu.pop());
        qu.add(20);
        qu.add(18);
        System.out.println(qu.peek());
    }
}
