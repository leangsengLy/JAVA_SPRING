package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {
        Collection<Integer> nums = new ArrayList<Integer>();
        nums.add(20);
        nums.add(20);
        nums.add(20);
        nums.add(20);
        nums.add(20);
      
        Iterator<Integer> list = nums.iterator();
        while (list.hasNext()) {
            System.out.println(list.next());
        }

    }
}
