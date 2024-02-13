import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    public City[] cities;
    private final int mod = 541;
    
    public Map(String file){
        cities = new City[mod];
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line; 
            while((line = br.readLine()) != null){
                String[] row = line.split(",");
                String MAIN = row[0];
                String city = row[1];
                Integer dist = Integer.parseInt(row[2]);

                lookup(MAIN).connect(lookup(city), dist);
            }
        }catch (Exception e){
            System.out.println("\n The file " + file + " not found or corrupt");
        }
    }

    public Integer hash(String name){
        int hash = 0;
        for(int i = 0; i < name.length(); i++){
            hash = (hash*31 % mod) + name.charAt(i);
        }
        return hash%mod;
    }

    public City lookup(String name){
        int index = hash(name);
        for(int i = index; i < cities.length; i++){
            if(cities[i] == null){
                cities[i] = new City(name);
                return cities[i];
             }
             else if(cities[i].name.equals(name)){
                return cities[i];
             }
        }
        for(int i = 0; i < index; i++){
            if(cities[i] == null){
                cities[i] = new City(name);
                return cities[i];
            }
            else if(cities[i].name.equals(name)){
                return cities[i];
            }
        }
        return null;
    }

}
