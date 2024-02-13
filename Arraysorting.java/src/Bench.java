import java.util.Random;

public class Bench {
    
    private static int[] makearray(int k){
        // int [] sizes = {0, 1, 2, 4, 8, 16};

        Random rnd = new Random();
        int[] array = new int[k];



        // for(int n : sizes){
        //    int[] array = new int[n];
          for(int i = 0; i < k; i ++){
               array[i] = rnd.nextInt(k*10);
          }
          return array;
    }

    public static void main (String[] arg){
/* Bench för hur lång tid det tar för alla */

System.out.printf("%7s%8s%8s%8s%8s\n", "n", " Selection ", " insertion","\tmerge", " difference");
int[] sizes = {1000, 2000, 4000, 6000, 8000, 10000, 12000, 14000, 16000};

for(int n : sizes){

    System.out.printf("%8d", n);

    int k = 10;
    int loop = 10;
    int[] array = makearray(n);

    double minS = Double.POSITIVE_INFINITY;

    for(int i = 0; i < k; i++){
        double t0 = System.nanoTime();
        for(int j = 0; j < loop; j++){
            int[] copy = array.clone();
            Selection.selection(copy);
        }
        double t1 = System.nanoTime();
        double t = (t1 - t0);
        if(t < minS){
            minS = t;
        }
    }
    System.out.printf("%8.0f", (minS/(loop*1000)));

    double minI = Double.POSITIVE_INFINITY;

    for(int i = 0; i < k; i++){
        double t0 = System.nanoTime();
        for(int j = 0; j < loop; j++){
            int[] copy = array.clone();
            Selection.insertion(copy);
        }
        double t1 = System.nanoTime();
        double t = (t1 - t0);
        if(t < minI){
            minI = t;
        }
    }
    System.out.printf("%8.0f", (minI/(loop*1000)));

    double minM = Double.POSITIVE_INFINITY;

    for(int i = 0; i < k; i ++){
        double t0 = System.nanoTime();

        for(int j = 0; j < loop; j++){
            int[] copy = array.clone();
            Merga.sort(copy);
        }

        double t1 = System.nanoTime();
        double t = (t1 - t0);

        if(t < minM){
            minM = t;
        }
    }
    System.out.printf("\t%8.0f", minM/(loop*1000));

    System.out.printf("%8.2f\n", minI/minS);

    }

 }

    /* utskriften till att se sorteringen arrays */
    //     int [] sizes = {0, 1, 2, 4, 8, 16};
    //     Random rnd = new Random();

    //     for(int n : sizes){
    //         int[] array = new int[n];
    //         for(int i = 0; i < n; i ++){
    //             array[i] = rnd.nextInt(n*10);
    //         }
    //         // Selection.selection(array);
    //         // Selection.insertion(array);
    //         // Merga.sort(array);
    //         print(array);
        
    //     }
        

    // } 

    private static void print(int[] array){
        if(array.length == 0){
            System.out.println("[]");
        }
        else if(array.length == 1){
            System.out.println("[ " + array[0] + " ]");
        }
        else{
            System.out.print("[ " + array[0] + ", ");
            for(int i = 1; i < array.length - 1; i++){
            System.out.print(array[i] + ", ");
                
        }
        System.out.println(array[array.length - 1] + " ]");
    }
      
    }


}
