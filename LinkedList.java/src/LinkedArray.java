import java.util.Random;
public class LinkedArray {
    
public static int[] appendArray(int[] array1, int[] array2){
int newarraysize = array1.length + array2.length;
int[] newarray = new int[newarraysize];
int counter = 0;
for(int i : array1){
newarray[counter] = i; 
counter++; 
}

for(int i : array2){
    newarray[counter] = i; 
    counter++;
}
return newarray;
}

public static int[] generateArray(int n){
Random rnd = new Random();
int[] array = new int[n];

for(int i = 0; i < n; i++){
    array[i] = rnd.nextInt(n*10);
}
return array;

}
public static void main(String[] args){

    System.out.printf("Bench on two arrays appending:\n");
    System.out.printf("%7s\t%8s\t%8s\t%8s\t%8s\n", "n", "G to F", "Whole GF", "F to G", "Whole FG");
    int[] sizes = {100, 200, 400, 800, 1000, 1600, 32000, 64000, 12800};

    for(int n : sizes){
        System.out.printf("%8d", n);
        
        int k = 1000;
        double min1 = Double.POSITIVE_INFINITY;
        double min2 = Double.POSITIVE_INFINITY;

        for(int i = 0; i < k; i++){

            long start = System.nanoTime();
            int[] fixed = generateArray(1000);
            int[] growing = generateArray(n);
            long startTime = System.nanoTime();
            int[] test = appendArray(fixed, growing);
            long endTime = System.nanoTime();
            double total1 = (endTime - start);
            double total2 = (endTime - startTime);
            if(total1 < min1){
                min1 = total1;
            }
            if(total2 < min2){
                min2 = total2;
            }
        }
            System.out.printf("%8.0f\t%8.0f\t", (min2/1000), (min1/1000));

        min1 = Double.POSITIVE_INFINITY;
        min2 = Double.POSITIVE_INFINITY;

        for(int i = 0; i < k; i++){
            long start = System.nanoTime();
            int[] fixed = generateArray(1000);
            int[] growing = generateArray(n);
            long startTime = System.nanoTime();
            int[] test = appendArray(growing, fixed);
            long endTime = System.nanoTime();
            double total1 = (endTime - start);
            double total2 = (endTime - startTime);
            if(total1 < min1){
                min1 = total1; 
            }
            if(total2 < min2){
                min2 = total2; 
            }
        }
        System.out.printf("%8.0f\t%8.0f\n", (min2/1000), (min1/1000));            
    }
    
    }
}
