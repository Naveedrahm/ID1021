
    
public class LinkedList {
    Cell first;

     private class Cell {
      int head;
      Cell tail;
      
      Cell(int val, Cell tl) {
        head = val;
        tail = tl;
        }
    }

    
    // public void LinkedLiist(){
    //     first = null;
    // }
    
    public void add(int item){
        Cell newArray = new Cell(item, first);
        first = newArray;
        // Cell newnode = new Cell(item, null);
        
        // if(first == null){
        //     first = newnode;
        // }
        // else {
        //     Cell current = first;
        //     while(current.tail != null){
        //         current = current.tail;
                
        //     }
        //     current.tail = newnode;
        // }
        
    }
    
    // return the length of the sequence
    public int length(){
        int count = 0; 
        Cell current = first;
        
        while(current != null){
            count++; 
            current = current.tail;
        }
        
        return count;
    }
    
    // return true or false depending on if the item can be found in the sequence 
    public boolean find(int item){
        Cell current = first; 
        
        while(current != null){
            if(current.head == item){
                return true;
            }
            
            current = current.tail; 
            
        }
        return false; 
    }
    
    // remove the item it it exists in the sequence 
    public void remove(int item){
        Cell current = first;
        Cell prev = null;
        
        // if(first == null){
        //     return;
        // }
        
        // if(first.head == item){
        //     first = first.tail;
        //     return;
        // }
        
        
        while(current != null){
            if(current.head == item){
                prev.tail = current.tail;
            } else {
                first = current.tail;
            }
            return;
        }
        prev = current;
        current = current.tail;
    }
    
    
    
    public void append(LinkedList b) {
        Cell nxt = this.first;
        Cell prv = null;
        
        while (nxt.tail != null) {
            prv = nxt;
            nxt = nxt.tail;
        }
        nxt.tail = b.first;
        b.first = null;
        // if(prv != null){
        //     prv.tail = b.first;
        // }
        // else{
        //     this.first = b.first;
        // }
        // b.first = null; 
    }
    
    public static LinkedList GenerateLinkedList(int n) {
        // Cell last = null;
        LinkedList mylist = new LinkedList();
        
        for (int i = 0; i < n; i++) {
            mylist.add(i);
        //   last = new Cell(i, last);
        }
        return mylist;
      }
    
    // Bench 
    // public static void main(String[] args){
        
    //     System.out.printf("Bench of the appending data:\n");
    //     System.out.printf("%7s\t%8s\t%8s\t%8s\t%8s\n", "n", "G to F", "Whole GF", "F to G", "Whole FG");
    //     int[] sizes = {100, 200, 400, 800, 1000, 1600, 32000, 64000, 128000};
        
    //     for(int n : sizes){
    //         System.out.printf("%8d", n);
            
    //         int k = 1000;
    //         double min = Double.POSITIVE_INFINITY; 

    //         double min1 = Double.POSITIVE_INFINITY;
    //         for(int i = 0; i < k; i++){
    //             long start = System.nanoTime();

    //             LinkedList fixed = GenerateLinkedList(1000);
    //             LinkedList growing = GenerateLinkedList(n);
    //             long startTime = System.nanoTime();
    //             fixed.append(growing);
    //             long endTime = System.nanoTime();
    //             double total1 = (endTime - start);
    //             double total2 = (endTime - startTime);
    //             if(total2 < min){
    //                 min = total2;
    //             }
    //             if(total1 < min1){
    //                 min1 = total1;
    //             }
    //         }
    //         System.out.printf("%8.0f\t%8.0f\t", (min/1000), (min1/1000));

    //         min = Double.POSITIVE_INFINITY;
    //         min1 = Double.POSITIVE_INFINITY;
    //         for(int i = 0; i < k; i++){
    //             long start = System.nanoTime();

    //             LinkedList fixed = GenerateLinkedList(1000);
    //             LinkedList growing = GenerateLinkedList(n);
    //             long startTime = System.nanoTime();
    //             growing.append(fixed);
    //             long endTime = System.nanoTime();
    //             double total1 = (endTime - start);
    //             double total2 = (endTime - startTime);
    //             if(total2 < min){
    //                 min = total2;
    //             }
    //             if(total1 < min1){
    //                 min1 = total1;
    //             }
                
                
    //         }
    //         System.out.printf("%8.0f\t %8.0f\n", (min/1000), (min1/1000));

    // }

    // }

}

