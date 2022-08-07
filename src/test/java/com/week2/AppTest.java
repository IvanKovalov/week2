package com.week2;

import org.junit.Rule;

import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     *
     */
    public App app;


    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @BeforeAll
    static void setup(){
        System.out.println("@BeforeAll executed");
    }

    @BeforeEach
    void setupThis(){
        System.out.println("@BeforeEach executed");
    }


    @Test
    public void testGetInfo()
    {

        System.out.println("======TEST GetInfo EXECUTED=======");
        App.getInfo();
        assertEquals( 1 , App.generalMin);
        assertEquals( 6 , App.generalMax);
        assertEquals( 3.8 , App.generalIncrement);

    }

    @Test
    public void testCreateDouble()
    {
        double[][] arrayToCompare = {{0.0, 0.0},{ 1.0, 4.8},{2.0, 9.6},{3.0, 14.399999999999999},{4.0, 19.2},{5.0, 24.0},{6.0, 28.799999999999997},{7.0, 33.6},{8.0, 38.4}, { 9.0, 43.199999999999996}};
        System.out.println("======TEST createDoubleTable EXECUTED=======");
        assertEquals( Arrays.deepToString(arrayToCompare) , Arrays.deepToString(App.createTableDouble(3.8,1,6)));
    }

    @Test
    public void testCreateInt()
    {

        int[][] arrayToCompare = {{0, 0},{ 1, 4},{2, 8},{3, 12},{4, 16},{5, 20},{6, 24},{7, 28},{8, 32}, { 9, 36}};
        System.out.println("======TEST createIntTable EXECUTED=======");
        assertEquals( Arrays.deepToString(arrayToCompare) , Arrays.deepToString(App.createTableInt(3,1,6)));
    }


    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void testPrintFirstRowInt(){
        assertEquals(" 1 4 ", App.printFirstRow(3.8,1,6, "int"));
    }

    @Test
    public void testPrintFirstRowDouble(){
        assertEquals(" 1.0 4.8 ", App.printFirstRow(3.8,1,6, "double"));
    }

    @Test
    public void testPrintFirstRowFloat(){

        assertEquals(" 1.0 4.8 ", App.printFirstRow(3.8,1,6, "float"));

    }

    @Test
    public void testOutDouble(){
        App.generalMax = 6;
        App.generalMin = 1;
        App.generalIncrement = 3.8;
        double[][] doubleArray = App.createTableDouble(3.8,1,6);
        assertTrue(App.outDouble(doubleArray).contains("2 2.0 9.6"));
        assertTrue(App.outDouble(doubleArray).contains("3 3.0 14.399999999999999"));
        assertTrue(App.outDouble(doubleArray).contains("8 8.0 38.4"));
    }

    @Test
    public void testOutInt(){
        App.generalMax = 6;
        App.generalMin = 1;
        App.generalIncrement = 3.8;
        int[][] intArray = App.createTableInt((int)3.8,1,6);
        assertTrue(App.out(intArray).contains("0 0 0"));
        assertTrue(App.out(intArray).contains("5 5 20"));
        assertTrue(App.out(intArray).contains("9 9 36"));
    }

    @Test
    public void testOutFloat(){
        App.generalMax = 6;
        App.generalMin = 1;
        App.generalIncrement = 3.8;
        float[][] floatArray = App.createTableFloat((float)3.8,1,6);
        assertTrue(App.outFloat(floatArray).contains("2 2.0 9.6"));
        assertTrue(App.outFloat(floatArray).contains("6 6.0 28.800001"));
        assertTrue(App.outFloat(floatArray).contains("9 9.0 43.2"));
    }


    @AfterEach
    void tearThis(){
        System.out.println("@AfterEach executed");
    }

    @AfterAll
    static void tear(){
        System.out.println("@AfterAll executed");
    }

}
