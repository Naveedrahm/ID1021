import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {
  
    Node[] data;
    int max; 

    public class Node{
        String code; // The zip code
        String name; // The name of the place
        Integer pop; // The population of that place

        public Node(String cod, String nam, Integer po){
            code = cod;
            name = nam; 
            pop = po;
        }
    }

    public Zip(String file){
        data = new Node[10000];

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line; 
            int i = 0; 
            while((line = br.readLine()) != null){
                String[] row = line.split(",");
                data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e){
            System.out.println(" file " + file + " not found!");
        }
    }
    public boolean linear(String zip){
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

    public boolean binary(String zip){
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
            if(data[middle].code.compareTo(zip) < 0 && middle < last){ //csv filen är sorterad med numerena och ifall mitten är innan zip så ligger zip i den större halvan
                first = middle + 1;
                continue;
            }
            if(data[middle].code.compareTo(zip) > 0 && middle > first){ // ifall middle > zip innebär det att zip är i den mindre halvan
                last = middle - 1;
                continue;
            }
            break; 
        }
        return false;
    }

    public static void main(String[] args){
        Zip tst = new Zip("/Users/naveedrahman/Algoritmer och Datastruktur /Hash.java/src/postnummer.csv");
        Boolean tmp = tst.binary("123 42");

        System.out.println(tmp);
    }
}
