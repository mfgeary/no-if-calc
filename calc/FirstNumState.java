/**
 * 
 */
package calc;

/**
 * State when the first operand is being inputed, before the operator has
 * been inputed in the calculator.
 * @author Marion Geary
 * Wheaton College
 * CSCI 245
 * December 3, 2021
 */
public class FirstNumState implements StateParse {
	
	/**
	 * The number currently being inputed.
	 */
	private double num;
	
	/**
	 * The memory of the calculator.
	 */
	private Memory memory;

	/**
	 * Constructor.
	 */
	public FirstNumState(Memory memory) {
		this.memory = memory;
	}

	/**
	 * Add the inputed digit to the current number.
	 * @return The double value of the updated number.
	 */
	public double parseDigit(int i) {
		num = memory.getStateNum().parseDigit(i);
		memory.setD1(num);
		return num;
	}

	/**
	 * Change the sign of the number.
	 */
	public void parsePM() {
		num = memory.getNum();
		memory.setD1(num);
		num = memory.getNum();
	}
	
	public void parseDecimal() {};

	/**
	 * Evaluate the function given the current operands.
	 * Will return a value using num as both operands.
	 */
	public void evaluate() {
		memory.evaluateHelper();
	}

	/**
	 * Set the evaluator based on the inputed operator and
	 * change states.
	 */
	public void setEvaluator(Evaluator evaluator) {
		memory.setEvalInstance(evaluator);
		memory.setStateParse(new SecondNumState(memory));		
	}

}
