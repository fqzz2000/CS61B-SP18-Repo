public class Palindrome {
    /* convert a String to a Deque */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> dWord = wordToDeque(word);
        while (dWord.size() >= 2) {
            char front = dWord.removeFirst();
            char end = dWord.removeLast();
            if (front != end) {
                return false;
            }
        }
        return true;
    }
    /** Returns true if the input word is palindrome by the rules of implemented equalChars */
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
