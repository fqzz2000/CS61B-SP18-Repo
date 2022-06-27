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
        assertTrue(offByOne.equalChars('a', 'b'));
        assertFalse(offByOne.equalChars('b', 'd'));
        assertFalse(offByOne.equalChars(' ', ' '));
        assertFalse(offByOne.equalChars('c', 'c'));
        assertTrue(offByOne.equalChars('B', 'A'));
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
