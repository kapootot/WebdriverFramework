package com.aw.wd;


import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest{

    @Test
    public void test(){
       assert true;
    }

    @Test
    public void test2(){
        String a = "a";
        assert a.equals("a");
    }
}

