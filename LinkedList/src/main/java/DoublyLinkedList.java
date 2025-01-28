package estate.pk;

class DoublyLL {

    public static class Node{

        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    public static void DisplayAll(Node Head){
        Node temp=Head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp= temp.next;
        }
        System.out.println();

    }

    public static void DisplayReverse(Node tail){
        Node temp=tail;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp= temp.prev;
        }
        System.out.println();

    }

    public static void DisplayRandom(Node random){
        Node temp= random;
        while(temp.prev != null){
            temp = temp.prev;
        }

        //now temp is at head
        //now print complete list
        while(temp != null){
            System.out.print(temp.data +" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static Node insertAtHead(Node head, int x){
        Node tem=new Node(x);
        tem.next=head;
        head.prev=tem;
        head=tem;
        return head;
    }

    public static void intertAtTail(Node head, int x){
        Node tem=head;
        while(tem.next != null){
            tem= tem.next;
        }

        Node t= new Node(x);
        tem.next= t;
        t.prev=tem;

    }

    public static void insertAtIndex(Node head, int index,int x){
        Node s = head;
        for (int i=1; i<=index-1; i++){
            s=s.next;
        }

        // now r is at index
        Node r=s.next;
        Node tem= new Node(x);
        s.next = tem;
        tem.prev = s;
        tem.next =r;
        r.prev = tem;
    }

    public static void deleteHead(Node head){
        head = head.next;
        head.prev=null;

    }

    public static Node deleteTail(Node head ,Node tail){
        if (tail == null) {
            System.out.println("List is empty, cannot delete tail");
            return null;
        }

        Node newTail = tail.prev;
        if (newTail != null) {
            newTail.next = null;
        }
        return newTail;

    }

    public static void main(String[] args) {
        // 4 10 2 99 13
        Node a=new Node(4);
        Node b=new Node(10);
        Node c=new Node(2);
        Node d=new Node(99);
        Node e=new Node(13);
        a.next=b;
        b.prev=a;
        b.next=c;
        c.prev=b;
        c.next=d;
        d.prev=c;
        d.next=e;
        e.prev=d;
        DisplayAll(a);

        DisplayReverse(e);
        DisplayRandom(c);
        //Node newNode= insertAtHead(a, 30);
        DisplayAll(insertAtHead(a,30));

        intertAtTail(a,90);
        DisplayAll(a);

        insertAtIndex(a,3,56);
        DisplayAll(a);

        // Delete head
        deleteHead(b);
        DisplayAll(b);

        // Delete tail
        e = deleteTail(a, e);
        DisplayAll(a);

    }
}