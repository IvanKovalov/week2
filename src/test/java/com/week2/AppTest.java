package com.week2;

import static org.junit.Assert.assertTrue;

/*import org.junit.Test;*/
import org.junit.jupiter.api.*;

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

    @Tag("DEV")
    @Test
    public void testMul()
    {
        System.out.println("======TEST ONE EXECUTED=======");
        //Test will fail
        Assertions.assertEquals( 5 , app.mul(2, 2));
        //Test will fail
        //"пало множення"
    }

    @Tag("DEV")
    @Test
    public void testDiv()
    {
        System.out.println("======TEST TWO EXECUTED=======");
        Assertions.assertEquals( 1 , app.div(2, 2));
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
