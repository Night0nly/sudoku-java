import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PuzzelParser {
	private String inputPath;
	
	public int[][] parse(String inputPath) {
		int sudoku[][] = new int[9][9];
		try(BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
			String line;
			int i = 0;
	        while ((line = br.readLine()) != null) {
	        	char[] cList = line.toCharArray();
	        	if(cList.length!=9) return null;
	        	for(int j=0;j<cList.length;j++) {
	        		if(cList[j]==' ') {
	        			sudoku[i][j] = 0;
	        		}else {
	        			int cNumber = Character.getNumericValue(cList[j]);
	        			if(0<cNumber && cNumber<10) {
	        				sudoku[i][j] = cNumber;
	        			}else return null;
	        		}
	        	}
	        	i++;
	        }
	        if(i!=9) return null; 
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return sudoku;
	}
}
