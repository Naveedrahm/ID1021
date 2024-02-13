import java.util.Random;

public class Bench {
    public static void main(String[] args){
    
        //    Random rnd = new Random();
   
        //    BinaryTree genTree = BinaryTree.genRand(size);
   
           int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400, 12800};
        for(int i : sizes){
            benchmark(i, 10000);
        }
    }

     public static void benchmark(int treeSize, int loops){
            Random rnd = new Random();

            BinaryTree newtree = genRand(treeSize);

            double min = Double.POSITIVE_INFINITY;
            double max = 0;
            double sum = 0;

            int temporarykey = rnd.nextInt(treeSize);
            // int value = rnd.nextInt(temporarykey);

            // for(int i = 0; i < loops; i++){
            //     int key = rnd.nextInt(treeSize);
            //     double start = System.nanoTime();
            //     newtree.add(temporarykey, value);
            //     double stop = System.nanoTime();
            //     double time = (stop - start);
               
            //     if(time < min){
            //         min = time;
            //     }
            //     if(time > max){
            //         max = time;
            //     }
            //  sum += time;   
            // }
            // System.out.printf("Size: %7d\t Min: %8.2f\t Avg: %8.2f\t Max: %8.2f\n", treeSize, min, (sum/loops), max);

            for(int i = 0; i < loops; i++){
                double start = System.nanoTime();
                for(int j = 0; j < 100; j++){
                    int key = rnd.nextInt(treeSize);
                    newtree.lookup(key);
                }
                double stop = System.nanoTime();
                double time = (stop - start);
               
                if(time < min){
                    min = time;
                }
                if(time > max){
                    max = time;
                }
             sum += time;   
            }
            System.out.printf("Size: %7d\t Min: %8.2f\t Avg: %8.2f\t Max: %8.2f\n", treeSize, (min/10), (sum/loops), max);
        }
    
        public static BinaryTree genRand(int size){
            Random rnd = new Random();
            BinaryTree generated = new BinaryTree();

            for(int i = 0; i < size; i++){
                generated.add(rnd.nextInt(size), rnd.nextInt(size));
            }
             return generated;
        } 
}