/**
 * 
 */
package edu.uvg.ej3.controller;

/**
 * @author MAAG
 *
 */
public class CaesarCipher {

	private int shift;
	private char[] alphabet = {	'a', 'b', 'c', 'd', 'e', 
								'f', 'g', 'h', 'i', 'j',
								'k', 'l', 'm', 'n', 'ñ',
								'o', 'p', 'q', 'r', 's',
								't', 'u', 'v', 'w', 'x',
								'y', 'z', 'A', 'B', 'C',
								'D', 'E', 'F', 'G', 'H',
								'I', 'J', 'K', 'L', 'M',
								'N', 'Ñ', 'O', 'P', 'Q',
								'R', 'S', 'T', 'U', 'V',
								'W', 'W', 'Z', '0', '1',
								'2', '3', '4', '5', '6',
								'7', '8', '9', ' ', '_'};
	
	public CaesarCipher(int shift) {
		this.shift = shift;
	}
	
	
	
	/**
	 * @return the shift
	 */
	public int getShift() {
		return shift;
	}



	/**
	 * @param shift the shift to set
	 */
	public void setShift(int shift) {
		this.shift = shift;
	}



	/***
	 * This method will apply the Caesar cipher to an specific text
	 * @param plain_text the text you need to cipher
	 * @return the cipher text
	 */
	public String encode(String plain_text) {
		int[] indexesOfPlainText = getNumericValuesFromText(plain_text); //get the indexes of each char in the text
		
		indexesOfPlainText = applyShift(indexesOfPlainText, this.shift); //applying the shift
		
		return getTextFromNumericValues(indexesOfPlainText); //Return the cipher text
	}
	
	/***
	 * This method will apply the Caesar  decode to a cipher text 
	 * NOTE: Shift specified must be the same used to encode the text
	 * @param cipher_text cipher text
	 * @return the plan text
	 */
	public String decode(String cipher_text) {
		int[] indexesOfCipherText = getNumericValuesFromText(cipher_text); //get the indexes of each char in the text
		
		indexesOfCipherText = applyShift(indexesOfCipherText, this.shift *(-1)); //applying the shift to the left
		
		return getTextFromNumericValues(indexesOfCipherText); //Return the cipher text
	}
	
	/***
	 * This method will return an array with the index of all the chars in the text,
	 * for example if "hello" is sent then it will return the following array: (7, 4, 11, 11, 15)
	 * since 7 is the index of the 'h', 4 is the index of the 'e', etc.
	 * @param text a normal text in spanish without special chars or symbols
	 * @return the array of indexes of all the chars in the text
	 */
	private int[] getNumericValuesFromText(String text) {
		int[] numericArray = new int[text.length()]; //Into this array I'm going to save the numeric value
		
		for (int i = 0; i < text.length(); i++) {
			char aCharIntoText = text.charAt(i); //Get the char at specific index in the text
			
			for (int j = 0; j < alphabet.length; j++) { //Search the char in the alphabet to get it index
				
				if (aCharIntoText == alphabet[j]) { // Compare the char with all the elements in the alphabet
					numericArray[i] = j; //If found then I'm going to save the index into the numeric array
					break; //shor circuit the for loop 
				}
			}
		}
		
		return numericArray;
	}
	
	/***
	 * This method will get an array of Indexes and will return the text
	 * for example if you send the following array: (7, 4, 11, 11, 15) it will return "hello" text 
	 * @param arrayOfIndexes array of indexes
	 * @return the text
	 */
	private String getTextFromNumericValues(int[] arrayOfIndexes) {
		String text = ""; //local string where all the chars will be concatenated
		
		for (int i = 0; i < arrayOfIndexes.length; i++) {
			text = text + alphabet[ arrayOfIndexes[i] ]; //get the char according with its index
		}
		
		return text;
	}
	
	/***
	 * This method will apply the shift to each index in the arrayOfIndex
	 * for example, if the array of indexes is: (7, 4, 11, 11, 15) and the shift is 3
	 * then the new array is: (10, 7, 14, 14, 18)
	 * @param arrayOfIndexes the original array of indexes
	 * @param shift how many values will change the array to the right
	 * @return the new arrayOfIndexes with the shift applied
	 */
	private int[] applyShift(int[] arrayOfIndexes, int shift) {
		int[] encodedArray = new int[arrayOfIndexes.length]; //Going to create the new array with the shift applied
		
		for (int i = 0; i < arrayOfIndexes.length; i++) {
			encodedArray[i] = ((arrayOfIndexes[i] + shift) % alphabet.length);
			
			while (encodedArray[i] < 0) { //prevent negative values
				encodedArray[i] += alphabet.length;
			}
			
		}
		
		return encodedArray;
	}
}
