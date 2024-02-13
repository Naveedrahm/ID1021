import java.io.BufferedReader;
import java.io.FileReader;

public class ZipHash {
    Node[] data;
    int max;
    int size = 38203; 

    public class Node{
        Integer code; // The zip code
        String name; // The name of the place
        Integer pop; // The population of that place
        Node next;

        public Node(Integer cod, String nam, Integer po){
            code = cod;
            name = nam; 
            pop = po;
        }
    }

    public ZipHash(String file){
        data = new Node[10000];

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line; 
            int i = 0; 
            while((line = br.readLine()) != null){
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                Node post = new Node(code, row[1], Integer.valueOf(row[2]));
                insert(post);
            }
            max = i-1;
        } catch (Exception e){
            System.out.println(" file " + file + " not found!");
        }
    }
    public void insert(Node inser){
        int index = hashCode(inser.code);
        Node current = data[index];
        if(current == null){
            data[index] = inser;
        }
        else{
            inser.next = current.next;
            current.next = inser;
        }
    }

    public String lookup(Integer key){
        int index = hashCode(key);

        if(data[index] == null){
            return "NO value";
        }
        if(data[index].code.equals(key)){
            return data[index].name;
        }
        else{
            Node current = data[index];
            while(current.next != null){
                if(current.code.equals(key)){
                    return current.name;
                }
                current = current.next;
            }
            return "NO value";
        }
    }
    public int hashCode(Integer key){
        return key % size;
    }
    public static void main(String[] args){
        ZipHash tst = new ZipHash("/Users/naveedrahman/Algoritmer och Datastruktur /Hash.java/src/postnummer.csv");
        // Boolean tmp = tst.("123 42");
        // int farsta = 12342%size;

        System.out.println(tst.lookup(12342));
    }
}
