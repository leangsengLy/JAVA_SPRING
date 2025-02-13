package Basic;
class Calculator{
    public int add(int a, int b){
        return a + b;
    }
}

class Humen {
    private int age ;
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
    
}
class hello{
    public static void main(String a[]){
        // int num1 = 20;
        // int num2 = 30;
        // byte by = 127;
        // short sh = 556;

        // long l =12313l;
        // float f = 6.5f;
        // double d = 5.4;
        // char c = 'k';
        // boolean b = true;
        // int result= num1 + num2;
        // System.out.println("Hello world Mr leangseng");
        // System.out.println(result);

        // int i=0;
        // while(i<=10){
        //     System.out.println("Hello world "+i);
        //     i++;
        // }
        // System.out.println("Hi");

        Calculator bew = new Calculator();

        System.out.println(bew.add(5,6));;


        int number[] = {1,2,3,4,5,6};
        for(int num : number){
            System.out.println(num);
        }
    }
}