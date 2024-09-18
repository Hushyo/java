package Test.Thread;

public class sale implements Runnable{

    static int total=200;
    int current=0;
    public int getTotal(){
        return total;
    }

    int saleTicket(){
        if(current<total){
            current+=1;
            System.out.println("第"+current+"张");
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            return current;
        }
        else return -1;
    }


    @Override
    public void run(){
        while(true){
            synchronized (this){
                int sales=saleTicket();
                if (sales>=total||sales==-1)break;
            }
        }
    }
}
