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
}
