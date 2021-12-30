package calc;

/**
 * State for a negative number where the digits are being inputed
 * after the decimal place.
 * 
 * @author Marion Geary
 * Wheaton College
 * CSCI 245
 * December 3, 2021
 */
public class NegativeDecimalState implements StateNum {
	
	/**
	 * The memory of the calculator.
	 */
	private Memory memory;
	
	/**
	 * The number currently being inputed.
	 */
	private double num;

	/**
	 * Constructor.
	 */
	public NegativeDecimalState(Memory memory) {
		this.memory = memory;
	}
	
	/**
	 * When the decimal button is pressed, the number
	 * stays the same.
	 */
	public double parseDecimal() {
		return num;
	}

	/**
	 * Change the sign of the current number.
	 */
	public double parsePlusMinus() {
		memory.setStateNum(new PositiveDecimalState(memory));
		return num * -1;
	}

	/**
	 * Add the digit to the number being inputed.
	 */
	public double parseDigit(int i) {
		num = memory.getNum();
		String numString;
		String display = memory.getDisplay();
		if(Math.floor(num) == Math.ceil(num) && i != 0) {
			numString = Integer.toString((int)num) + ".";
		} else if (Math.floor(num) == Math.ceil(num) && num != 0) {
			numString = display.substring(0, display.length() - 1);
		} else {
			numString = display;
		}
		numString = numString + i;
		num = Double.parseDouble(numString);
		memory.setDisplay(numString);
		return num;
	}

}
