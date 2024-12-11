import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"-3b3","3b2", "b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
        String s1= Ex1.int2Number(0,2);
        assertEquals(s1, "0b2");
        String s2= Ex1.int2Number(-5,10);
        assertEquals(s2, "");
        String s3 = Ex1.int2Number(5, 2);
        assertEquals(s3, "101b2");
        String s6 = Ex1.int2Number(10, 1);
        assertEquals(s6, "");
        String s7 = Ex1.int2Number(10, 17);
        assertEquals(s7, "");
        String s8 = Ex1.int2Number(0, 8);
        assertEquals(s8, "0b8");
        String s9 = Ex1.int2Number(0, 16);
        assertEquals(s9, "0b16");
        String s10 = Ex1.int2Number(-5, 2);
        assertEquals(s10, "");
        String s11 = Ex1.int2Number(123456789, 10);
        assertEquals(s11, "123456789bA");
    }
    @Test
    void maxIndexTest() {
        String[] arr= {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            assertEquals(Ex1.maxIndex(arr), 4);
            String[] arr1= {"-1", "12", "123", "1234", "2345", "0"};
                assertEquals(Ex1.maxIndex(arr1), 0);

    }
    @Test
    void intBaseTest(){
        int b1=Ex1.intBase("A");
        assertEquals(b1,10);
        int b2=Ex1.intBase("F");
        assertEquals(b2,15);
        int b=Ex1.intBase("9");
        assertEquals(b,9);
        int b3 = Ex1.intBase("0");
        assertEquals(b3, 0);
        int b5 = Ex1.intBase("B");
        assertEquals(b5, 11);
        int b6 = Ex1.intBase("C");
        assertEquals(b6, 12);
        int b7 = Ex1.intBase("E");
        assertEquals(b7, 14);
    }
    @Test
    void intNumberTest(){
        String b="A";
        char c= b.charAt(0);
        assertEquals(Ex1.intDigitNumber(b,c),10);
        b = "Z";
        c = b.charAt(0);
        assertEquals(Ex1.intDigitNumber(b, c), 35);
        b = "0";
        c = b.charAt(0);
        assertEquals(Ex1.intDigitNumber(b, c), 0);
        b = "9";
        c = b.charAt(0);
        assertEquals(Ex1.intDigitNumber(b, c), 9);

    }

}