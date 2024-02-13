public class Selection {
   
private static void swap(int[] array, int i, int j){

    int tempor = array[i];
    array[i] = array[j];
    array[j] = tempor;

}

public static void selection(int[] array){

    for (int i = 0; i < array.length - 1; i++) {
        int candidate = i;
        for (int j = i; j < array.length ; j++) {
            if(array[candidate] > array[j]){
                candidate = j;
                }
            }
            swap(array, i, candidate);
        }
    }

public static void insertion(int[] array){

    int min;
    int j;
    for (int i = 1; i < array.length; i++) {
        min = array[i];
        j = i - 1;
        // Compare key with each element on the left of it until an element smaller than
        // it is found.
        while (j >= 0 && min < array[j]) {
            array[j + 1] = array[j]; // move elements to the right in the array
            j--;
        }
        array[j + 1] = min;
    }
    //  for(int i = 0; i < array.length; i++){
    //      for(int j = i - 1; j >= 0 && array[i] < array[j]; j--){
    //         //  array[j + 1] = array[i - 1];
    //          swap(array, i, j);
    //          }
    //         }
    //   }
    }
}