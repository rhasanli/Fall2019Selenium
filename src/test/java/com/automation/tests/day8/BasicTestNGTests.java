package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeMethod
    public void setup() {
        System.out.println("BEFORE METHOD");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @AfterMethod
    public void teardown() {
        System.out.println("AFTER METHOD");
    }

    @Test
    public void test1() {
        System.out.println("TEST 1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2() {
        System.out.println("TEST 2");
        int num1 = 5;
        int num2 = 10;
        // it calls hard assertion
        // if assertion fails - it stops the execution , due to exception.
        Assert.assertTrue(num1 > num2);
    }

    @Test
    public void test3() {
        System.out.println("TEST 3");
        String expected = "car";
        String actual = "car";
        Assert.assertEquals(actual, expected);
    }
}
