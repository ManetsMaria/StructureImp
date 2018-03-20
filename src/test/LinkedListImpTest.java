package test;

import main.LinkedListImp;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LinkedListImpTest {
        @Test
        public void commonLinkedListTest(){
            List <String> linkedListImp = new main.LinkedListImp<>();
            linkedListImp.add("1");
            linkedListImp.add("2");
            linkedListImp.add("3");
            linkedListImp.remove("1");
            Assert.assertEquals(linkedListImp.get(0), "2");
        }

}
