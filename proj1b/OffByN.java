public class OffByN implements CharacterComparator {
    private int N;
    OffByN(int N) {
        super();
        this.N = N;
    }
    /* return true if x and y are different by n */
    @Override
    public boolean equalChars(char x, char y) {

        return (x - N == y) || (y - N == x);
    }

}
