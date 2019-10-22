package com.example.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest{
    Logic logic = new Logic();
    @Test
    public void summ_test1() {
        assertEquals(33,logic.summ(10,23),0);
    }
    @Test
    public void summ_test2() {
        assertEquals(45,logic.summ(0,45),0);
    }
    @Test
    public void summ_test3() {
        assertEquals(67,logic.summ(67,0),0);
    }
    @Test
    public void summ_test4() {
        assertEquals(10,logic.summ(1.1,8.9),0);
    }
    @Test
    public void summ_test5() {
        assertEquals(6.8,logic.summ(2.3,4.5),0);
    }
    @Test
    public void summ_test6() {
            assertEquals(0,logic.summ(0,0),0);
    }
    @Test
    public void summ_test7() {
        assertEquals(13,logic.summ(-32,45),0);
    }
    @Test
    public void summ_test8() {
        assertEquals(-55,logic.summ(-67,12),0);
    }
    @Test
    public void summ_test9() {
        assertEquals(-2.234567,logic.summ(-1.234567,-1),0);
    }
    @Test
    public void summ_test10() {
        assertEquals(1.0000002,logic.summ( 0.0000001,1.0000001),0);
    }


    @Test
    public void multiply_test1() {
        assertEquals(230,logic.multiply(10,23),0);
    }
    @Test
    public void multiply_test2() {
        assertEquals(0,logic.multiply(0,45),0);
    }
    @Test
    public void multiply_test3() {
        assertEquals(0,logic.multiply(67,0),0);
    }
    @Test
    public void multiply_test4() {
        assertEquals(9.79,logic.multiply(1.1,8.9),0);
    }
    @Test
    public void multiply_test5() {
        assertEquals(10.35,logic.multiply(2.3,4.5),0);
    }
    @Test
    public void multiply_test6() {
        assertEquals(0,logic.multiply(0,0),0);
    }
    @Test
    public void multiply_test7() {
        assertEquals(-1440,logic.multiply(-32,45),0);
    }
    @Test
    public void multiply_test8() {
        assertEquals(1440,logic.multiply(-32,-45),0);
    }
    @Test
    public void multiply_test9() {
        assertEquals(20.47,logic.multiply(-8.9,-2.3),0);
    }
    @Test
    public void multiply_test10() {
        assertEquals(0.27,logic.multiply(0.9,0.3),0);
    }
    @Test
    public void multiply_test11() {
        assertEquals(2.67,logic.multiply(8.9,0.3),0);
    }
    @Test
    public void multiply_test12() {
        assertEquals(2.4,logic.multiply(-8,-0.3),0);
    }
    @Test
    public void multiply_test13() {
        assertEquals(24,logic.multiply(8,3),0);
    }
    @Test
    public void multiply_test14() {
        assertEquals(1.5,logic.multiply(0.5,3),0);
    }
    @Test
    public void multiply_test15() {
        assertEquals(0.3391972,logic.multiply(0.25,1.356789),0);
    }
    @Test
    public void multiply_test16() {
        assertEquals(1.2950551,logic.multiply(0.9545,1.356789),0);
    }




     @Test
    public void divide_test1() {
        assertEquals(0.4347826,logic.divide(10,23),0);
    }
    @Test
    public void divide_test2() {
        assertEquals(0,logic.divide(0,45),0);
    }
    @Test
    public void divide_test3() {
        assertEquals(0,logic.divide(67,0),0);
    }
    @Test
    public void divide_test4() {
        assertEquals(1,logic.divide(10,10),0);
    }
    @Test
    public void divide_test5() {
        assertEquals(7.5681818,logic.divide(333,44),0);
    }
    @Test
    public void divide_test6() {
        assertEquals(0,logic.divide(0,0),0);
    }
       @Test
    public void divide_test7() {
        assertEquals(3.7073170,logic.divide(45.6,12.3),0);
    }
    @Test
    public void divide_test8() {
        assertEquals(-4.45,logic.divide(-8.9,2),0);
    }



    @Test
    public void minus_test1() {
        assertEquals(4,logic.minus(10,6),0);
    }
    @Test
    public void minus_test2() {
        assertEquals(15,logic.minus(15,0),0);
    }
    @Test
    public void minus_test3() {
        assertEquals(-8,logic.minus(0,8),0);
    }
    @Test
    public void minus_test4() {
        assertEquals(2.5,logic.minus(5.5,3),0);
    }

    @Test
    public void minus_test5() {
        assertEquals(3.8,logic.minus(4.9,1.1),0);
    }
    @Test
    public void minus_test6() {
        assertEquals(-16,logic.minus(-9,7),0);
    }
    @Test
    public void minus_test7() {
        assertEquals(-17.4,logic.minus(-8.4,9),0);
    }
    @Test
    public void minus_test8() {
        assertEquals(-19998,logic.minus(-9999,9999),0);
    }
    @Test
    public void minus_test9() {
        assertEquals(-6466,logic.minus(-3232,3234),0);
    }
    @Test
    public void minus_test10() {
        assertEquals(-0.343499,logic.minus(4.9999,5.3434),0);
    }
    @Test
    public void minus_test11() {
        assertEquals(0.1358024,logic.minus(2.1234567,1.9876543),0);
    }
    @Test
    public void minus_test12() {
        assertEquals( 21274.247,logic.minus(21321.123,46.876),0);
    }
    @Test
    public void minus_test13() {
        assertEquals(7122.245,logic.minus(7123.545,1.3),0);
    }
    @Test
    public void minus_test14() {
        assertEquals(-234465.4,logic.minus(-123.4,234342),0);
    }
    @Test
    public void minus_test15() {
        assertEquals(-463,logic.minus(-465,-2),0);
    }


    @Test
    public void cutDisplay_test1() {
        assertEquals("123",logic.cutDisplay("123"));
    }
    @Test
    public void cutDisplay_test2() {
        assertEquals("-456",logic.cutDisplay("-456"));
    }
    @Test
    public void cutDisplay_test3() {
        assertEquals("0", logic.cutDisplay("0"));
    }
    @Test
    public void cutDisplay_test4() {
        assertEquals("123456789",logic.cutDisplay("1234567891"));
    }
    @Test
    public void cutDisplay_test5() {
        assertEquals("-12345678",logic.cutDisplay("-123456789"));
    }
    @Test
    public void cutDisplay_test6() {
        assertEquals("-1.234567",logic.cutDisplay("-1.2345678"));
    }
    @Test
    public void cutDisplay_test7() {
        assertEquals("1.2345678",logic.cutDisplay("1.23456789"));
    }
    @Test
    public void cutDisplay_test8() {
        assertEquals("1.2345678",logic.cutDisplay("1.23456789"));
    }
    @Test
    public void cutDisplay_test9() {
        assertEquals("33.567899",logic.cutDisplay("33.56789987"));
    } @Test
    public void cutDisplay_test10() {
        assertEquals("-33.56789",logic.cutDisplay("-33.56789987"));
    }
    @Test
    public void cutDisplay_test11() {
        assertEquals("99999.987",logic.cutDisplay("99999.98765"));
    }
    @Test
    public void cutDisplay_test12() {
        assertEquals("-99999.98",logic.cutDisplay("-99999.98765"));
    }
    @Test
    public void cutDisplay_test13() {
        assertEquals("33.567899",logic.cutDisplay("33.56789987"));
    }
    @Test
    public void cutDisplay_test14() {
        assertEquals("-33.56789",logic.cutDisplay("-33.56789987"));
    }
    @Test
    public void cutDisplay_test15() {
        assertEquals("44444444.",logic.cutDisplay("44444444.44444"));
    }
    @Test
    public void cutDisplay_test16() {
        assertEquals("-44444444",logic.cutDisplay("-44444444.44444"));
    }
    @Test
    public void cutDisplay_test17() {
        assertEquals("123456789",logic.cutDisplay("123456789123.3123123"));
    }


}