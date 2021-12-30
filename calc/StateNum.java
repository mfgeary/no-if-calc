package calc;

/**
 * The state of the number in regards to decimal and sign.
 * 
 * @author Marion Geary
 * Wheaton College
 * CSCI 245
 * December 3, 2021
 */
public interface StateNum {
	
	/**
	 * Change the sign of the number.
	 * @return The number.
	 */
	public double parsePlusMinus();
	
	/**
	 * Prepare to add digits to the right of the decimal point.
	 * @return The number.
	 */
	public double parseDecimal();
	
	/**
	 * Add digits to the inputed number
	 * @param i The digit to be added to the number.
	 * @return The number.
	 */
	public double parseDigit(int i);

}
