package calc;

/**
 * State when the second number is being inputed. After an operator
 * has been inputed.
 * 
 * @author Marion Geary
 * Wheaton College
 * CSCI 245
 * December 3, 2021
 */
public class SecondNumState implements StateParse {

	/**
	 * The current number being inputed.
	 */
	private double num;
	
	/**
	 * The memory of the calculator.
	 */
	private Memory memory;
	
	/**
	 * Constructor.
	 */
	public SecondNumState(Memory memory) {
		this.memory = memory;
	}

	/**
	 * Add the inputed digit to the number.
	 * @return The updated number.
	 */
	public double parseDigit(int i) {
		num = memory.getStateNum().parseDigit(i);
		memory.setD2(num);
		memory.setDisplay(Double.toString(num));
		return num;
	}
	
	/**
	 * Chnage the sign of the number.
	 */
	public void parsePM() {
		num = memory.getNum();
		memory.setD2(num);
	}
	
	public void parseDecimal() {};

	/**
	 * Evaluate the expression with the given inputs.
	 */
	public void evaluate() {
		memory.evaluate();
	}

	/**
	 * Set the evaluator to perform the desired operation.
	 * Occurs when an operator functions like the equals sign.
	 */
	public void setEvaluator(Evaluator evaluator) {
		memory.evaluate();
		memory.setEvalInstance(evaluator);
		memory.setStateParse(new SecondNumState(memory));
	}

}
