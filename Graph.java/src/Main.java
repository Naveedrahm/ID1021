public class Main {
    public static void main(String[] args){
        Map map = new Map("/Users/naveedrahman/Algoritmer och Datastruktur /Graph.java/src/trains.csv");
        // System.out.println(map.cities[map.hash("Stockholm")].name);
         int i = 0; 
         while(map.cities[map.hash("Stockholm")].neighbours[i] != null){
            // System.out.println("TEST IF WE GET INSIDE");
            System.out.println(map.cities[map.hash("Stockholm")].neighbours[i].city.name);
            i++;
         }
    }
}
