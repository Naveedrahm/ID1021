import java.util.Random;
public class BenchArray{

    public static int[] keys(int n){
        Random rnd = new Random();
        int[] indx = new int[n];
        for(int i = 0; i < n; i++){
            indx[i] = rnd.nextInt(n);
        }
        return indx;
    }
    public static void main(String[] args){


    
            // long start = System.nanoTime();
            int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400, 12800};

            System.out.printf("those: # searching through an array of length n, time in ns\n");
            System.out.printf("#%4s%15s%15s\n", "n", "Array", "LinkedList");

            ListTreeHeap heap = new ListTreeHeap();
    
            for ( int n : sizes) {
                System.gc();
                int k = 10;
                int[] keys = keys(n);
    
                //  int[][] RNDArray = QuickArray.generatRNDArray(loop, n);
    
                System.out.printf("%5d", n);
    
                Double min = Double.POSITIVE_INFINITY;
                for (int i = 0; i < k; i++) {
                    // priorityQueue queue = new priorityQueue();
                    
                    // int[][] arrays = QuickArray.copyArray(RNDArray);
                    long t0 = System.nanoTime();
                    for (int j = 0; j < n; j++){
                        // QuickArray.quickSortArray(arrays[j], 0, (arrays[j].length - 1));
                        // ListHeap.nRemove();
                        heap.push(keys[j]);
                    }
                    long t1 = System.nanoTime();
                    double t = (t1 - t0);
                    if (t < min) {
                        min = t;
                    }
                }
                System.out.printf("%10.3f", (min/100000));
    
                min = Double.POSITIVE_INFINITY;
                for (int i = 0; i < k; i++) {
                    
                    long t0 = System.nanoTime();
                    // QuickList[] copyList = QuickList.ListArray(RNDArray);
                    for (int j = 0; j < n; j++) {
                        // copyList[j].sortLinked();
                        heap.dequeue();
                    }
                    long t1 = System.nanoTime();
                    double t = (t1 - t0);
                    if (t < min) {
                    min = t;
                }
                    
                }
                System.out.printf("%10.3f\n" , (min/100000));
        }
            
    }
}