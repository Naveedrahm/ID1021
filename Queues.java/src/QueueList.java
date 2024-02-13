public class QueueList{
   
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

    public QueueList(){
        this.first = null; 
        this.last = null;
    }

    public void add(Integer itm){
        Node nxt = new Node(itm, null);

        if(last != null){
            last.next = nxt; 
        }
        last = nxt;

        if(first == null){
            first = nxt; 
        }
    }

    public Integer remove(){
        if(first == null){
            return null; 
        }
        Integer returnValue = first.item; 
        first = first.next;
        if(first == null){
            last = null;
        }
        return returnValue;
    }

    public boolean empty(){
           return(first == null);
    }

    public void print(){
        if(this.first == null){
            System.out.println("EMPTYLIST");
        }
        Node current = this.first; 
        System.out.println("START OF THE QUEUE: " + current);
        while(current != null){
            System.out.println("NEXT ITEM: " + current.item);
            current = current.next;
        }
    }
    
    public static void main(String[] args){
        QueueList queue = new QueueList();
        // System.out.println("IS THE LIST EMPTY? " + queue.empty());
        // queue.print();
        queue.add(10);

        // System.out.println("IS THE LIST EMPTY? " + queue.empty());
        // System.out.println("WHICH ELEMENTS IN THE LIST: " + queue.QueueList());
        queu.add(11);
        queue.add(12);
        
        // System.out.println(" Item removed: " + queue.remove());
        // System.out.println(" Item removed: " + queue.remove());
        // System.out.println(" Item removed: " + queue.remove());
        // System.out.println("IS THE LIST EMPTY? " + queue.empty());
        queue.add(13); 
        queue.remove();
        // System.out.println("IS THE LIST EMPTY? " + queue.empty());
        // System.out.println("List: " + queue.);
        queue.print();
    }
}
