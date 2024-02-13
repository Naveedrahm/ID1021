public class Paths {
    City[] path;
    int sp;
    public Paths() {
        path = new City[54];
        sp = 0;
    }

    public void main(String[] args) {
        Map map = new Map("/Users/naveedrahman/Algoritmer och Datastruktur /Graph.java/src/trains.csv");
        String from = "Malmö";
        String to = "Stockholm";

        Integer max = 300;
        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0)/1_000_000;
        System.out.println("shorest: " + dist + " min (" + time + " ms)");
    }

    private Integer shortest(City from, City to, Integer max) {

        if (max < 0)
            return null;
        if (from == to)
            return 0;

        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
                return null;
        }
        path[sp++] = from;

        Integer shrt = null;
        for (int i = 0; i < from.neighbours.length; i++) {
            if (from.neighbours[i] != null) {
                Connection conn = from.neighbours[i];
                Integer dist = shortest(from.neighbours[i].city, to, max - conn.distance);
                if (dist != null){
                    dist += conn.distance;
                    if (shrt == null || dist < shrt)
                        shrt = dist;
                    if (max > shrt && (shrt != null))
                        max = shrt;
                }
            }
        }

        path[sp--] = null;
        return shrt;
    }
}
