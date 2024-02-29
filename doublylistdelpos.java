public class doublylistdelpos {
    Node head,tail;
    int size;
        
    public doublylistdelpos(){
        head = tail = null;
        size =0;
    }
    public class Node {
        int  data;
        Node next;
        Node prev;
                
        Node(int data){
            this.data= data;
            this.next = null;
            this.prev = null;
            size++;
            
        }
    }
    public void create(int value){
        Node newnode = new Node(value);
        if(head==null)
            head = tail = newnode;
        else{
            newnode.prev = tail;
            tail.next = newnode;
            tail = newnode;
        }
    }
    public void display(Node head){
        if(head==null)
            System.out.println("list is empty");
        else{
            while (head!=null) {
                System.out.println(head.data);
                head = head.next;
            }
        }
    }
    public void delpos(int idx){
        if(head==null||idx<0||idx>size-1)
            System.out.println("deletion not possible");
        else if(idx==0){
            if(head.next==null){
                head = null;
            }
            else{
                head = head.next;
                head.prev = null;
            }
        }
        else if(idx==size-1){
            tail = tail.prev;
            tail.next = null;
        }
        else{
            Node temp = head;
            for(int i=0;i<idx;i++)
                temp = temp.next;
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }
    public static void main(String[] args){
        doublylistdelpos list = new doublylistdelpos();
        list.create(2);
        // list.create(4);
        // list.create(6);
        // list.create(9);
        list.display(list.head);
        System.out.println();
        list.delpos(0);
        list.display(list.head);
    }
    
} 
