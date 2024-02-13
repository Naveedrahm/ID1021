public class statics extends Stack{ 

    public statics(int size){
        super.size = size;
        super.stack = new int[size];
    }

    public void push(int value){ 
        if(pointer < size) {
            stack[pointer] = value;
            pointer++; 
        } else {
            System.exit(0);
        }
    }
    
    public int pop (){
        if(pointer == 0){
            return 0;
        }
        else return stack[--pointer];
    }
}
