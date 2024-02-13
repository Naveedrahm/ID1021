import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Stack;

public class  BinaryTree implements Iterable<Integer>{
    
     public Iterator <Integer> iterator(){
         return new TreeIterator();
    }
    
    public class Node{
        public Integer key;
        public Integer value; 
        public Node left, right; 
        
        Node root; 

        public Node (Integer key, Integer value){
            this.key = key;
            this.value = value; 
            this.left = this.right = null; 
        }

            public void add(Integer key, Integer value){
                    Node current = this; 
                        if(current.key == key){
                            current.value = value;
                        }
                        if( current.key > key){
                            if(current.left == null){
                                current.left = new Node(key, value);
                            }
                                current = current.left;
                                current.add(key, value);
                        }
                        if(current.key < key){
                            if(current.right == null){
                                current.right = new Node(key, value);
                            } 
                                current = current.right;
                                current.add(key, value);
                        
                        }
            }
            
        private Integer lookup(Integer key){
                if(root != null){
                    Node current = root;
                    while(current != null){
                        if(current.key == key){
                            return current.value;
                        }
                        if(current.key < key){
                            current = current.right; 
                        }
                        else{
                            current = current.left;
                        }
                    }
                } 
                return null;
            } 
            
            public void print(){
                if(left != null){
                    left.print();
                }
                System.out.println(" key: " + key + "\tvalue: " + value);
                if(right != null){
                    right.print();
                }
            }  

            public void BinaryTree(){
                root = null; 
            }

        }

        Node root; 

        public void add(Integer key, Integer value){
            if(root ==  null){
                root = new Node(key, value);
            }
            else{
                root.add(key, value);
            }
        }
        
        // public void BinaryTree(int size){
        //     Random rnd = new Random();
        //     root = new Node(size/2, size/2);
        //     for(int i = 0; i < size; i++){
        //         add(rnd.nextInt(size), rnd.nextInt(size));
        //     }
        // }

        public Integer lookup(Integer key){
            return root.lookup(key);
        }
        

        public void print(){
        if(root == null){
            System.out.println("Tree is empty :(");
            return;
        }
        root.print();
        }




    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();

            tree.add(5, 105);
            tree.add(2,102);
            tree.add(7, 107);
            tree.add(1,101);
            tree.add(8, 108);
            tree.add(6,106);
            tree.add(3, 103);
        // System.out.println(tree.key + ", " + tree.value);
            tree.root.print();
             
            // for(int i : tree){
            //     System.out.println("next value " + i);
            //     // tree.root.print();
            // }
    }

    public class TreeIterator implements Iterator<Integer>{
            private Node next;
            private TreeStack<Node> stack;
            
            public TreeIterator(){
                stack = new TreeStack<Node>();

                if( root == null){
                    next = null;
                } 
                else{
                    Node nxt = root;
                    while(nxt.left != null){
                        stack.push(nxt);
                        nxt = nxt.left;
                    }
                    next = nxt;
                }
            }

            @Override
            public boolean hasNext(){
                return (next != null);
            }

            @Override
            public Integer next(){
                if(!hasNext()){
                    // throw new NoSuchElementException();
                    return null;
                }
                
                Node current = stack.pop(); //tar ut elementet från stacken 
                if(current.right != null){ //elementet från stack, så länge den inte har null till höger
                    downLeft(current.right); //då går vi till vänster om höger.
                }
                next = current;
                return current.value;
            }

            public void downLeft(Node current){
                while(current != null){
                    stack.push(current);
                    current = current.left;
                }
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }

            
}

}
