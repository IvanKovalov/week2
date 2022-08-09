package com.week2;

import org.junit.Rule;

import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.*;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Unit test for simple App.
 */
 class AppTest
{
    /**
     * Rigorous Test :-)
     *
     */
    public App app;


    @Test
    void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @BeforeAll
    static void setup(){
        System.out.println("@BeforeAll executed");
    }

    @Test
    void testGetInfo()
    {

        System.out.println("======TEST GetInfo EXECUTED=======");
        App.getInfo("src/main/resources/testConfig.properties");
        assertEquals( 1 , App.generalMin);
        assertEquals( 6 , App.generalMax);
        assertEquals( 3.8 , App.generalIncrement);

    }
    @Test
    void testCreateDouble()
    {
        double[][] arrayToCompare = {{0.0, 0.0},{ 1.0, 4.8},{2.0, 9.6},{3.0, 14.399999999999999},{4.0, 19.2},{5.0, 24.0},{6.0, 28.799999999999997},{7.0, 33.6},{8.0, 38.4}, { 9.0, 43.199999999999996}};
        System.out.println("======TEST createDoubleTable EXECUTED=======");
        assertArrayEquals( arrayToCompare , App.createTableDouble(3.8,1,6));
    }

    @Test
     void testCreateInt()
    {

        int[][] arrayToCompare = {{0, 0},{ 1, 4},{2, 8},{3, 12},{4, 16},{5, 20},{6, 24},{7, 28},{8, 32}, { 9, 36}};
        System.out.println("======TEST createIntTable EXECUTED=======");
        assertArrayEquals( arrayToCompare ,App.createTableInt(3,1,6));
    }


    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
     void testPrintFirstRowInt(){
        assertEquals(" 1 4 \n", App.printFirstRow(3.8,1,6, "int"));
        System.out.println("======TEST testPrintFirstRowInt EXECUTED=======");
    }

    @Test
     void testPrintFirstRowDouble(){
        assertEquals(" 1.0 4.8 \n", App.printFirstRow(3.8,1,6, "double"));
        System.out.println("======TEST testPrintFirstRowDouble EXECUTED=======");
    }

    @Test
     void testPrintFirstRowFloat(){

        assertEquals(" 1.0 4.8 \n", App.printFirstRow(3.8,1,6, "float"));
        System.out.println("======TEST testPrintFirstRowFloat EXECUTED=======");

    }

    @Test
     void testOutDouble(){
        App.generalMax = 6;
        App.generalMin = 1;
        App.generalIncrement = 3.8;
        double[][] doubleArray = App.createTableDouble(3.8,1,6);
        assertTrue(App.outDouble(doubleArray).contains("2 2.0 9.6"));
        assertTrue(App.outDouble(doubleArray).contains("3 3.0 14.399999999999999"));
        assertTrue(App.outDouble(doubleArray).contains("8 8.0 38.4"));
        System.out.println("======TEST testPrintDouble EXECUTED=======");
    }

    @Test
     void testOutInt(){
        App.generalMax = 6;
        App.generalMin = 1;
        App.generalIncrement = 3.8;
        int[][] intArray = App.createTableInt((int)3.8,1,6);
        assertTrue(App.out(intArray).contains("0 0 0"));
        assertTrue(App.out(intArray).contains("5 5 20"));
        assertTrue(App.out(intArray).contains("9 9 36"));
        System.out.println("======TEST testPrintInt EXECUTED=======");
    }

    @Test
     void testOutFloat(){
        App.generalMax = 6;
        App.generalMin = 1;
        App.generalIncrement = 3.8;
        float[][] floatArray = App.createTableFloat((float)3.8,1,6);
        assertTrue(App.outFloat(floatArray).contains("2 2.0 9.6"));
        assertTrue(App.outFloat(floatArray).contains("6 6.0 28.800001"));
        assertTrue(App.outFloat(floatArray).contains("9 9.0 43.2"));
        System.out.println("======TEST testPrintFloat EXECUTED=======");
    }


    @AfterAll
    static void tear(){
        System.out.println("@AfterAll executed");
    }

}
