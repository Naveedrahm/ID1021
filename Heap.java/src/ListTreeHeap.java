public class ListTreeHeap {
    Node root;
    
    public class Node{
        Integer nodeVal;
        int size = 1; 
        Node right; 
        Node left;
        Node next;
        private Node(Integer Value){
            this.nodeVal = Value;
            this.right = null; 
            this.left = null; 

        }
        private void add(Integer item){
            size += 1;
            if(item < nodeVal){
                Integer temp = nodeVal;
                nodeVal = item;
                item = temp;
            }
            if(right != null){
                Node tmp = left; 
                right.add(item);
                left = right; 
                right = tmp;
            }
            else{
                right = new Node(item);
            }
        }
        public Node remove(){
            size -= 1;
            if(right == null){
                return left;
            }
            else{
                if(left == null){
                    return right; 
                }
                else{
                    if(left.nodeVal < right.nodeVal){
                        nodeVal = left.nodeVal;
                        left = left.remove();
                    }
                    else{
                        nodeVal = right.nodeVal;
                        right = right.remove();
                        size--;
                    }
                    return this;
                }
            }
        }
    }

    public void add(int add){
        if(root == null){
            root = new Node(add);
        }
        else{ 
            root.add(add);
        }
    }

    public ListTreeHeap(){
        root = null;
    }

    
    public int remove(){
        if(root == null){
            return -1; 
        }
        int minus = root.nodeVal;
        root  = root.remove();
        return minus;
    }

    public void print(){
        if(this.root == null){
            System.out.println("EMPTYLIST");
        }
        Node current = this.root; 
        System.out.println("/////////////");
        while(current != null){
            System.out.println("NEXT ITEM: " + current.nodeVal);
            current = current.next; 
        }
    }
    public static void main(String[] args){
        ListTreeHeap heap = new ListTreeHeap();

        heap.add(23);
        heap.add(8);
        heap.add(13);
        heap.add(50);
        heap.add(74);
        heap.add(18);
        heap.print();
        heap.remove();
        heap.print();
        // System.out.println(heap.dequeue());
        // System.out.println(heap.dequeue());

        int p = heap.remove();
        while( p != -1){
            System.out.println(p);
            p = heap.remove();
        }
        // heap.print();
        // heap.dequeue();
        // heap.print();
    }
}
