package AlgorithmArray;
//请你实现一个类SubrectangleQueries，它的构造函数的参数是一个 rows x cols的矩形（这里用整数矩阵表示），并支持以下两种操作：
//
//        1.updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
//
//        用newValue更新以(row1,col1)为左上角且以(row2,col2)为右下角的子矩形。
//        2.getValue(int row, int col)
public class SubrectangleQueries {
    private int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        if (row1 >= 0 && row1 < rectangle.length && row2 >= 0 && row2 < rectangle.length && row1 <= row2) {
            if (col1 >= 0 && col1 < rectangle[0].length && col2 >= 0 && col2 < rectangle[0].length && col1 <= col2) {
                for (int i = row1; i <= row2; i ++) {
                    for (int j = col1; j <= col2; j ++) {
                        rectangle[i][j] = newValue;
                    }
                }
            }
        }
    }

    public Integer getValue(int row, int col) {
        if (row >= 0 && row < rectangle.length && col >= 0 && col < rectangle[0].length) {
            return rectangle[row][col];
        }
        return null;
    }
}
