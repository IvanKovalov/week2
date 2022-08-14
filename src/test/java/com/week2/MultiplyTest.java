package com.week2;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertEquals;


 class MultiplyTest {
    static Multiply multiply = new Multiply();
    @Test
    void testMultiplyInt()
    {
        assertEquals( 2 , multiply.multiplyInt(1,2));
        assertEquals( 6 , multiply.multiplyInt(2,3));
        System.out.println("======TEST testMultiplyInt EXECUTED=======");
    }

    @Test
    void testMultiplyDouble(){
        assertEquals(0.48999999999999994,multiply.multipleDouble(0.7,0.7));
        assertEquals(0.81, multiply.multipleDouble(0.9,0.9));
        System.out.println("======TEST testMultiplyDouble EXECUTED=======");
    }

    @Test
    void testMultiplyFloat(){
        assertEquals(0.4899999797344208,multiply.multiplyFloat(0.7,0.7));
        assertEquals(0.809999942779541, multiply.multiplyFloat(0.9,0.9));
        System.out.println("======TEST testMultiplyFloat EXECUTED=======");
    }

}
