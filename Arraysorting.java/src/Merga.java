public class Merga {

    public static void sort(int[] org) {
        if (org.length == 0)
           return;
        int[] aux = new int[org.length];
        sort1(org, aux, 0, org.length -1);
    }

    private static void sort1(int[] org, int[] aux, int lo, int hi) {
            if (lo != hi) {
            int mid = (lo + hi)/2;
            // sort the items from lo to mid
            sort1(org, aux, lo, mid);
            // sort the items from mid+1 to hi
            sort1(org, aux, mid + 1, hi);
            // merge the two sections using the additional array
            merge(org, aux, lo, mid, hi);
            }
        }

    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
            // copy all items from lo to hi from org to aux
            for ( int i = lo; lo <= hi; lo++) {
                aux[i] = org[i]; 
        }
        // let's do the merging
        // the index in the first part
        int i = lo; 
        // the index in the second part
        int j = mid+1; 
        // for all indices from lo to hi
        for ( int k = lo; k <= hi; k++) {
        // if i is greater than mid then
        // move the j'th item to the org array, update j
        if(i > mid){
            org[k] = aux[j++];
        }

        // else if j is greate than hi then
        // move the i'th item to the org array, update i
        else if(j > hi){
            org[k] = aux[i++];
        }

        // else if the i'th item is smaller than the j ̈ath item, 
        // move the i'th item to the org array, update i
        else if( aux[i] < aux[j]){
            org[k] = aux[i++];
        }
        
        // else 
        // move the j'th item to the org array, update j
        else{
            org[k] = aux[j++];
        }

        } 
    }

    
}
