import java.util.Random;

import org.w3c.dom.Node;

public class DoubleLinkedList {

    Node first; 

        private class Node{
            int head; 
            Node tail;
            Node prev; 
        
        Node(int val, Node t1){
            head = val;
            tail = t1;
        }
    }

    public void add (int item){
        Node newArray = new Node(item, first);
        first = newArray;
    }

    public int length(){
        int count = 0; 
        Node current = first;

        while(current != null){
            count ++;
            current = current.tail; 
        }
        return count;
    }

    public boolean find(int item){
        Node current = first; 

        while (current != null){
            if(current.head == item){
                return true; 
            }
            current = current.tail;
        }
        return false; 
    }

    public void remove(int item){
        Node current = first; 
        Node prev = null; 
        
        while(current != null){
            if(current.head == item){
                if(current.prev != null){
                    current.prev.tail = current.tail;
                }
                if(current.tail != null){
                    current.tail.prev =current.prev;
                }
            
            return;
            }
       current = current.tail; 
        }

    }

    public void append(DoubleLinkedList b){
        Node nxt = this.first; 
        Node prv = null; 

        while(nxt.tail != null){
            prv = nxt; 
            nxt = nxt.tail; 
        }
        nxt.tail = b.first; 
        b.first = null; 
    }

    private static int[] generateArray(int n, int k){
        Random random = new Random();
        int[] newArray = new int[n];

        for(int i = 0; i < n; i++){
            newArray[i] = random.nextInt(n);
        }
        return newArray;
    }
    public static DoubleLinkedList GenerateList(int n){
        DoubleLinkedList mylist = new DoubleLinkedList();

        for(int i = 0; i < n; i++){
            mylist.add(n);
        }
        return mylist;
    }

    public void unlink(Node newNode){
        if(newNode != null){
            if(newNode == first){
                first = newNode.tail; 
                return;
            }
            if(newNode.tail != null){
                newNode.tail.prev = newNode.prev;

            }
            if(newNode.prev != null){
                newNode.prev.tail = newNode.tail;
            }
            newNode.tail = null; 
            newNode.prev = null; 
            return;
        }
    }

    public void insert (Node newNode){
        if(newNode == null){
            return;
        }
        if(first != null){
            newNode.tail = first; 
            first.prev = newNode; 
        }
        first = newNode;
    }

    public static double doubleBench(doubleNode[] array, DoubleLinkedList list, int[]randomArray, int loop, int keys, int size){

        double min = Double.POSITIVE_INFINITY;

        for(int i = 0; i < size; i++){
            doubleNode node = new doubleNode(i);
            list.insert(node);
            array[i] = node; 
        }
        for(int i = 0; i < loop; i++){
            long start = System.nanoTime();
            for(int j = 0; j < keys; j++){
                list.unlink(array[randomArray[j]]);
                list.insert(array[randomArray[j]]);
            }
            long end = System.nanoTime();
            double total = end - start; 

            if(total < min){
                min = total; 
            }
            return min;
        }
    }

    public static double singleBench(singleNode[] array, singleList list, int[] randomArray, int loop, int keys, int size){
      double min = Double.POSITIVE_INFINITY;

        for(int i = 0; i < size; i++){
            singleNode node = new singleNode(i);
            list.insert(node);
            array[i] = node; 
        }
        for(int i = 0; i < loop; i++){
            long start = System.nanoTime();
            for(int j = 0; j < keys; j++){
                list.unlink(array[randomArray[j]]);
                list.insert(array[randomArray[j]]);
            }
            long end = System.nanoTime();
            double total = end - start; 

            if(total < min){
                min = total; 
            }
            return min;
        }
    }
 
    public static void main(String[] args) {
        int [] listSize  = {100, 200, 400, 800, 1000, 12000, 14000, 16000, 32000, 64000};
       int iter = 100; 
        int k = 1000;

        System.out.printf(" BENCHAMRK OF INSERT AND UNLINK");
        System.out.printf("#%7s\t%8s\t%8s\n", "n", "Double", "Single");

        for(int n : listSize){

            System.out.printf("%8d\t", n);

            doubleNode[] DoubleCopy = new doubleNode[n]; 
            doubleList DoubleListCopy = new doubleList(k);

        }
        

        }
}

