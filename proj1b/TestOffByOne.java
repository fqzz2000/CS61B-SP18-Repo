import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
//    static CharacterComparator offByOne = new OffByOne();
    // Your tests go here.
    */
    static CharacterComparator offByOne = new OffByOne();
    static Palindrome palindrome = new Palindrome();
    @Test
    public void testEqualChars() {
        // test for all cases
        for (char i = 0; i < 255; i++) {
            for (char j = 0; j < 255; j++) {
                int diff = i - j > 0? i - j : j - i;
                if (offByOne.equalChars(i, j)) {
                    assertEquals(1, diff);
                } else {
                    assertNotEquals(1, diff);
                }
            }
        }
    }
    @Test
    public void testPalindrome() {

        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("%", offByOne));
        assertTrue(palindrome.isPalindrome("rabq", offByOne));
        assertTrue(palindrome.isPalindrome("b", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("aCePfDb", offByOne));
        assertTrue(palindrome.isPalindrome("%%%%%&&&&&", offByOne));
        assertTrue(palindrome.isPalindrome("bDfPeCa", offByOne));
        assertTrue(palindrome.isPalindrome("flake", offByOne));

        assertFalse(palindrome.isPalindrome("abcd", offByOne));
        assertFalse(palindrome.isPalindrome("##j##", offByOne));
        assertFalse(palindrome.isPalindrome("baBjkjkiII", offByOne));
        assertFalse(palindrome.isPalindrome("goodmorning", offByOne));
        assertFalse(palindrome.isPalindrome("aB", offByOne));
        assertFalse(palindrome.isPalindrome("Ba", offByOne));
        assertFalse(palindrome.isPalindrome("baBjkjkiIIaaBBjinAAAA", offByOne));
        assertFalse(palindrome.isPalindrome("haveaevaH"));

    }
}
