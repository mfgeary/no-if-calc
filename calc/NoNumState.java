package calc;

/**
 * State when no numbers have been inputed yet. Initial state
 * of calculator.
 * 
 * @author Marion Geary
 * Wheaton College
 * CSCI 245
 * December 3, 2021
 */
public class NoNumState implements StateParse {
	
	/**
	 * The memory of the calculator.
	 */
	private Memory memory;

	/**
	 * Constructor.
	 */
	public NoNumState(Memory memory) {
		this.memory = memory;
	}

	/**
	 * Add the inputed digit by changing to FirstNumState.
	 * @return The updated number.
	 */
	public double parseDigit(int i) {
		FirstNumState state = new FirstNumState(memory);
		memory.setStateParse(state);
		return state.parseDigit(i);
	}
	
	/**
	 * Prepare the first inputed digit to be negative by 
	 * setting num to -1;
	 */
	public void parsePM() {
		memory.setD1(-1);
		memory.setStateParse(new FirstNumState(memory));
		
	}
	
	/**
	 * Do nothing when '=' is pressed.
	 */
	public void evaluate() {}

	/**
	 * Do nothing when an operator is pressed.
	 */
	public void setEvaluator(Evaluator evaluator) {}
	
	public void parseDecimal() {
		FirstNumState state = new FirstNumState(memory);
		memory.setD1(0);
		memory.setStateParse(state);
		state.parseDecimal();
	};


}
