package interfaces;

interface A{
    void show();
    void config();
}
interface X {
    void speak();
}
class B implements A,X{
    public void config() {
       System.out.println("display on Config");
    }
    public void show() {
        System.out.println("display on show");
        
    }
    public void speak() {
        System.out.println("I am speaking to you do you here me brother i want to kiss you so much! but sometime you did now so me back about you want and about something that you care about me!");
        
    }
}
public class Main {
        public static void main(String[] args) {
            B b = new B();
            b.config();
            b.show();
            b.speak();
        }
    }
