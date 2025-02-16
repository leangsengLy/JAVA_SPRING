package Enums;

enum Status {
    Fail,Success,Error
};
public class Enums {
    public static void main(String[] args) {
        Status fa = Status.Success;
        System.out.println(fa);
        System.out.println(fa.ordinal());
        System.out.println("----------------------------------");
        Status[] stat = Status.values();
        for(Status Item : stat){
            System.out.println(Item);
        }
    }
    
}
