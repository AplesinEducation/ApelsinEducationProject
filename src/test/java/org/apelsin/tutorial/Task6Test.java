package org.apelsin.tutorial;

import org.apelsin.tutorial.collections.ArrayCollection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Task6Test {

    private ArrayCollection initialArray;
    private Integer[] arrayToCheck1;
    private Integer[] arrayToCheck2;


    @Before
    public void init(){
       initialArray = new ArrayCollection() {{
           pushBack(1);
           pushBack(2);
           pushBack(3);
           pushBack("6");
        }};
       arrayToCheck1 = new Integer[]{2, 3};
       arrayToCheck2 = new Integer[]{3, 4, 6};
    }

    @Test
    public void containsTest() {
        Assert.assertTrue(initialArray.contains(2));
        Assert.assertFalse(initialArray.contains(7));
        Assert.assertFalse(initialArray.contains(6));
        Assert.assertTrue(initialArray.contains("6"));
    }

    @Test
    public void containsAllTest() {
        Assert.assertTrue(initialArray.containsAll(arrayToCheck1));
        Assert.assertFalse(initialArray.containsAll(arrayToCheck2));
    }
}
