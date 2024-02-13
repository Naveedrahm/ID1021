public class BenchList {
    public static void main(String[] args){

        long start = System.nanoTime();
	    int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400, 12800, 512400};
		System.out.printf("those: # searching through an array of length n, time in ns\n");
		System.out.printf("#%4s%15s%15s\n", "n", "Array", "LinkedList");

		for ( int n : sizes) {
			System.gc();
			int loop = 1000;
			int k = 10;

			 int[][] RNDArray = QuickArray.generatRNDArray(loop, n);

			System.out.printf("%5d", n);

			Double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				int[][] arrays = QuickArray.copyArray(RNDArray);
				long t0 = System.nanoTime();
				for (int j = 0; j < loop; j++){
					QuickArray.quickSortArray(arrays[j], 0, (arrays[j].length - 1));;
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) {
                    min = t;
                }
			}
			System.out.printf("%10.3f(%3.1f)", (min/(loop)/1000000),((min/(loop))/(n*Math.log(n))));

			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				
                long t0 = System.nanoTime();
                QuickList[] copyList = QuickList.ListArray(RNDArray);
				for (int j = 0; j < loop; j++) {
                    copyList[j].sortLinked();
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) {
                min = t;
            }
				
			}
			System.out.printf("%10.3f(%3.1f)\n" , (min/(loop)/1000000),((min/(loop))/(n*Math.log(n))));
		}
		
    }
}
