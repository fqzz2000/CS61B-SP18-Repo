public class OffByN implements CharacterComparator{
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
    /* return true if the given word is palindrome interms of the defined equalChars */
    @Override
    public boolean isPalindrome(String word, CharacterComparator cc) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (!cc.equalChars(word.charAt(left), word.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
