public class Naive {

    private static Integer shortest(City from, City to, Integer maxvalue){
        if(maxvalue < 0){
            return null;
        }
        if(from == to){
            return 0; 
        }
        Integer shrt = null; 
        for(int i = 0; i < from.neighbours.length; i++){
            if(from.neighbours[i] != null){
                // System.out.println("HEHEHEHEHEH");
                Connection conn = from.neighbours[i];
                Integer dist = shortest(from.neighbours[i].city, to, maxvalue - conn.distance);
                if(dist != null){
                    dist = dist + conn.distance;
                    if(shrt == null || dist < shrt){
                        shrt = dist;
                    }
                }
            }
        }
        return shrt;
    }
   

    public static void main(String[] args){
        Map map = new Map("/Users/naveedrahman/Algoritmer och Datastruktur /Graph.java/src/trains.csv");

        String from = "Malmö";
        String to = "Stockholm";
        Integer max = 400;

        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0)/1_000_000;

        System.out.println("shortest: " + dist + " min (" + time + ")");
    }
}
