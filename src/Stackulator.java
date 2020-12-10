import java.util.Scanner;

public class Stackulator {
    public void Stackulator() {

        // create two stacks
            // one for operations
            // one for values
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        // read in input
        Scanner myScanner = new Scanner(System.in);
        // split each character of input, ready for iteration
        String[] tokens = myScanner.nextLine().split(" ");


        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].equals("(")) ; // do nothing if first character is "("

            else if (tokens[i].equals("+")) { // push to operator stack
                ops.push(tokens[i]);
            }
            else if (tokens[i].equals("-")) { // push to operator stack
                ops.push(tokens[i]);
            }
            else if (tokens[i].equals("*")) { // push to operator stack
                ops.push(tokens[i]);
            }
            else if (tokens[i].equals("/")) { // push to operator stack
                ops.push(tokens[i]);
            }
            else if (tokens[i].equals("sqrt")) { // push to operator stack
                ops.push(tokens[i]);
            }
            else if (tokens[i].equals("%")) { // push to operator stack
                ops.push(tokens[i]);
            }
            else if (tokens[i].equals("e^")) { // push to operator stack
                ops.push(tokens[i]);
            }
            else if (tokens[i].equals(")"))  { // if ")" pop, then evaluate, then push
                String op = ops.pop(); // pop operator
                double v = vals.pop(); 

                if (op.equals("+")) {
                    v = vals.pop() + v;
                }

                else if (op.equals("-")) {
                    v = vals.pop() - v;
                }
                else if (op.equals("*")) {
                    v = vals.pop() * v;
                }
                else if (op.equals("/")) {
                    v = vals.pop() / v;
                }
                else if (op.equals("sqrt")) {
                    v = Math.sqrt(v);
                }
                else if (op.equals("%")) {
                    v = vals.pop() % v;
                }
                else if (op.equals("e^")) {
                    v = Math.exp(v);
                }
                vals.push(v); // push value to value stack
            } else
                vals.push(Double.parseDouble(tokens[i]));
        }
        System.out.println(vals.pop()); // print the top value on stack
    }
}
