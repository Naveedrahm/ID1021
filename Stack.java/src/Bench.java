public class Bench {
    public static void bench(int loop, int ops, Stack stack){
        for(int i = 0; i < loop; i++){
            for(int k = 0; k < ops; k++){
                stack.push(k);
            }
            for(int k = 0; k < ops; k++ ){
                stack.pop();
            }
        }
    }

    public static double time(int loop, int tries, int ops, Stack stack){
        double min = Double.POSITIVE_INFINITY;
        double sum = 0; 

        for(int i = 0; i < tries; i++){
            System.gc();
            double t0 = System.nanoTime();
            bench(loop, ops, stack);
            double t1 = System.nanoTime();
            double t = (t1 - t0);
            if(t < min){
                min = t;
                sum += t;
            }
        }
        return min;
    }

    static void bench(int ops){
        int tries = 10;
        int loop = 10000;

        statics stat = new statics(ops);
        
        time(loop*10, tries, ops, stat);

        dynamic dyna = new dynamic();
        time(loop*10, tries, ops, dyna);

        double stat_t = time(loop, tries, ops, stat);
        double dyna_t = time(loop, tries, ops, dyna);
        System.out.printf("%d\t%.2f\t %.2f\t %.2f\n", ops, (stat_t/(loop*1000)), (dyna_t/(loop*1000)), ((dyna_t/(loop*1000)) - (stat_t/(loop*1000))));
        // System.out.printf("%d\t%.2f\n",ops, (dyna_t/(loop*1000)));
    }

    public static void main(String[] arg){
        System.out.printf("#%s\t%s\n", "n", "stat");
        // System.out.printf("#%s\t%s\n", "n","stat");
        bench(25);
        bench(50);
        bench(100);
        bench(150);
        bench(200);
        bench(300);
        bench(400);
        bench(800);
        bench(1000);
    }
}

