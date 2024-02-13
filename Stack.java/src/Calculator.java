

public class Calculator {

    item[] expr;
    int ip;
    Stack stack;

    public Calculator(item[] expr) {
        this.expr = expr;
        this.ip = 0;
        this.stack = new dynamic();
    }

    /* run function */
    public int run() {
        
        while ( ip < expr.length ) {  
            step(); 
        }
        return stack.pop();
    }
    
    public void step() {
        item nxt = expr[ip++];

        switch(nxt.type()) {
            /*start by popping the pushed values then the operation*/
            /*addition*/
            case ADD : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);
                break;
            }

            /*subtraction*/
            case SUB : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push( x - y );
                break;

            }

            /*multiplication*/
            case MUL : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x * y);
                break;
            }

            /*division*/
            case DIV : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push( x / y);
                break;
            }

            /*push the value to the stack*/
            case VALUE : {
                stack.push(nxt.value()); 
                break;
            }
        }
    }

}
        