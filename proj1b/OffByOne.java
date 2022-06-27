public class OffByOne implements CharacterComparator {
    /* return true if the input chars are different by 1 */
    @Override
    public boolean equalChars(char x, char y) {
        return (x - 1 == y) || (y - 1 == x);
    }
}
