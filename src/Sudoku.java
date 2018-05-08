import java.util.ArrayList;

public class Sudoku {
	
	public static void main(String[] args) {
		String inputPath;
        int sudoku[][];

        if(args.length != 1) {
        	System.out.println("Wrong param format");
        }else {
	        inputPath = args[0];
	        PuzzelParser reader = new PuzzelParser();
	        sudoku = reader.parse(inputPath);
	        if(sudoku == null) {
	        	System.out.println("Wrong file format");
	        }else {
	        	Solver solver = new Solver();
	        	solver.solve(sudoku, 0, 0);
	        	if(solver.getResultList()==null) {
	        		System.out.println("Have no answer");
	        	}else {
	        		printResultList(solver.getResultList());
	        	}
	        }
        }
    }

	private static void printResultList(ArrayList<int[][]> resultList) {
		System.out.println("解答は"+resultList.size()+"件でした。");
		for(int k=0;k<resultList.size();k++) {
			System.out.println("解答: "+(k+1));
			for(int i=0;i<9;i++) {
	    		for(int j=0;j<9;j++) {
	    			System.out.print(resultList.get(k)[i][j]);
	    		}
	    		System.out.println();
	    	}
			System.out.println("-----------------");
		}
		System.out.println("解答は"+resultList.size()+"件でした。");

	}
}
