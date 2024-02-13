import java.security.SecureRandom;

public class priorityQueue{

    Node first;
    Node last;
    
    private class Node{
        Integer item;
        Node next; 
        private Node(Integer itm, Node nxt){
            this.item = itm;
            this.next = nxt;
        }
    }

    public priorityQueue(){
        this.first = null; 
        this.last = null;
    }
    
    public void constantAdd(Integer itm){
       if(first == null){
           first = new Node(itm, null);
       } 
       else{
            Node temp = new Node(itm, first);
            first = temp;
       }

    }

    public void nAdd(Integer itm){
        if(first == null){
            first = new Node(itm, null);
        } 
        else if(first.item > itm ){
            Node temp = new Node(itm, null);
            temp.next = first; 
            first = temp;
        }
        else if(first.item < itm){
            Node current = first;
            Node temp = new Node(itm, null);
            while(current.next != null){
                if(current.next.item > itm){
                    temp.next = current.next;
                    current.next = temp;
                    break;
                }
                current = current.next;
            }
            current.next = temp;
        }
    }

    public Node constantRemove(){
        Node tempNode = first.next;
        Node returnNode = first;
        first = null; 
        first  = tempNode;
        return returnNode;      
    }

    public Node nRemove(){
        Node current = first; 
        Node nodeMinB = null;
        Node returnNode = first;

        while(current.next != null){
            if(current.next.item < returnNode.item){
                nodeMinB = current; 
                returnNode = current.next;
            }
            current = current.next;
        }
        if(returnNode == first){
            first = first.next;
        }
        else{
            nodeMinB.next = returnNode.next;
        }
        return returnNode;
        // if(first == null){
        //     return null; 
        // }
        // Node temNode = first.next;
        // Node returnValue = first; 
        // first = first.next;
        // if(first == null){
        //     last = null;
        // }
        // return returnValue;
    }

    public boolean empty(){
           return(first == null);
    }

    public void print(){
        if(this.first == null){
            System.out.println("EMPTYLIST");
        }
        Node current = this.first; 
        System.out.println("/////////////");
        while(current != null){
            System.out.println("NEXT ITEM: " + current.item);
            current = current.next;
        }
    }
    
     private static int[] randomNumbers(int from, int to) {
        int n = to - from + 1;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        int[] result = new int[n];
        int x = n;
        SecureRandom rd = new SecureRandom();
        for (int i = 0; i < n; i++) {
            // k is a random index in [0,x]
            int k = rd.nextInt(x);
            result[i] = a[k];
            // we got a value from a[k]. we replace its value by the value from the
            // last index so that we will not get that value (a[k]) again
            a[k] = a[x - 1];
            x--;
        }
        return result;
    }
    public void genadd(Integer item) {
        Node newNode = new Node(item, null);
        if (this.first == null)
            this.first = newNode;
        if (this.last != null)
            this.last.next = newNode;
        this.last = newNode;
    }
    public static void main(String[] args){
        priorityQueue queue = new priorityQueue();
        int[] a = randomNumbers(0, 150);
        for (int i : a) {
            queue.genadd(i);
        }
        // System.out.println("IS THE LIST EMPTY? " + queue.empty());
        // queue.print();
        // queue.add(10);
        // priorityQueue queues = new priorityQueue();
        // System.out.println("IS THE LIST EMPTY? " + queue.empty());
        // System.out.println("WHICH ELEMENTS IN THE LIST: " + queue.QueueList());
        // queue.constantAdd(11);
        // queue.constantAdd(12);
        queue.print();
        // System.out.println(" Item removed: " + queue.remove());
        // System.out.println(" Item removed: " + queue.remove());
        // System.out.println(" Item removed: " + queue.remove());
        // System.out.println("IS THE LIST EMPTY? " + queue.empty());
        // queue.add(13); 
        // queue.remove();
        // System.out.println("IS THE LIST EMPTY? " + queue.empty());
        // System.out.println("List: " + queue.);
        // queues.nAdd(13);
        // queues.nAdd(16);
        // queues.nAdd(17);
        // queues.nRemove();
        // queues.print();
    }
}
