public class TreeStack<T>{

    Node first;
    int size;

    private class Node{
        T value;
        Node next; 
         
        private Node(T value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public TreeStack(){
        first = null; 
        size = 0; 
    }

    public void push(T node ){
        Node item = new Node(node, first);
        first = item; 
        size++;
    }

    public T pop(){
        if(first == null){
            return null; 
        }
        T poped = first.value;
        first = first.next;
        size--;

        return poped;
    }
}