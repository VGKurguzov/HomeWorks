import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String in = scr.nextLine();
        Stack<Integer> stack = new Stack<>();
        int n1=0, n2=0, res=0;
        for(int i = 0; i<in.length(); ++i){
            char el = in.charAt(i);
            if(el >= '0' && el <= '9'){
                stack.push(Character.getNumericValue(el));
            }else{
                n1=stack.pop();
                n2=stack.pop();
                switch(el) {
                    case '+': res = n2 + n1; break;
                    case '-': res = n2 - n1; break;
                    case '*': res = n2 * n1; break;
                    case '/': res = n2 / n1; break;
                    default: System.out.println("Incorrect string");
                }
                stack.push(res);
            }
        }
        System.out.println(stack.peek());
    }
}
