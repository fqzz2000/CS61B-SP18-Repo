import org.junit.Test;
import static org.junit.Assert.*;
public class TestOffByN {
    @Test
    public void testEqualChars() {
        OffByN offBy5 = new OffByN(5);
        assertTrue(offBy5.equalChars('a', 'f'));
        assertTrue(offBy5.equalChars('f', 'a'));
        assertTrue(offBy5.equalChars('F', 'A'));
        assertFalse(offBy5.equalChars('a','d'));

        OffByN offBy0 = new OffByN(0);
        assertTrue(offBy0.equalChars('a', 'a'));
        assertFalse(offBy0.equalChars('a', 'b'));
    }

    @Test
    public void testIsPalindrome() {
        OffByN offByOne = new OffByN(1);
        assertTrue(offByOne.isPalindrome("", offByOne));
        assertTrue(offByOne.isPalindrome("%", offByOne));
        assertTrue(offByOne.isPalindrome("aCePfDb", offByOne));
        assertTrue(offByOne.isPalindrome("%%%%%&&&&&", offByOne));
        assertTrue(offByOne.isPalindrome("bDfPeCa", offByOne));

        assertFalse(offByOne.isPalindrome("abcd", offByOne));
        assertFalse(offByOne.isPalindrome("##j##", offByOne));
        assertFalse(offByOne.isPalindrome("baBjkjkiII", offByOne));

        OffByN offByMinusOne = new OffByN(-1);
        assertTrue(offByOne.isPalindrome("", offByMinusOne));
        assertTrue(offByOne.isPalindrome("%", offByMinusOne));
        assertTrue(offByOne.isPalindrome("%%%%%&&&&&", offByOne));
        assertTrue(offByOne.isPalindrome("aCePfDb", offByOne));
        assertTrue(offByOne.isPalindrome("bDfPeCa", offByOne));

        assertFalse(offByOne.isPalindrome("abcd", offByOne));
        assertFalse(offByOne.isPalindrome("##j##", offByOne));
        assertFalse(offByOne.isPalindrome("baBjkjkiII", offByOne));

        OffByN offBy5 = new OffByN(5);
        assertTrue(offBy5.isPalindrome("AafF&AafF", offBy5));
        assertTrue(offBy5.isPalindrome("", offBy5));
        assertTrue(offBy5.isPalindrome("&", offBy5));

        assertFalse(offBy5.isPalindrome("aaa", offBy5));
    }
}
