import java.util.Stack;

public class GameStack {
    private static volatile Stack<Integer> gameStack = new Stack<>();

    public static void incrementStack(int number){
        gameStack.push(number);
    }

    public static int dicrementStack(){
        if (!gameStack.empty())
            return gameStack.pop();
        return -1;
    }

    public static boolean isEmpty(){
        return gameStack.empty();
    }

    public static int lastElemStack(){
        if (!gameStack.empty())
            return gameStack.peek();
        return -1;
    }
    public static String print(){
        if(gameStack.empty())
            return "[]";
        int num = gameStack.search(0);
        StringBuilder sb= new StringBuilder();
        sb.append("[");
        for (int i = 0; i < num; i++) {
            sb.append(i+" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
