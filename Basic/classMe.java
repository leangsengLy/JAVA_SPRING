package Basic;
class ObjectTest {
    private int age;
    private String name;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    void show(){
        System.out.println("Fuc k  you bitch");
    }
    
}

class classMe{
    public static void main(String a[]){
            new ObjectTest().show();
    }
}
