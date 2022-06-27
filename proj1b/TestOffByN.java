import org.junit.Test;
import static org.junit.Assert.*;
public class TestOffByN {
    static Palindrome palindrome = new Palindrome();
    @Test
    public void testEqualChars() {
        OffByN offBy5 = new OffByN(5);
        assertTrue(offBy5.equalChars('a', 'f'));
        assertTrue(offBy5.equalChars('f', 'a'));
        assertTrue(offBy5.equalChars('F', 'A'));
        assertFalse(offBy5.equalChars('a', 'd'));

        OffByN offBy0 = new OffByN(0);
        assertTrue(offBy0.equalChars('a', 'a'));
        assertFalse(offBy0.equalChars('a', 'b'));
    }

    @Test
    public void testIsPalindrome() {
        OffByN offByOne = new OffByN(1);
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("%", offByOne));
        assertTrue(palindrome.isPalindrome("aCePfDb", offByOne));
        assertTrue(palindrome.isPalindrome("%%%%%&&&&&", offByOne));
        assertTrue(palindrome.isPalindrome("bDfPeCa", offByOne));

        assertFalse(palindrome.isPalindrome("abcd", offByOne));
        assertFalse(palindrome.isPalindrome("##j##", offByOne));
        assertFalse(palindrome.isPalindrome("baBjkjkiII", offByOne));

        OffByN offByMinusOne = new OffByN(-1);
        assertTrue(palindrome.isPalindrome("", offByMinusOne));
        assertTrue(palindrome.isPalindrome("%", offByMinusOne));
        assertTrue(palindrome.isPalindrome("%%%%%&&&&&", offByOne));
        assertTrue(palindrome.isPalindrome("aCePfDb", offByOne));
        assertTrue(palindrome.isPalindrome("bDfPeCa", offByOne));

        assertFalse(palindrome.isPalindrome("abcd", offByOne));
        assertFalse(palindrome.isPalindrome("##j##", offByOne));
        assertFalse(palindrome.isPalindrome("baBjkjkiII", offByOne));

        OffByN offBy5 = new OffByN(5);
        assertTrue(palindrome.isPalindrome("AafF&AafF", offBy5));
        assertTrue(palindrome.isPalindrome("", offBy5));
        assertTrue(palindrome.isPalindrome("&", offBy5));

        assertFalse(palindrome.isPalindrome("aaa", offBy5));
    }
}
