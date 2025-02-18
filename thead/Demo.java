package thead;

class Counter{
    public int count = 0;
    public void increment(){
        count=count+1;
    }
}
public class Demo{
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
            Runnable a = ()->{
                for(int i=0; i<1000; i++){
                    c.increment();
                    // System.out.println("Hi");
                    // try {
                    //     Thread.sleep(10);
                    // } catch (InterruptedException e) {
                    //     // TODO Auto-generated catch block
                    //     e.printStackTrace();
                    // }
                }
            };
            Runnable b = ()->{
                for(int i=0; i<1000; i++){
                    c.increment();
                    // System.out.println("Hi");
                    // try {
                    //     Thread.sleep(10);
                    // } catch (InterruptedException e) {
                    //     // TODO Auto-generated catch block
                    //     e.printStackTrace();
                    // }
                }
            };

           Thread t1= new Thread(a);
           Thread t2= new Thread(b);

           t1.start();
           t2.start();


           System.out.println(c.count);
    }
}