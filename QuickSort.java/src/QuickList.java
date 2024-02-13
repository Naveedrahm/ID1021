public class QuickList{

    Node head;
    Node tail; 
   
    public QuickList(){
        this.head = null;
        this.tail = null; 
    }

    public class Node{
        Integer value; 
        Node next; 

        private Node(Integer val, Node nxt){
            this.value = val; 
            this.next = nxt;
        }
    }


    public QuickList(int element){
        head = new Node(element, null);
    }

    public void add(Integer val){
        Node newNode = new Node(val, this.head);

        if(this.tail == null){
            this.tail = newNode;
        }
        this.head = newNode;
    } 

    public Integer max(){
        Node current = this.head; 
        if(current == null){
            return null;
        }
        Integer newMax = current.value;
        current = current.next;
        while(current != null){
            if(newMax.compareTo(current.value) < 0){
                newMax = current.value;
            }
            current = current.next;
        }
        return newMax;
    }

    public void appendlast(QuickList last){
        if(last != null){
            if(this.tail != null){
                this.tail.next = last.head;
            }
            else {
                this.head = last.head; 
            }
            if(last.tail != null){
                this.tail = last.tail;
            }
            last.head = null;
            last.tail = null;
        }
    }

    public void appendfirst(QuickList first){
        if(first != null){
            if(first.tail != null){
                first.tail.next = this.head;
            }
            if(this.tail == null){
                this.tail = first.tail;
            }
            if(first.head != null){
                this.head = first.head;
            }
            first.head = null;
            first.tail = null;
        }
    }

    private void posChange(Node newNode){
        if(this.tail == null){
            this.tail = newNode; 
        }
        newNode.next = this.head; 
        this.head = newNode;
    }

    public void sortLinked(){
        if(this.head == null || this.head.next == null){
            return;
        }
        QuickList lowList = new QuickList();
        QuickList highList = new QuickList();
        
        Node pivot = this.head; 
        Node current = pivot.next; 
        pivot.next = null;

        this.tail = pivot;

        Integer pivotValue = pivot.value;

        while(current != null){
            Node newnext = current.next; 
            if(pivotValue.compareTo(current.value) > 0){
                lowList.posChange(current);
            }
            else{
                highList.posChange(current);
            }
            current = newnext;
        }
        lowList.sortLinked();
        highList.sortLinked();
        this.appendlast(highList);
        this.appendfirst(lowList);
    }

    public void print(){
        if(this.head == null){
            System.out.println("EMPTYLIST");
        }
        Node current = this.head; 
        System.out.println(" ------------------- ");
        while(current != null){
            System.out.println("NEXT ITEM: " + current.value);
            current = current.next;
        }
    }

    public void printmax(){
        if(this.head == null){
            System.out.println("Empty");
        }
        System.out.println(" Maxvalue: " + max());
    }

    public static void main(String[] args){
        // int size = 4; 

        QuickList list = new QuickList();

        list.add(4);
        list.add(2);
        list.add(8);
        list.add(9);
        list.add(12);
        list.add(1);
        list.add(3);
        list.max();
        list.printmax();
        list.print();
        // list.print();
        // list.sortLinked();
        // list.print();
    }

    public static QuickList[] ListArray(int[][] Arr) {
        QuickList[] newLists = new QuickList[Arr.length];
        for (int i = 0; i < newLists.length; i++) {
            newLists[i] = new QuickList();
            if (Arr[i].length == 0) {
                newLists[i].head = null;
                newLists[i].tail = null;
            }
            else {
                newLists[i] = new QuickList(Arr[i][0]);
                Node n = newLists[i].head;
                for (int m = 1; m < Arr[i].length; m++) {
                    newLists[i].add(Arr[i][m]);
                }
                newLists[i].tail = n;
            }
        }
        return newLists;
    }
}
