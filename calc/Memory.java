package calc;

/**
 * Class to store the calculator's memory.
 * @author Marion Geary
 * Wheaton College, Fall 2021
 * November 17, 2021
 */
public class Memory {

	/**
	 * The method for evaluating the inputed doubles.
	 */
	private Evaluator evaluator;
	
	/**
	 * The current double being inputed in the calculator.
	 * The states apply to this number.
	 */
	private double num;
	
	/**
	 * Store first double inputed in the calculator.
	 */
	private double d1;
	
	/**
	 * Store second double inputed in the calculator.
	 */
	private double d2;
	
	/**
	 * The display of the calculator.
	 */
	private String display;
	
	/**
	 * The GUI components of the calculator.
	 */
	private CalculatorFace face;
	
	/**
	 * The state used for parsing. Indicates which operand 
	 * is currently being filled.
	 */
	private StateParse stateParse;
	
	/**
	 * The state of the current number: negative, positive, 
	 * decimal, no decimal.
	 */
	private StateNum stateNum;
	
	/**
	 * Constructor.
	 */
	public Memory(CalculatorFace face) {
		this.display = "";
		this.face = face;
		stateParse = new NoNumState(this);
		stateNum = new PositiveState(this);
		evaluator = new Evaluator() {

			@Override
			public double evaluate(double a, double b) {
				return 0;
			}
			
		};
	}
	
	/**
	 * Set the evaluator to the desired method of combining
	 * the two doubles, and evaluate when appropriate. I.e. run evaluate
	 * if the operands and operator are filled.
	 * @param evaluator The strategy for evaluating the two decimals.
	 */
	public void setEvaluator(Evaluator evaluator) {
		stateParse.setEvaluator(evaluator);
		// this is one main source of errors with negatives... couldn't
		// solve it in time
		setStateNum(new PositiveState(this));
		num = 0;
	}
	
	/**
	 * Set the instance variable evaluator to change the way
	 * that the inputed numbers are evaluated.
	 * @param evaluator The strategy for evaluating the decimals.
	 */
	public void setEvalInstance(Evaluator evaluator) {
		this.evaluator = evaluator;
	}
	
	/**
	 * Clear the memory of the calculator.
	 */
	public void clear() {
		this.evaluator = null;
		this.num = 0;
		this.d1 = 0;
		this.d2 = 0;
		setStateParse(new NoNumState(this));
		setStateNum(new PositiveState(this));
		this.display = "";
		face.writeToScreen(display);
	}
	
	/**
	 * Parse the digit being inputed in the calculator.
	 * @param i The digit being inputed. Must be between 0 and 9.
	 * @return The double with the added digit.
	 */
	public void parseDigit(int i) {
		num = stateParse.parseDigit(i);
		face.writeToScreen(display);
	}
	
	/**
	 * Evaluate the inputs to the function based on the state
	 * of the numbers. Called when '=' is pressed.
	 */
	public void eval() {
		stateParse.evaluate();
	}
	
	/**
	 * Evaluate the operands with the given operator. 
	 * Used when two inputs have been inputed. 
	 */
	public void evaluate() {
		num = evaluator.evaluate(d1, d2);
		setD1(num);
		display = Double.toString(num);
		face.writeToScreen(display);
		setStateParse(new FirstNumState(this));
		setStateNum(new PositiveState(this));
		num = 0;
	}
	
	/**
	 * Evaluate the operands with the given operator when only
	 * one operand is present. Use the operand as d1 and d2.
	 */
	public void evaluateHelper() {
		d2 = d1;
		evaluate();
	}
	
	/**
	 * Parse when a decimal is inputed.
	 * @return The value of the current number.
	 */
	public double parseDecimal() {
		return stateNum.parseDecimal();
	}
	
	/**
	 * Parse when the plus minus button is pressed. Changes the sign
	 * of the current number.
	 */
	public void parsePM() {
		num = num * -1;
		stateNum.parsePlusMinus();
		stateParse.parsePM();
		display = Double.toString(num);
		face.writeToScreen(display);
	}
	
	/**
	 * Set the value of d1.
	 * @param d The desired value of d1
	 */
	public void setD1(double d) {
		this.d1 = d;
	}
	
	/**
	 * Set the value of d2.
	 * @param d The desired value of d2.
	 */
	public void setD2(double d) {
		this.d2 = d;
	}

	/**
	 * Set the state for the StateParse object based on which
	 * operand is being filled.
	 * @param state The desired state of the object
	 */
	public void setStateParse(StateParse state) {
		this.stateParse = state;
	}
	
	/**
	 * Set the state for the StateNum object based on whether the decimal
	 * or plus/minus buttons have been pressed.
	 * @param state The desired state of the object
	 */
	public void setStateNum(StateNum state) {
		this.stateNum = state;
	}
	
	/**
	 * Get the current state of the number with regards to decimals and plus/minus.
	 * @return The current state of the number.
	 */
	public StateNum getStateNum() {
		return stateNum;
	}
	
	/**
	 * Set the string to display on the screen.
	 * @param str The string to be displayed.
	 */
	public void setDisplay(String str) {
		this.display = str;
	}
	
	/**
	 * Return the string displayed on the screen.
	 * @return The string displayed on the screen.
	 */
	public String getDisplay() {
		return this.display;
	}
	
	/**
	 * Get the current number being inputed.
	 * @return The current double being inputed.
	 */
	public double getNum() {
		return num;
	}
	
	/**
	 * Increase the value of the current value being inputed.
	 * This is the method for adding a digit to an inputed number.
	 * @param i
	 * @return
	 */
	public double numUp(int i) {
		return num * 10 + i;
	}
}
