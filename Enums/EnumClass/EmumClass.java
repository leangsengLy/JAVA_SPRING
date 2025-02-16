package Enums.EnumClass;

enum Laptop{
    Macbook(1999),XPS(2000),ASUS(1888),SurFace(3000);
    private int price;
    
    private Laptop(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
public class EmumClass {
    public static void main(String[] args) {
        
        for(Laptop lap : Laptop.values()){
            System.out.println(lap+" : "+lap.getPrice());
        }
    }
}
