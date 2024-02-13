import java.io.BufferedReader;
import java.io.FileReader;

public class ZipIntegers {  
    Node[] data;
    int max; 
    Integer[] keys;

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

    public ZipIntegers(String file){
        data = new Node[10000];
        keys = new Integer[10000];

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line; 
            int i = 0; 
            int j = 0;
            while((line = br.readLine()) != null){
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                keys[j++] = code;
                data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e){
            System.out.println(" file " + file + " not found!");
        }
    }
    public boolean linear(Integer zip){
        for(int i = 0; i < data.length; i++){
            if(data[i] == null){
                break;
            }
            if(data[i].code.equals(zip)){
                return true;
            }
        }
        return false;
    }

    public boolean binary(Integer zip){
        int first = 0;
        int last = max; 

        while(true){

            int middle = (last + first)/2;

            if(data[middle] == null){
                return false; 
            }
            if(data[middle].code.equals(zip)){
                return true;
            }
            if(Integer.compare(data[middle].code, zip) < 0 && middle < last){ //csv filen är sorterad med numerena och ifall mitten är innan zip så ligger zip i den större halvan
                first = middle + 1;
                continue;
            }
            if(Integer.compare(data[middle].code, zip) > 0 && middle > first){ // ifall middle > zip innebär det att zip är i den mindre halvan
                last = middle - 1;
                continue;
            }
            break; 
        }
        return false;
    }

    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
}
        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }
    public static void main(String[] args){
        ZipIntegers tst = new ZipIntegers("/Users/naveedrahman/Algoritmer och Datastruktur /Hash.java/src/postnummer.csv");
        Boolean tmp = tst.binary(12342);

        System.out.println(tmp);

        tst.collisions(10000);
        tst.collisions(20000);
        tst.collisions(30000);
        // tst.collisions(12342);
        // tst.collisions(12345);
        tst.collisions(13513);
        tst.collisions(13600);
        // tst.collisions(14000);
    }
}


