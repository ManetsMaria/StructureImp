package test;

import main.ArrayListImp;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ArrayListImpTest {
    @Test
    public void commonArrayListTest(){
        List<String> arrayList = new ArrayListImp<>();
        for (int i = 0; i < 11; i++) {
            arrayList.add(String.valueOf(i));
        }
        arrayList.remove("3");
        Assert.assertEquals(arrayList.get(3), "4");
    }
}
