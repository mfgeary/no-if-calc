/**
 * 
 */
package calc;

/**
 * Class to hold the memory for the calculator. Performs the
 * calculations resulting from the user inputs.
 * 
 * @author Marion Geary
 * Wheaton College, Fall 2021
 * November 17, 2021
 */
public interface Evaluator {
	
	/**
	 * Evaluate the result using the two doubles.
	 * @param a The first double.
	 * @param b The second double.
	 * @return The result of the two doubles being evaluated.
	 */
	public double evaluate(double a, double b);

}
