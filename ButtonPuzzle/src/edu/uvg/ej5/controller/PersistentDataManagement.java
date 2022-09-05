/**
 * 
 */
package edu.uvg.ej5.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author MAAG
 *
 */
public class PersistentDataManagement {

	public int[][] getPuzzleFromFile(File _file) throws Exception{
		
		
		if (_file.isFile() && _file.canRead()) {

			BufferedReader reader = new BufferedReader(new FileReader(_file));
			ArrayList<String> linesOfFile = new ArrayList<String>();
			
			//Read File operations
	        try {
	            String line;
	            
	            while ((line = reader.readLine()) != null) {
	                linesOfFile.add(line);
	            }

	        } finally {
	            reader.close();
	        }
	        
	        //Create matrix operation
	        int rows_qty = linesOfFile.size();
	        
	        int columns_qty = linesOfFile.get(0).split(";").length;
	        
	        int[][] _puzzle = new int[rows_qty][columns_qty];
	        
	        for (int i = 0; i < rows_qty; i++) {
	        	String[] values = linesOfFile.get(i).split(";");
	        	for (int j = 0; j < columns_qty; j++) {
	        		_puzzle[i][j] = Integer.parseInt(values[j]);
	        	}
	        }
	        
	        return _puzzle;
	        
		} else {
			throw new Exception("Is not a file");
		}
	}
}
