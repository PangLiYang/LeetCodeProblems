package divide_conquer;

public class Medium_427 {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        return recCons(grid, 0, 0, grid.length);

    }

    private Node recCons(int[][] grid, int row, int col, int size) {

        if (monotonic(grid, row, col, size)) {
            boolean val = grid[row][col] == 1;
            return new Node(val, true);
        }

        Node curr = new Node(true, false);
        int newSize = size / 2;
        curr.topLeft = recCons(grid, row, col, newSize);
        curr.topRight = recCons(grid, row, col + newSize, newSize);
        curr.bottomLeft = recCons(grid, row + newSize, col, newSize);
        curr.bottomRight = recCons(grid, row + newSize, col + newSize, newSize);

        return curr;
    }

    private boolean monotonic (int[][] grid, int row, int col, int size) {
        for (int i = row; i < row + size; i += 1) {
            for (int j = col ; j < col + size; j += 1) {
                if (grid[i][j] != grid[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}
