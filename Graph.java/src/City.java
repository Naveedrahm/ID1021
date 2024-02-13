public class City {
   String name; 
   Connection[] neighbours; 
   
   public City(String name){
       this.name = name; 
       neighbours = new Connection[51];
    }
    
    public void connect(City nxt, Integer dst){
       Connection theConnection = new Connection(nxt, dst);
        for(int i = 0; i < neighbours.length; i++){
            if(neighbours[i] == null){
                neighbours[i] = theConnection;
                break; 
            }
        }
   }

}
