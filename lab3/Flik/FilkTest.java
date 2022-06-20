import org.junit.Test;
import static org.junit.Assert.*;
public class FilkTest {
    @Test
    public void testIsSameNumber() {
        int a = -129;
        int b = 66;
        int c = -128;
        assertFalse(Flik.isSameNumber(a, b));
        assertTrue(Flik.isSameNumber(a, a));

    }
}
