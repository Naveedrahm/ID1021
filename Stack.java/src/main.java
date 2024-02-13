public class main {
    public static void main(String[] args) { 
        // 10 + 2 * 5
        // 10 2 5 * +   in reversed Polish notation
        item[] expr = {
            item.Value(10),
            item.Value(2),
            item.Value(5),
            item.Mul(),
            item.Add()
        };

        Calculator calc = new Calculator(expr);
        int res = calc.run();
        System.out.println(" Calculator: res = " + res);
    }
}
