package AlgorithmArray;

public class SubrectangleQueries2 {
    private int[][] rectangle;
    private int[] updaterow1 = new int[500];
    private int[] updaterow2 = new int[500];
    private int[] updatecol1 = new int[500];
    private int[] updatecol2 = new int[500];
    private int[] newValue = new int[500];
    private int count = 0;

    public SubrectangleQueries2(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        if (row1 >= 0 && row1 < rectangle.length && row2 >= 0 && row2 < rectangle.length && row1 <= row2) {
            if (col1 >= 0 && col1 < rectangle[0].length && col2 >= 0 && col2 < rectangle[0].length && col1 <= col2) {
                updaterow1[count] = row1;
                updaterow2[count] = row2;
                updatecol1[count] = col1;
                updatecol2[count] = col2;
                this.newValue[count] = newValue;
                count++;
            }
        }
    }

    public Integer getValue(int row, int col) {
        if (row >= 0 && row < rectangle.length && col >= 0 && col < rectangle[0].length) {
            int count2 = count;
            for (;count2 >= 0; count2 --) {
                if (row >= this.updaterow1[count2] && row <= this.updaterow2[count2] &&
                col >= this.updatecol1[count2] && col <= this.updatecol2[count2]) {
                    return this.newValue[count2];
                }
            }
            return rectangle[row][col];
        }
        return null;
    }
}
