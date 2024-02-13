public class dynamic extends Stack{

    final int SIZE;
    public dynamic(){
        SIZE = 4;
        stack = new int[SIZE];
        pointer = 0;
        size = SIZE;
    }

    public void push(int value){
        if(pointer == size){
            int[] copy = new int[size*2];
            for(int i = 0; i < size; i++){
                copy[i] = stack[i];
            }
            size = 2*size;
            stack = copy;
        }
        stack[pointer] = value;
        pointer ++;
    }

    public int pop(){
        pointer--;
        if(pointer < 0)
            System.out.println("emp");
        else if(pointer < (size/4) && size > SIZE){
            int[] copy = new int[size/2];

            for(int i = 0; i < copy.length; i++){
                copy[i] = stack[i];
            }
            size = size/2;
            stack = copy;
        }
        return stack[pointer];
    }
    /*//final int SIZE;
    public dynamic(int size ){
        this.size = size; 
        super.stack = new int[size];
    }
    public dynamic(int s){
        SIZE = s;
        size = SIZE;
        super.stack = new int[size];
        super.pointer = 0;
        }

        public void push(int value){
            if(pointer == size){
                int[] copy = new int[size*2];
                size = size*2;
                for(int i = 0; i < stack.length; i++){
                    copy[i] = stack[i];
                }
                stack = copy;  
            } else {
                System.exit(0);
            }
        }
        
        public int pop() {
            if (pointer > 0) {
                int num = stack[--pointer]; // Decrease the pointer and get the top element
                if (pointer < size / 2) {
                    // If the stack is less than half full, create a smaller array and copy the elements
                    int[] copy = new int[size / 2];
                    size = size / 2;
                    for (int i = 0; i < pointer; i++) {
                        copy[i] = stack[i];
                    }
                    stack = copy;
                }
                return num;
            } else {
                return -1; // Return a special value (e.g., -1) to indicate an empty stack
            }
        }
        public int pop(){
            if(pointer >= 0){
            int num = stack[--pointer];

            if(pointer < stack.length/2){
                int[] copy = new int[stack.length/2];
                size = size/2;
                for(int i = 0; i < stack.length; i++){
                    copy[i] = stack[i];
                }
                stack = copy; 
            } 
            return num; //System.out.println("empty");
            }
            return -1;
           /*  if(pointer > 0){
                return stack[--pointer];
            } else{
                return 0;
            }
            */
 }
