package printers;

public class Canvas {
    private final char[][] matrix;
    private final int ROWS = 12;
    private final int COLUMNS = 100;
    public Canvas(){
        matrix = new char[ROWS][COLUMNS];
    }
    public void clearMatrix(){
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLUMNS;j++){
                matrix[i][j] = ' ';
            }
        }
    }
    public void printArrow(char op, int row, int column, int row1, int column1) {
        row*=2; row1*=2;
        column*=5; column1*=5;
        assert(0 <= column && column < COLUMNS);
        assert(0 <= row && row < ROWS);
        assert(0 <= column1 && column1 < COLUMNS);
        assert(0 <= row1 && row1 < ROWS);
        int r = row + (row1 - row)/2;
        int c = column + (column1 - column)/2;
        matrix[r][c] = op;
    }
    public void printOnMatrix(int row, int column, String value){
        row*=2;
        column*=5;
        assert(0 <= column && column < COLUMNS);
        assert(0 <= row && row < ROWS);
        for(int k=0;k<value.length();k++){
            matrix[row][column+k]=value.charAt(k);
        }
    }
    public void showMatrix(){
        for(int i=0;i<ROWS;i++){
            String line = String.valueOf(matrix[i]).stripTrailing();
            if(line.isEmpty()) continue;
            System.out.println(line);
        }
    }
}
