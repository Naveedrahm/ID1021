public class ArrayHeap {
    Integer[] root;
    int size; 
    int pos = 0; 

    public ArrayHeap(int el){
        root = new Integer[el];
        size = el - 1; 
    }

    // find the root of each branches 
    public int root_branch(int pos){
        int holdroot_branch; 
        if(pos % 2 == 0){
            if((pos-2)/2 >= 0){
                holdroot_branch = (pos - 2)/2;
            }
            else {
                holdroot_branch = 0;
            }
        }
        else{
            holdroot_branch = (pos - 1)/2;
        }
        return holdroot_branch;
    }

    // add an item 
    public void add(int el){
        int holder; 
        if(pos == size){
            return;
        }
        else if(root[0] == null){
            root[0] = el;
            return;
        }
        else{
            holder = ++pos; 
            root[pos] = holder;
        }
        // the exhange if the adding element is higher priority than the previous roots
        while(holder > 0 && root[holder] < root[root_branch(holder)]){
            Integer rootholder = root[holder];
            root[holder] = root[root_branch(holder)];
            root[root_branch(holder)] = rootholder;
            holder = root_branch(holder);
        }
    }

    // sink the array if there is a null index at the end
    public void sink(){
            int ps = 0; 
            int left = (2*ps) + 1; 
            int right = (2*ps) + 2; 
            Integer currentHolder; 

            while(((root[right] != null && pos > 2) && root[left] != null) && (root[ps] > root[left]|| root[ps] > root[right])){
                if(root[left] > root[right]){
                    currentHolder = right;
                }
                if(root[right] > root[left]){
                    currentHolder = left; 
                }
                Integer tempo = root[currentHolder];
                root[currentHolder] = root[ps];
                root[ps] = tempo;

                ps++;
                left = (2*ps) + 1;
                right = (2*ps) + 2;
            } 

            if((pos == 2 && root[right] == null) && (root[ps] > root[left])){
                int tmp = root[left];
                root[left] = root[ps];
                root[ps] = tmp;
            }
    }
    // remove an item
    public Integer remove(){
        if(pos == 0){
            return null;
        }
        else{
            int value = root[0];
            root[0] = root[--pos];
            root[pos] = null;
            
            int ps = 0; 
            int left = (2*ps) + 1; 
            int right = (2*ps) + 2; 
            int holder = 0; 
            
            while((root[right] != null) && (root[ps] > root[left]) || root[ps] > root[right]){
                if(root[left] > root[right]){
                    holder = right;
                }
                else if(root[left] >= root[right]){
                    holder = left; 
                }
                
                // the swap 
                Integer atemp = root[holder];
                root[holder] = root[ps];
                root[ps] = atemp;
                
                ps++;
                left = (2*ps) + 1; 
                right = (2*ps) + 2;
            }
            return value;
        }
    }


    // push 
    public static void main(String[] args) throws Exception {
       
    }
}
