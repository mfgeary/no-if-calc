package calc;

/**
 * State where the number is negative and no decimal is present.
 * 
 * @author Marion Geary
 * Wheaton College
 * CSCI 245
 * December 3, 2021
 */
public class NegativeState implements StateNum {
	
	/**
	 * The memory of the calculator.
	 */
	private Memory memory;
	
	/**
	 * The current number.
	 */
	private double num;

	/**
	 * Constructor.
	 */
	public NegativeState(Memory memory) {
		this.memory = memory;
		this.num = memory.getNum();
	}
	
	/**
	 * Change the state when the decimal button is pressed.
	 * @return The updated number.
	 */
	public double parseDecimal() {
		memory.setStateNum(new NegativeDecimalState(memory));
		return num;
	}

	/**
	 * Change the sign of the number.
	 * @return The updated number.
	 */
	public double parsePlusMinus() {
		memory.setStateNum(new PositiveState(memory));
		return num * -1;
	}

	/**
	 * Increase the number based on the given value.
	 * @return The updated number.
	 */
	public double parseDigit(int i) {
		num = memory.numUp(i);
		memory.setDisplay(Double.toString(num));
		return num;
	}
	

}
