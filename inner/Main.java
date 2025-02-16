package inner;

abstract class  A{
    public abstract void show();
    public abstract void fly();
}
public class Main {
    public static void main(String aa[]) {
            A a = new A(){
                    public void show(){
                        System.out.println("new A");
                    }
                    public void fly(){
                        System.out.println("new ffff");
                    }
            };
            a.fly();
            a.show();
    }
}

