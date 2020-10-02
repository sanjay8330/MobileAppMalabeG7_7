package com.example.project;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private billguide bill;
    @Before
    public void setup(){
        bill = new billguide();
    }

    //Test cases of IT19158228 - Sakthivel.S
    @Test
    public void testGuideBill(){
        double DELTA = 1e-15;

        double res = bill.calcPrice(1000,2);
        Assert.assertEquals(2000,res,DELTA);
    }


}