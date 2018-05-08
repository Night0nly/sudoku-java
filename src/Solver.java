import java.util.ArrayList;

public class Solver {
	private boolean isMax = false;							
	private ArrayList<int[][]> resultList = new ArrayList<>();
	
	public ArrayList<int[][]> getResultList() {
		return resultList;
	}

	public void solve(int sudoku[][], int x, int y) {
		if(isMax == false) {
			if(x==9) {
				int[][] result = new int[9][9];
				for(int i=0;i<9;i++) {
	        		for(int j=0;j<9;j++) {
	        			result[i][j] = sudoku[i][j];
	        		}
	        	}
				resultList.add(result);
				if(resultList.size()==100) isMax=true;
			}else if(y==9) {
				solve(sudoku,x+1,0);
			}else if(sudoku[x][y] == 0) {
				for(int k=1; k<=9; k++) {
					if(fillable(sudoku,x,y,k)) {
						sudoku[x][y] = k;
						solve(sudoku,x,y+1);
						sudoku[x][y]=0;
					}
				}
			}else {
				solve(sudoku,x,y+1);
			}

		}
	}
	
	public boolean fillable(int sudoku[][], int x, int y, int k) {
		for(int i=0; i<9; i++) {
			if(sudoku[x][i]==k) { 
				return false;
			}
		}
		for(int j=0; j<9; j++) {
			if(sudoku[j][y]==k){ 
				return false;
			}
		}
		for(int l=(x/3)*3;l<(x/3)*3+3;l++) {
			for(int m=(y/3)*3;m<(y/3)*3+3;m++) {
				if(sudoku[l][m]==k) return false;
			}
		}
		return true;
	}
}
