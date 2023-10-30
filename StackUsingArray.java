
class StackUsingArray {
    int maxSize;
    int top;
    int[] stackArray;
    StackUsingArray(int size){
        maxSize=size;
        stackArray=new int[maxSize];
        top=-1;
     }
     public int push(int ele){
         if(top==maxSize-1){
             System.out.println("Overflow");
             return 0;
         }else{
             top++;
             stackArray[top]=ele;
             return 1;
         }
     }
     public int peek(){
         if(top>=0){
             return stackArray[top];
         }else{
             System.out.println("Stack is empty");
             return -1;
         }
     }
     public int pop(){
         if(top>=0){
             return stackArray[top--];
         }
         else{
             System.out.println("Stack is empty");
             return -1;
         }
     }
     public static void main(String[] args) {
         StackUsingArray st=new StackUsingArray(6);
         st.push(18);
         st.push(20);
//         System.out.println(st.peek());
//         System.out.println(st.peek());
         System.out.println(st.pop());
         System.out.println(st.pop());
     }
}
