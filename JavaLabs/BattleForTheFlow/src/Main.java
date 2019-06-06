import java.util.Scanner;

public class Main {
    public static final int TIMER = 1000;
    private static int capacity;
    private static EnemyThread enemyThread = new EnemyThread();
    private static Scanner scanner = new Scanner(System.in);
    private static volatile int tmp;

    public static void main(String[] args) {
        System.out.println("размер стека:");
        capacity = scanner.nextInt();
        System.out.println("Начали!");
        while(true){
            if(scanner.hasNextInt()){
                tmp = scanner.nextInt();
                if(tmp == 0){
                    GameStack.incrementStack(tmp);
                    System.out.println("Было введено число "
                            + GameStack.lastElemStack() + " : " + GameStack.print());
                    break;
                }else{
                    System.out.println("Вы ввели неверное число. Повторите попытку");
                }
            }
        }
        enemyThread.start();

        while(true){
            if(scanner.hasNextInt()){

                EnemyThread.reentrantLock.lock();
                check();
                tmp = scanner.nextInt();
                if((GameStack.lastElemStack()+1) == tmp){
                    GameStack.incrementStack(tmp);
                    System.out.println("Было введено число " + tmp + "\n" + GameStack.print());
                }else{
                    System.out.println("Вы ввели неверное число. Повторите попытку");
                }
                check();
                EnemyThread.reentrantLock.unlock();

            }else{
                System.out.println("Данные не являются числом. Повторите попытку");
            }
        }
    }

    public static void check(){
        if(GameStack.isEmpty()){
            System.out.println("Враг победил!");
            System.exit(0);
        }
        if(GameStack.lastElemStack() == capacity){
            System.out.println("Игрок победил!");
            System.exit(0);
        }
    }
}

