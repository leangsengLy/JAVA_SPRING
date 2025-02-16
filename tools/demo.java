package tools;
import acess_modifier.*;
class A {
    public void show(){
        System.out.println("A show");
    }
}
class B extends A{
    public void show(){
        System.out.println("B show");
    }
}
class C extends A{
    public void show(){
        System.out.println("C show");
    }
}

public class demo {
    public static void main(String a[]){
        A aa = new A();
        aa.show();

        aa = new B();
        aa.show();

        aa = new C();
        aa.show();
    }
}
