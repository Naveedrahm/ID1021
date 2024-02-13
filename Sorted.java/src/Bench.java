import java.util.Random;


class Bench {

    private static void linear(int[] array, int[] indx) {
	for (int i = 0; i < indx.length ; i++) {
	    Linear.search(array, indx[i]);
	}
    }
    

    public static void binary(int[] array, int[] indx) {
	for (int i = 0; i < indx.length ; i++) {
	    Binary.binary_search(array, indx[i]);
	}
    }

    private static void linearsorted(int[] array, int[] indx){
        for(int i = 0; i < indx.length; i++){
            sorted.search_sorted(array, indx[i]);
        }
    }

    private static void linearunsorted(int[] array, int[] indx){
        for(int i = 0; i < indx.length; i++){
            unsorted.search_unsorted(array, indx[i]);
        }
    } 

    private static double time_linear(int[] array1, int[] array2, int indx){
        int tries = 10; 
        double min = Double.POSITIVE_INFINITY;

        for(int i = 0; i < tries; i++){
            long t0 = System.nanoTime();
            duplicate.duplinear(array1, array2);
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if(t < min){
                min = t;
            }
        }
        return min;
    }

    private static double time_binary(int[] array1, int[] array2, int indx){
        int tries = 10;
        double min = Double.POSITIVE_INFINITY;

        for(int i = 0; i < tries; i++){
            long t0 = System.nanoTime();
            duplicate.dupbinary(array1, array2);
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if(t < min){
                min = t;
            }
        }
         return min;
    }

    private static double time_pointer(int[] array1, int[] array2, int indx){
        int tries = 10; 
        double min = Double.POSITIVE_INFINITY;

        for(int i = 0; i < tries; i++){
            long t0 = System.nanoTime();
            duplicate.duplicatepointer(array1, array2);
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if(t < min){
                min = t;
            }
        }
        return min;
    }

    public static int[] sorted(int n) {
	Random rnd = new Random();	
	int[] array = new int[n];
	int nxt = rnd.nextInt(10);

	for (int i = 0; i < n ; i++) {
        array[i] = nxt;
	    nxt += rnd.nextInt(10) + 1 ;
	}	
	return array;
    }
    
    public static int[] unsorted(int n) {
	Random rnd = new Random();	
	int[] array1 = new int[n];
	//int nxt = rnd.nextInt(10);

	for (int i = 0; i < n ; i++) {
	    array1[i] = rnd.nextInt(10);
	}	
	return array1;
    }


    private static int[] keys(int loop, int n) {
	Random rnd = new Random();	
	int[] indx = new int[loop];
	for (int i = 0; i < loop ; i++) {
	    indx[i] = rnd.nextInt(n*5);
	}	
	return indx;
    }

    
    public static void main(String[] arg) {

	// int[] sizes = {100, 200, 400, 600, 800, 1000, 1200, 1400, 1600};

    // System.out.printf("# searching through an array of length n, time in ns\n");
	// System.out.printf("#%7s%8s%8s%8s%8s\n", "n", "linear", "binary", " unsorted", "sorted" /* ," unsorted", "sorted"*/);
	// for ( int n : sizes) {

	//     int loop = 10000;
	    
	//     int[] array = sorted(n);
	//     int[] indx = keys(loop, n);
        
    //     int[] array1 = unsorted(n);
    //     int[] indx1 = keys(loop,n);
        
	//     System.out.printf("%8d", n);
    //     int k = 1000;
    //     int k1 = 1000;
        
	//     double min = Double.POSITIVE_INFINITY;
        
	//     for (int i = 0; i < k; i++) {
    //         long t0 = System.nanoTime();
    //         linear(array, indx);
    //         long t1 = System.nanoTime();
    //         double t = (t1 - t0);
    //         if (t < min)
	// 	    min = t;
	//     }
        
	//     System.out.printf("%8.0f", (min/loop));	 

        
	//     min = Double.POSITIVE_INFINITY;
	    
	//     for (int i = 0; i < k; i++) {
	// 	long t0 = System.nanoTime();
	// 	binary(array, indx);
	// 	long t1 = System.nanoTime();
	// 	double t = (t1 - t0);
	// 	if (t < min)
	// 	    min = t;
	//     }

	//     System.out.printf("%8.0f" , (min/loop));	
        
    //     min = Double.POSITIVE_INFINITY;

    //     for (int i = 0; i < k1; i++) {
    //         long t0 = System.nanoTime();
    //         linearunsorted(array1, indx1);
    //         long t1 = System.nanoTime();
    //         double t = (t1 - t0);
    //         if (t < min)
	// 	    min = t;
	//     }
        
    //     System.out.printf("%8.0f", (min/loop));
        
    
    //      min = Double.POSITIVE_INFINITY;

    //    for (int i = 0; i < k; i++) {
    //        long t0 = System.nanoTime();
    //        linearsorted(array, indx);
    //        long t1 = System.nanoTime();
    //        double t = (t1 - t0);
    //        if (t < min)
    //        min = t;
	//     }
        
	//     System.out.printf("%8.0f\n", (min/loop));
        
	//  }

    
    int loop = 1000;
    int k = 100;
    int[] size2 = {100, 200, 400, 800, 1600, 3200, 6400, 12800};
    
    System.out.printf("finding duplicates\n");
    System.out.printf("%7s %8s %8s %8s\n", "n", "linear", "binary", "pointer");

    for (int n : size2){
    double min = Double.POSITIVE_INFINITY;

      int[] unsortedarray1 = unsorted(n);
      int[] unsortedarray2 = unsorted(n);
      int[] sortedarray1 = sorted(n);
      int[] sortedarray2 = sorted(n);

      System.out.printf("%d", n);

      for(int i = 0; i < k; i++){
        long t0 = System.nanoTime();
        time_linear(sortedarray1, sortedarray2, 100);
        long t1 = System.nanoTime();
        double t = (t1 - t0);
        if(t < min){
            min = t; 
        }
      }

      System.out.printf(" %8.0f\t", (min/loop));

        min = Double.POSITIVE_INFINITY;

        for(int i = 0; i < k; i++){
        long t0 = System.nanoTime();
        time_binary(sortedarray1, sortedarray2, 100);
        long t1 = System.nanoTime();
        double t = (t1 - t0);
         if(t < min){
            min = t; 
        }
      }

      System.out.printf(" %8.0f", (min/loop));

      min = Double.POSITIVE_INFINITY;

      for(int i = 0; i < k; i++){
        long t0 = System.nanoTime();
        time_pointer(sortedarray1, sortedarray2, 100);
        long t1 = System.nanoTime();
        double t = (t1 - t0);
        if(t < min){
            min = t;
        }
      }

      System.out.printf(" %8.0f\n", (min/loop));
    }

}
}

