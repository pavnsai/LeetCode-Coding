class Node{
    int value;
    Node next;
    Node(int d){
        value=d;
        next=null;
    }
}
public class LinkedList2 {
    Node head;
    public Node insert(Node list,int data){
        Node temp=new Node(data);
        if(list==null){
            head=temp;
        }else {
            while (list.next != null) {
                list = list.next;
            }
            list.next = temp;
        }
        return head;
    }
    public void print(Node list){
        while(list!=null){
            System.out.println(list.value);
            list=list.next;
        }
    }
    public Node delete(Node list,int data){
        Node prev=null;
        if(head.value==data){
            head=head.next;
            return head;
        }
        while(list!=null){
            if(list.value==data){
                prev.next=list.next;
                break;
            }else{
                prev=list;
            }
            list=list.next;
        }
        return head;
    }
    public static void main(String[] args) {
        System.out.println("Hello");
        LinkedList2 li=new LinkedList2();
        Node list=li.insert(null,18);
//        li.print(list);
        li.insert(list,18);
        li.insert(list,20);
//        li.print(list);
        li.insert(list,18);
        li.insert(list,18);
//        li.print(list);
        li.delete(list,18);
        li.print(li.head);
    }
}
