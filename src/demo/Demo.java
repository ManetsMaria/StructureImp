package demo;

import main.ArrayListImp;
import main.HashMapImp;
import main.LinkedListImp;

import java.util.List;
import java.util.Map;

public class Demo {

    public static void main(String[]args){

        List <String> linkedListImp = new LinkedListImp<>();
        linkedListImp.add("1");
        linkedListImp.add("2");
        linkedListImp.add("3");
        System.out.println(linkedListImp);
        System.out.println(linkedListImp.size());
        linkedListImp.remove("1");
        System.out.println(linkedListImp.get(0));

        Map <String, Integer> hashMapImp = new HashMapImp<>();
        hashMapImp.put("Value 1", 1);
        hashMapImp.put("Value 1", 2);
        hashMapImp.put("Value 3", 3);
        hashMapImp.get("Value 1");
        System.out.println(hashMapImp);
        System.out.println(hashMapImp.get("Value 1"));
        System.out.println(hashMapImp.containsValue(1));

        List<String> arrayList = new ArrayListImp<>();
        for (int i = 0; i < 11; i++) {
            arrayList.add(String.valueOf(i));
        }
        arrayList.remove("3");
        System.out.println(arrayList.toString());
    }
}
