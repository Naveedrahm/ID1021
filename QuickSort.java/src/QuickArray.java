
import java.util.Random;

public class QuickArray{
  
    public static int[][] generatRNDArray(int vals, int length){
        Random rnd = new Random();
        int[][] array = new int[vals][length];

        for(int i = 0; i < vals; i++){
            for(int j = 0; j < length; j++){
                array[i][j] = rnd.nextInt(length*10);
            }
        }
        return array;
    }

    public static void quickSortArray(int[] array, int lowLVals, int highLVals){
        if(lowLVals < highLVals){
            int pivotVals = array[highLVals];
            int pivot = lowLVals - 1; 

            for(int i = lowLVals; i < highLVals; i++){
                if(array[i] <= pivotVals){
                    pivot ++; 
                    swap(array, pivot, i);
                }
            }
            swap(array, pivot + 1, highLVals);
            quickSortArray(array, lowLVals, (pivot - 1));
            quickSortArray(array, (pivot + 1), highLVals);
        }
    }

    private static void swap(int[] array, int i, int j){

        int tempor = array[i];
        array[i] = array[j];
        array[j] = tempor;
    
    }

    public static int[][] copyArray(int[][] array){
        int[][] newArray = new int[array.length][array[0].length];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                newArray[i][j] = array[i][j];
            }
        }
        return newArray;
    }
}

