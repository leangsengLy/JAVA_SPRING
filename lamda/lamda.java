package lamda;
@FunctionalInterface
interface A {
     int add(int a,int b);
} 
public class lamda {
    public static void main(String[] args) {
        A aa = (int a, int b)-> a+b;;
        A bb = new A() {
            public int add(int a, int b){
                return a+b;
            }
        };
        System.out.println(bb.add(20,330));
        System.out.println(aa.add(20,30));
    }
}
