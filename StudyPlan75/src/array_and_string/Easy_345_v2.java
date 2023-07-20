package array_and_string;

public class Easy_345_v2 {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int leftPointer = 0;
        int rightPointer = s.length() - 1;

        while (leftPointer < rightPointer) {
            while (!isVowel(sb.charAt(leftPointer)) && (leftPointer < rightPointer)) {
                leftPointer += 1;
            }
            while (!isVowel(sb.charAt(rightPointer)) && (leftPointer < rightPointer)) {
                rightPointer -= 1;
            }
            char temp = sb.charAt(leftPointer);
            sb.setCharAt(leftPointer, sb.charAt(rightPointer));
            sb.setCharAt(rightPointer, temp);
            leftPointer += 1;
            rightPointer -= 1;
        }

        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u'
                || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U';
    }
}
