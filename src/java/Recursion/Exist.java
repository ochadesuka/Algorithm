package Recursion;
//79
public class Exist {
    private int[][] ds = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public boolean exist(char[][] board, String word) {
        boolean[][] states = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (recursion(board, states, word.toCharArray(), 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean recursion(char[][] board, boolean[][] states, char[] words, int index, int row, int col) {
        if (index == words.length-1) {
            return board[row][col] == words[index];
        }

        if (board[row][col] == words[index]) {
            states[row][col] = true;
            for (int[] d : ds) {
                int newR = row + d[0];
                int newC = row + d[1];
                if (newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length && !states[newR][newC]) {
                    if (recursion(board, states, words, index + 1, newR, newC)) {
                        return true;
                    }
                }
            }
            states[row][col] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        Exist e = new Exist();
        System.out.println(e.exist(board, "ABCCEE"));

    }
}
