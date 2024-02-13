public class Bench {
    public static void main(String[] args){
        
        String[] stringNumbers = { "111 15" , "984 99"};
        Integer[] integerNumbers = {11115, 98499};
        Integer[] keyIndex = {11115, 98499, 12342};
        
        int loops = 10000; 
        
        double min;
        
        System.out.println("# Binary search vs Linear search");
        System.out.printf("#7s\t%9s\t%9s\t%9s\t\n", "LOOKING for: ", "Linear: ", "Binary: ");
        
        Zip fil = new Zip("/Users/naveedrahman/Algoritmer och Datastruktur /Hash.java/src/postnummer.csv");
        for(String n : stringNumbers){
            System.out.printf("\t%8s" + "-> " + "\t", n);
            
            min = Double.POSITIVE_INFINITY;
            
            for(int i = 0; i < loops; i++){
                double t0 = System.nanoTime();
                fil.linear(n);
                double t1 = System.nanoTime();
                double t = (t1 - t0);
                if( t < min){
                    min = t;
                }
            }
            System.out.printf("%8s" + "\t", min);
            
            min = Double.POSITIVE_INFINITY;
            for(int i = 0; i < loops; i++){
                double t0 = System.nanoTime();
                fil.binary(n);
                double t1 = System.nanoTime();
                double t = (t1 - t0);
                if( t < min){
                    min = t;
                }
            }
            System.out.printf("%8s" + "\n", min);
        }
        
        System.out.printf("//////////////////////////////////////////////////////\n");
        ZipIntegers fil1 = new ZipIntegers("/Users/naveedrahman/Algoritmer och Datastruktur /Hash.java/src/postnummer.csv");
        
        for(Integer n : integerNumbers){
            System.out.printf("\t%8s" + "-> " +  "\t", n);
            
            min = Double.POSITIVE_INFINITY;
            
            for(int i = 0; i < loops; i++){
                double t0 = System.nanoTime();
                fil1.linear(n);
                double t1 = System.nanoTime();
                double t = (t1 - t0);
                if( t < min){
                    min = t;
                }
            }
            System.out.printf("%8s" + "\t", min);
            
            min = Double.POSITIVE_INFINITY;
            for(int i = 0; i < loops; i++){
                double t0 = System.nanoTime();
                fil1.binary(n);
                double t1 = System.nanoTime();
                double t = (t1 - t0);
                if( t < min){
                    min = t;
                }
            }
            System.out.printf("%8s" +  "\n", min);
        }
        
        System.out.printf("//////////////////////////////////////////////////////\n");
        ZipWIndex fil2 = new ZipWIndex("/Users/naveedrahman/Algoritmer och Datastruktur /Hash.java/src/postnummer.csv");
        
        for(Integer n : keyIndex){
            System.out.printf("\t%8s" + "-> " +  "\t", n);
            
            min = Double.POSITIVE_INFINITY;

            for(int i = 0; i < loops; i++){
                double t0 = System.nanoTime();
                fil2.linear(n);
                double t1 = System.nanoTime();
                double t = (t1 - t0);
                if( t < min){
                    min = t;
                }
            }
            System.out.printf("%8s" + "\n", min);
        }
    }
}
