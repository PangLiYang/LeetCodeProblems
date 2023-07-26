package graphs_dfs;

public class Medium_547 {
    public int findCircleNum(int[][] isConnected) {
        boolean[] prov = new boolean[isConnected.length];
        int count = 0;

        for (int i = 0; i < isConnected.length; i += 1) {
            if (!prov[i]) {
                count += 1;
                dfs(i, isConnected, prov);
            }
        }

        return count;
    }

    private void dfs(int node, int[][] isConnected, boolean[] prov) {
        prov[node] = true;

        for (int i = 0; i < isConnected.length; i += 1) {
            if (!prov[i] && isConnected[node][i] == 1) {
                dfs(i, isConnected, prov);
            }
        }
    }
}
