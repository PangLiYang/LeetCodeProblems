import java.util.*;

public class Test {
    public int equalPairs(int[][] grid) {
        int n = grid[0].length;
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i += 1) {
            StringBuilder sb = new StringBuilder();
            for (int j: grid[i]) {
                sb.append(j);
                sb.append(' ');
            }
            String s = sb.toString();
            System.out.println(s);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (int i = 0; i < n; i += 1) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j += 1) {
                sb.append(grid[j][i]);
                sb.append(' ');
            }
            String s = sb.toString();
            System.out.println(s);
            ans += map.getOrDefault(s, 0);
        }

        return ans;
    }

    public static void main(String[] args) {
        Test tt = new Test();
        int[][] input = {{11,1}, {1,11}};
        System.out.println(tt.equalPairs(input));
    }
}
