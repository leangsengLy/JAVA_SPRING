package overidding;
class A{
    public void display(){
        System.out.println("display on A");
    }
}
class B extends A{
    public void display(){
        System.out.println("display on B");
    }
}
public class anotation {
    public static void main(String[] args) {
        B b = new B();
        b.display();
    }
}
