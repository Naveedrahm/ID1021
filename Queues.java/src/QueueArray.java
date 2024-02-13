public class QueueArray<Item> {
    private Item[] queue; 
    private int first = 0; 
    private int last = 0; 
    private int size; 

    public QueueArray(int size){
        this.size = size; 
        this.queue = (Item[]) new Object[this.size];
    }

    public boolean empty(){
        return this.first == 0;
    }

    public void add(Item itm){
        queue[last] = itm; 
        last = (last + 1) % size;

        if(last == first){
            System.out.println(" \nTest if we go inside the if-statement!!!!!!");
            Item[] newArray = (Item[]) new Object[size*2];
            int counter = 0; 
            for(int i = first; i < size; i++){
                newArray[counter] = queue[i];
                counter++;
            } 
            for(int i = 0; i < last; i++){
                newArray[counter] = queue[i];
                counter++; 
            }
            size = size*2;
            first = 0; 
            last = 0;    
        }
        if(queue[last] == null){
            queue[last - 1] = itm; 
        }
        else{
            queue[last] = itm;
        }
        
        // last = (last + 1) % size;        
    }

    public Item remove(){
        if(first == last){
            return null; 
        }
        Item returnArray = queue[first];
        queue[first] = null; 
        first++;
        // queue[first + 1]= queue[first];
        first = (first + 1) % size; 
        return returnArray;

    }

    public void print(){
        System.out.println(" \nAll of the elements in the array");
       for(int i = 0; i < size; i++){
        System.out.println(queue[i]);
       }
    }


    public static void main(String[] args){
        int size = 5;

        QueueArray queue = new QueueArray(size);

        queue.add(10);
        queue.add(11);
        queue.add(12);
        queue.add(13);
        // queue.add(14);
        // queue.add(15);

        queue.print();

        // queue.add(14);
        // queue.add(15);
        // queue.print();
        System.out.println(" After three adds last element: " + queue.last + " First element of queue: " + queue.first);

        queue.remove();
        queue.print();

        System.out.println(" Remove Element: " + queue.remove());
        queue.print();

    }
} 
