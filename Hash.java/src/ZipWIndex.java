import java.io.BufferedReader;
import java.io.FileReader;


public class ZipWIndex {
    Node[] data;
    int min;
    int max; 
    // Integer[] key;
    public class Node{
        Integer code; // The zip code
        String name; // The name of the place
        Integer pop; // The population of that place

        public Node(Integer cod, String nam, Integer po){
            code = cod;
            name = nam; 
            pop = po;
        }
    }

    public ZipWIndex(String file){
        data = new Node[100000];
        // key = new Integer[10000];

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line; 
            // int i = 0; 
            // int j = 0;
            Integer code = 0;
            while((line = br.readLine()) != null){
                if(code.equals(0)){
                    String[] row = line.split(",");
                    code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                    min = code;
                    data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
                    code++;
                }
                else{
                    String[] row = line.split(",");
                    code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                    data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
                    code++;
                }
            }
            max = code-1;
            // System.out.println("FUNKADE");
        } catch (Exception e){
            System.out.println(" file " + file + " not found!");
        }
    }
    public boolean linear(Integer zip){
        if(data[zip] == null){
           return false;
        }
        if(data[zip].code.equals(zip)){
            return true;
        }
        else
        return false;
    }

    // public void collisions(int mod){
    //     int[] data = new int[mod];
    //     int[] cols = new int[10];

    //     for(int i = 0; i < max; i++){
    //         Integer index = key[i] % mod;
    //         cols[data[index]]++;
    //         data[index]++;
    //     }
    //     System.out.print(mod);
    //     for(int i = 0; i < 10; i++){
    //         System.out.print("\t" + cols[i]);
    //     }
    //     System.out.println();
    // }

    // public boolean binary(Integer zip){
    //     int first = 0;
    //     int last = max; 

    //     while(true){

    //         int middle = (last + first)/2;

    //         if(data[middle] == null){
    //             return false; 
    //         }
    //         if(data[middle].code.equals(zip)){
    //             return true;
    //         }
    //         if(Integer.compare(data[middle].code, zip) < 0 && middle < last){ //csv filen är sorterad med numerena och ifall mitten är innan zip så ligger zip i den större halvan
    //             first = middle + 1;
    //             continue;
    //         }
    //         if(Integer.compare(data[middle].code, zip) > 0 && middle > first){ // ifall middle > zip innebär det att zip är i den mindre halvan
    //             last = middle - 1;
    //             continue;
    //         }
    //         break; 
    //     }
    //     return false;
    // }

    public static void main(String[] args){
        ZipWIndex tst = new ZipWIndex("/Users/naveedrahman/Algoritmer och Datastruktur /Hash.java/src/postnummer.csv");
        Boolean tmp = tst.linear(12342);

        System.out.println(tmp);
    }
}

