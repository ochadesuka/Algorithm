package Recursion;

import java.util.ArrayDeque;
import java.util.Queue;

//200
public class NumIslands {
    public int numIslands1(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    public int numsIslands2(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '1') {
                    num++;
                    grid[i][j] = '0';
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[]{i,j});
                    while (!queue.isEmpty()) {
                        int[] pre = queue.remove();
                        if (pre[0] - 1 >= 0 && grid[pre[0]-1][pre[1]] == '1') {
                            queue.add(new int[]{pre[0]-1, pre[1]});
                            grid[pre[0]-1][pre[1]] = '0';
                        }
                        if (pre[0] + 1 < grid.length && grid[pre[0]+1][pre[1]] == '1') {
                            queue.add(new int[]{pre[0]+1, pre[1]});
                            grid[pre[0]+1][pre[1]] = '0';
                        }
                        if (pre[1] - 1 >= 0 && grid[pre[0]][pre[1]-1] == '1') {
                            queue.add(new int[]{pre[0], pre[1]-1});
                            grid[pre[0]][pre[1]-1] = '0';
                        }
                        if (pre[1] + 1 < grid[0].length && grid[pre[0]][pre[1]+1] == '1') {
                            queue.add(new int[]{pre[0], pre[1]+1});
                            grid[pre[0]][pre[1]+1] = '0';
                        }
                    }
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0' ) {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }

    public static void main(String[] args) {
        NumIslands islands = new NumIslands();
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(islands.numsIslands2(grid));
    }
}
