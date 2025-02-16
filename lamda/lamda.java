package lamda;
@FunctionalInterface
interface A {
    void show();
} 
public class lamda {
    public static void main(String[] args) {
        A aa = ()-> System.out.println("hello world");
        aa.show();
    }
}
