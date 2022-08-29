/**
 * 
 */
package edu.uvg.ej3.controller;

/**
 * @author MAAG
 *
 */
public class TranspositionCipher {

	/***
	 * This method will return a cipher text using Transposition Cipher Algorithm
	 * @param plain_text the text that wants to be ciphered 
	 * @return cipher text
	 */
	public String encode(String plain_text) {
		
		char[][] textMatrix = getMatrixFromText(plain_text);
		
		textMatrix = transposeMatrix(textMatrix);
		
		return getTextFromMatrix(textMatrix);
	}
	
	/***
	 * This method will return a decoded text
	 * @param cipher_text a that was cipher using transposition algorithm
	 * @return the plain text
	 */
	public String decode(String cipher_text) {

		return encode(cipher_text);
		
	}
	
	/***
	 * This method will transpose a matrix, it means the columns of the original matrix
	 * will be the rows of the result matrix and the rows of the original matrix will be 
	 * the columns of the result matrix
	 * @param aMatrixOfChars a matrix with all the chars
	 * @return a transpose of the original matrix
	 */
	private char[][] transposeMatrix(char[][] aMatrixOfChars){
		char[][] tempMatrix = new char[aMatrixOfChars.length][aMatrixOfChars[0].length]; //Create an empty matrix with same dimensions as original
		
		for (int i = 0; i < aMatrixOfChars.length; i++) { //rows counter
			for (int j = 0; j < aMatrixOfChars[0].length; j++) { // columns counter
				
				tempMatrix[j][i] = aMatrixOfChars[i][j]; //I switch the index so the empty matrix will be filled up with the transpose matrix
				
			}
		}
		
		return tempMatrix;
	}
	
	/***
	 * Since a square matrix will be needed it will have the same number of 
	 * rows and columns, this method will give the right number of rows and columns
	 * to allocate all the chars in the text
	 * @param text the text that will be saved in the matrix
	 * @return a integer value which represent the number of rows and columns for a square matrix to 
	 * save all the chars of the text
	 */
	private int getMatrixDimensions(String text) {
		int dimensions = 0;
		
		//Since it will be a square matrix I need to know how many rows and columns are enough to save all the chars of the text
		do {
			dimensions += 1;
		}while ((dimensions * dimensions) < text.length()); 
		
		return dimensions;
	}
	
	/***
	 * This method will return a square matrix with all the chars of the plain_text
	 * if there are not enough chars in the text then will be filled up with a char
	 * @param plain_text the text that want to cipher
	 * @return a matrix with all the chars.
	 */
	private char[][] getMatrixFromText(String plain_text){
		int numberOfRowsAndColumns = getMatrixDimensions(plain_text);
		
		char[][] tempMatrix = new char[numberOfRowsAndColumns][numberOfRowsAndColumns];
		
		int counter = 0;
		for (int i = 0; i < numberOfRowsAndColumns; i++) {
			for (int j = 0; j < numberOfRowsAndColumns; j++) {
				if (counter < plain_text.length()) {
					tempMatrix[i][j] = plain_text.charAt( counter );
				} else { //fill with random chars
					tempMatrix[i][j] = getRandomChar();
				}
				counter++;
			}
		}
		
		return tempMatrix;
	}
	
	/***
	 * This method will get a text from a square matrix of chars
	 * @param matrixOfChars matrix with all the chars of a text
	 * @return the string value
	 */
	private String getTextFromMatrix(char[][] matrixOfChars) {
		String aText = "";
		
		for (int i = 0; i < matrixOfChars.length; i++) {
			for (int j = 0; j < matrixOfChars[i].length; j++) {
				aText += matrixOfChars[i][j];
			}
		}
		
		return aText;
	}
	
	char getRandomChar() {
		return ' ';
	}
}
