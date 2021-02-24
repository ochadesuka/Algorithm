package Recursion;
//37
public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] itemUses = new boolean[3][3][10];

        //init
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j ++) {
                int num = board[i][j] - '0';
                if (num >= 1 && num <= 9) {
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    itemUses[i/3][j/3][num] = true;
                }
            }
        }
        recursion(board, rowUsed, colUsed, itemUses, 0, 0);
    }

    public boolean recursion(char[][] board, boolean[][] rowUsed, boolean[][] colUsed,
                          boolean[][][] itemUsed, int row, int col) {
        if(col == board[0].length) {
            col = 0;
            row++;
            if (row == board.length) {
                return true;
            }
        }

        if (board[row][col] == '.') {
            for (int i = 1; i <= 9; i ++) {
                if (!rowUsed[row][i] && !colUsed[col][i] && !itemUsed[row][col][i]) {
                    rowUsed[row][i] = true;
                    colUsed[col][i] = true;
                    itemUsed[row/3][col/3][i] = true;
                    board[row][col] = (char)('0' + i);

                    if (recursion(board, rowUsed, colUsed, itemUsed, row, col+1)) {
                        return true;
                    }
                    rowUsed[row][i] = false;
                    colUsed[col][i] = false;
                    itemUsed[row/3][col/3][i] = false;
                    board[row][col] = '.';
                }
            }
        }else {
            return recursion(board, rowUsed, colUsed, itemUsed, row, col+1);
        }
        return false;
    }
}
