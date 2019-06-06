import java.util.concurrent.locks.ReentrantLock;

public  class EnemyThread extends Thread {
    static volatile ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(Main.TIMER);
                reentrantLock.lock();
                actionEnemy();
                Main.check();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        }
    }

    public void actionEnemy(){
        System.out.println("Враг: я удалил у тебя верхний элемент из стека - "
                +GameStack.dicrementStack() + " : " + GameStack.print());
    }
}
