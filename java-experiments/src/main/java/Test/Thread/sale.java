package Test.Thread;

public class HelloRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("线程任务:说Hello");
    }
}
