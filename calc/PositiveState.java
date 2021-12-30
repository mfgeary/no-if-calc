package calc;

/**
 * State when the value is positive and no decimal is present.
 * 
 * @author Marion Geary 
 * Wheaton College
 * CSCI 245
 * December 3, 2021
 */
public class PositiveState implements StateNum {

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
	public PositiveState(Memory memory) {
		this.memory = memory;
		this.num = memory.getNum();
	}
	
	/**
	 * Change states when the decimal button is pressed.
	 */
	public double parseDecimal() {
		memory.setStateNum(new PositiveDecimalState(memory));
		return num;
	}

	/**
	 * Change the sign of the number.
	 */
	public double parsePlusMinus() {
		memory.setStateNum(new NegativeState(memory));
		return num * -1;
	}

	/**
	 * Increase the value when a digit is pressed.
	 */
	public double parseDigit(int i) {
		num = memory.numUp(i);
		memory.setDisplay(Double.toString(num));
		return num;
	}

}
