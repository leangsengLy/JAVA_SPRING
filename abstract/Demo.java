abstract class Car{
    public abstract void drive();
    public abstract void fly();
    public void play(){
        System.out.println("I wanna play pron and watch with you baby!");
    }
}
abstract class WagonR extends Car {
    public void drive() {
        System.out.println("the of the  drive");
    }
}
class updateWagonR extends WagonR {
    @Override
    public void fly() {
        System.out.println("Update WagonR .......");
    }
    
}
class Demo{
    public static void main(String a[]){
        Car aa = new updateWagonR();    
        aa.drive();
        aa.play();        
        aa.fly();        

    }
}