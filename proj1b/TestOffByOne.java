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
        for (char i = 0; i < 127; i++) {
            for (char j = 0; j < 127; j++) {
                int diff = Math.max(i - j, j - i);
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
        assertTrue(palindrome.isPalindrome("aCePfDb", offByOne));
        assertTrue(palindrome.isPalindrome("%%%%%&&&&&", offByOne));
        assertTrue(palindrome.isPalindrome("bDfPeCa", offByOne));

        assertFalse(palindrome.isPalindrome("abcd", offByOne));
        assertFalse(palindrome.isPalindrome("##j##", offByOne));
        assertFalse(palindrome.isPalindrome("baBjkjkiII", offByOne));
    }
}
