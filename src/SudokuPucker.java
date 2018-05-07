
public class SudokuPucker {
	
	public static void main(String[] args) {
        System.out.println("Hello baby!");
        int sudoku[][] = new int[][]{
        	{9,7,6,0,0,0,0,0,0},
        	{0,0,2,0,4,0,7,0,0},
        	{0,0,0,0,0,0,0,0,0},
        	{8,0,0,6,0,1,0,0,2},
        	{6,9,3,0,8,0,0,0,0},
        	{0,0,0,0,0,0,0,0,0},
        	{0,4,0,3,0,8,0,6,5},
        	{0,6,0,1,0,0,3,0,0},
        	{0,1,0,0,6,5,4,7,0}
        };
        Solver solver = new Solver();
        solver.solve(sudoku, 0, 0);
    }
}
