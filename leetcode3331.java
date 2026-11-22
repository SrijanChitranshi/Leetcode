class Matrix3D {
    int[][][] matrix;
    int[] count;

    public Matrix3D(int n) {
        matrix = new int[n][n][n];
        count = new int[n];
    }

    public void setCell(int x, int y, int z) {
        if (matrix[x][y][z] == 0) {
            matrix[x][y][z] = 1;
            count[x]++;
        }
    }

    public void unsetCell(int x, int y, int z) {
        if (matrix[x][y][z] == 1) {
            matrix[x][y][z] = 0;
            count[x]--;
        }
    }

    public int largestMatrix() {
        int max = -1;
        int ans = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] >= max) {
                max = count[i];
                ans = i;
            }
        }

        return ans;
    }
}
