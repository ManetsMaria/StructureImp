package test;

import main.HashMapImp;
import main.LinkedListImp;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class HashMapImpTest {

    @Test
    public void commonHashMapTest(){
        Map<String, Integer> hashMapImp = new HashMapImp<>();
        hashMapImp.put("Value 1", 1);
        hashMapImp.put("Value 1", 2);
        hashMapImp.put("Value 3", 3);
        hashMapImp.remove("Value 3");
        Assert.assertEquals(hashMapImp.size(), 1);
    }
}
