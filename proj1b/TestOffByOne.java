import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
//    static CharacterComparator offByOne = new OffByOne();
    // Your tests go here.
    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertFalse(offByOne.equalChars('b', 'd'));
        assertFalse(offByOne.equalChars(' ',' '));
        assertFalse(offByOne.equalChars('c','c'));
        assertTrue(offByOne.equalChars('B', 'A'));
    }
    @Test
    public void testPalindrome() {

        assertTrue(offByOne.isPalindrome("", offByOne));
        assertTrue(offByOne.isPalindrome("%", offByOne));
        assertTrue(offByOne.isPalindrome("aCePfDb", offByOne));
        assertTrue(offByOne.isPalindrome("%%%%%&&&&&", offByOne));
        assertTrue(offByOne.isPalindrome("bDfPeCa", offByOne));

        assertFalse(offByOne.isPalindrome("abcd", offByOne));
        assertFalse(offByOne.isPalindrome("##j##", offByOne));
        assertFalse(offByOne.isPalindrome("baBjkjkiII", offByOne));
    }
}
