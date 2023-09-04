package array_string;

public class Easy_28 {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        int nIdx = 0;
        int mIdx = 0;

        if (n < m) {
            return -1;
        }

        while (nIdx < n - m + 1) {
            int temp = nIdx;
            while (haystack.charAt(nIdx) == needle.charAt(mIdx)) {
                if (mIdx == m - 1) {
                    return nIdx;
                }
                nIdx += 1;
                mIdx += 1;
            }
            nIdx = temp + 1;
            mIdx = 0;
        }

        return -1;
    }
}
