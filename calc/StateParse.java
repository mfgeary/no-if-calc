package calc;

/**
 * State to indicate which operand is being inputed currently.
 * 
 * @author Marion Geary
 * Wheaton College
 * CSCI 245
 * December 3, 2021
 */
public interface StateParse {
	
	/**
	 * Add a digit to the number.
	 * @param i The digit to be added.
	 * @return The number.
	 */
	public double parseDigit(int i);
	
	/**
	 * Change the sign of the number.
	 */
	public void parsePM();
	
	/**
	 * Prepare the function to have a decimal inputed.
	 */
	public void parseDecimal();
	
	/**
	 * Evaluate the number given the operators and operands.
	 */
	public void evaluate();
	
	/**
	 * Set the evaluator based on the given operator.
	 * @param evaluator
	 */
	public void setEvaluator(Evaluator evaluator);

}
