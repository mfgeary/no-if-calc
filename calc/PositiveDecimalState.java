package calc;

/**
 * State of the current number when a decimal is present and the value
 * is positive.
 * 
 * @author Marion Geary
 * Wheaton College
 * CSCI 245
 * December 3, 2021
 */
public class PositiveDecimalState implements StateNum {
	
	/**
	 * The memory of the calculator.
	 */
	private Memory memory;
	
	/**
	 * The current number being inputed.
	 */
	private double num;

	/**
	 * Constructor.
	 */
	public PositiveDecimalState(Memory memory) {
		this.memory = memory;
	}
	
	/**
	 * No change when the decimal button is pressed.
	 * @return The current number.
	 */
	public double parseDecimal() {
		return num;
	}

	/**
	 * Change the sign of the number.
	 */
	public double parsePlusMinus() {
		memory.setStateNum(new NegativeDecimalState(memory));
		return -1 * num;
	}
	
	/**
	 * Add a new digit when a digit is inputed.
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
		System.out.println(numString);
		return num;
	}

}
