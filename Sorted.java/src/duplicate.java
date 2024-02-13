public class duplicate {
    /*public static boolean duplicateunsorted(int[] array1, int[] array2){
        
        // int[] dup1 = new int[n];
        // int[] dup2 = new int[n]; 
        
        for(int i = 0; i < array1.length; i++){
            for(int j = i + 1; j < array2.length;){
                if(array1[i] == array2[j]){
                    return true;
                }
                else {
                    j++;
                    return false;
                }
            }
        }
        return false;
    }*/
    
    /*
    public static boolean duplicatesorted(int n){
        int[] dupp1 = new int[n];
        int[] dupp2 = new int[n];

        for(int i = 0; i < dupp1.length; i++){
            for(int j = 0; j < dupp2.length; j++){
                if(dupp1[i] < dupp2[j]){
                    return false; 
                }
                if(dupp1[i] >= dupp2[j]){
                    return true;
                }
            }
        }
        return false;
    }*/

    // public static void dupsearch(int[] sortedarray1, int[] sortedarray2){
    //     for(int i = 0; i < sortedarray1.length; i++){
    //         Binary.binary_search(sortedarray2, sortedarray1[i]);
    //     }
    // }

    public static int duplinear(int[] array1, int[] array2){
        int counter = 0; 
        for(int i = 0; i < array2.length; i++){
            if(Linear.search(array1, array2[i])){
                counter++; 
            }
        }
        return counter;
    }

    public static int dupbinary(int[] array1, int[] array2){
        int counter = 0; 
        for(int i = 0; i < array2.length; i++){
            if(Binary.binary_search(array2, array2[i])){
                counter ++;
            }
        }
        return counter;
    }

    public static int duplicatepointer(int[]sortedarray1, int[] sortedarray2){
7

    /*public static double duplicatebinarybench(int sizearray1, int sizearray2){

        int[] sortedarray1 = Bench.sorted(sizearray1);
        int[] sortedarray2 = Bench.sorted(sizearray2);

        double sum = 0; 

        double min = Double.POSITIVE_INFINITY;
        for(int i = 0; i < 100_000; i++){
            long t0 = System.nanoTime();
            duplicatebinary(sortedarray1, sortedarray2);
            long t1 = System.nanoTime();
            sum = (t1 - t0);
            if(sum < min){
                min = sum;
            }
        }
        return (double) sum;
    }*/

    /*public static double duplicateunsortedbench(int sizearray1, int sizearray2){

        int[] unsortedarray1 = Bench.unsorted(sizearray1);
        int[] unsortedarray2 = Bench.unsorted(sizearray2);
        double sum = 0; 

        for(int i = 0; i < 100_000; i++){
            long t1 = System.nanoTime();
            duplicateunsorted(unsortedarray1, unsortedarray2);
            sum += (System.nanoTime() - t1);
        }
        return sum / (100_000);
    }*/

    /*public static double duplicatebinarybench(int sizearray1, int sizearray2){
        int[] binaryarray1 = Bench.sorted(sizearray1);
        int[] binaryarray2 = Bench.sorted(sizearray2);
        double sum = 0; 

        for(int i = 0; i < 100_000; i++){
            long t1 = System.nanoTime();
            Bench.binary(binaryarray1, binaryarray2);
            sum += (System.nanoTime() - t1);
        }
        return sum /(100_000);
    }*/
}
