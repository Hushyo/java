package Test;

public class User {
    public int id;
    @Override
    public String toString(){
        return new String("这是用户"+this.id);
    }
}
