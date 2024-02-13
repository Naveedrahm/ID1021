public class Binary{

    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length-1;

        while (true) {
            // jump to the middle 
            int indexmid = (first + last)/2;

            if (array[indexmid] == key) {
            // hmm what now?
            return true;
            }
            
            if (array[indexmid] < key && indexmid < last) {
            // The index position holds something that is less than
            // what we're looking for, what is the first possible page? 
            first = indexmid + 1;
            continue;
            }
            
            if (array[indexmid] > key && indexmid > first) {
            // The index position holds something that is larger than 
            // what we're looking for, what is the last possible page? 
            last = indexmid - 1;
            continue;
            }
            // Why do we land here? What should we do?
            break;
        }
        return false;   
    }   
    
    public static void main(String[] args){
        int[] test = {1,2,3,4,5,6,7,8,9,10};

        if(!binary_search(test, 11)){
            System.out.printf("no\n", "no");
        }
        if(binary_search(test, 5)){
            System.out.printf("yes ");
        }
    }
}