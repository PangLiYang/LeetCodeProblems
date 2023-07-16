public class easy_1768_MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i += 1) {

            if (i >= word1.length() && i >= word2.length()) {
                break;
            }

            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "banana";
        easy_1768_MergeStringsAlternately task = new easy_1768_MergeStringsAlternately();
        System.out.println(task.mergeAlternately(str1, str2));
    }
}