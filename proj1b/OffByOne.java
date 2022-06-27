public class OffByOne implements CharacterComparator{
    /* return true if the input chars are different by 1 */
    @Override
    public boolean equalChars (char x, char y) {
        return (x - 1 == y) || (y - 1 == x);
    }
    @Override
    public boolean isPalindrome (String word, CharacterComparator cc) {
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
