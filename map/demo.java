package map;

import java.util.HashMap;
import java.util.Map;

public class demo {
    public static void main(String[] args) {
        Map<String,Integer> students = new HashMap<>();
        students.put("nme", 30);
        students.put("Ze", 33);
        students.put("tanit", 45);
        students.put("Kim data", 12);
        students.put("Eang Keng", 3);
        students.put("Yea Leang", 12);
        System.out.println(students.get("nme"));
        System.out.println(students.keySet());
        for(String item : students.keySet()){
            System.out.println(item+"  :  "+students.get(item));
        }
    }
}
