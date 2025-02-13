package Basic;
import backpage.AdvCalc;

class Demo {
    public static void main(String a[]){
        AdvCalc a1 = new AdvCalc();
        int result = a1.add(10, 20);
        int result1 = a1.sum(10, 2);
        int result3 = a1.devi(10, 2);
        int result4 = a1.miti(10, 2);
        System.out.println(result);
        System.out.println(result4);
        System.out.println(result3);
        System.out.println(result1);
    }
}
