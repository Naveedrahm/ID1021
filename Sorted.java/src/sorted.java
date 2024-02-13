public class sorted {
    
    public static boolean search_sorted(int[] array, int key) {
        for(int index = 0; index < array.length; index++){
            if(array[index] == key){
                //if(array[index] == key)
                return true;
            }
            else if(array[index] > key){
            return false;
            }
        }
        return false;
  }
    //kolla om den är större än key då finns den inte
    //om nästa index är mindre än förra returnerar den false. 
    //FIXA DETTA.
}