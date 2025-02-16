class A{
    public int a=0;
    public void show(){
        System.out.println("it is show");
    }
    class B{
        public void config(){
            System.out.println("It si config");
        }
    }
    static class C{
        public void configC(){
            System.out.println("It si configC");
        }
    }
}

class Demo{
    public static void main(String[] args) {
            A a = new A();
            a.show();

            A.B aa = a.new B();
            aa.config();

            A.C cc = new A.C();
            cc.configC();
    }
}