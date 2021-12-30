package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * SetUp
 * 
 * Class to set up and start the calculator, plus
 * facilities for test-driving the calculator.
 *
 * @author Thomas VanDrunen
 * @author Marion Geary
 * CS 245, Wheaton College
 * June 27, 2014
 * November 17, 2021
*/
public class SetUp {
	
	private double d1;
	
	private double d2;

	/**
	 * Method for initializing the calculator internals and
	 * connecting them to the calculator face.
	 * @param face The component representing the user interface of 
	 * the calculator. 
	 */
	public static void setUpCalculator(CalculatorFace face) {

		/* Create an object to store the memory of the calculator */
		Memory memory = new Memory(face);
		
		/* Add action listeners for all the digit buttons */
		for(int i = 0; i < 10; i++) {
			final int j = i;
			face.addNumberActionListener(j, new ActionListener() {
				
				/**
				 * Add the digit to the calculator memory when a digit
				 * button is pressed.
				 * @param ae The event of pressing the button.
				 */
				public void actionPerformed(ActionEvent ae) {
					memory.parseDigit(j);
				}
				
			});
		}
		
		/* Add action listeners for each operator */
		face.addActionListener('+', new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				memory.setEvaluator((a, b) -> a + b);
			}
			
		});
		
		face.addActionListener('-', new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				memory.setEvaluator((a, b) -> a - b);
			}
			
		});
		
		face.addActionListener('*', new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				memory.setEvaluator((a, b) -> a * b);
			}
			
		});
		
		face.addActionListener('/', new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				memory.setEvaluator((a, b) -> a / b);
			}
			
		});
		
		face.addActionListener('C', new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				memory.clear();
			}
			
		});
		
		face.addActionListener('.', new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				memory.parseDecimal();
			}
			
		});
		
		face.addPlusMinusActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				memory.setEvaluator((d1, d2) -> -1 * d1);
			}
 		});
		
		face.addActionListener('=', new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				memory.eval();
			}
		});
		
		face.addPlusMinusActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				memory.parsePM();
			}
		});
		
	}
	
	/**
	 * This main method is for your testing of your calculator.
	 * It will *not* be used during grading. Any changes you make
	 * to this method will be ignored at grading.
	 */
	public static void main(String[] args) {
		setUpCalculator(new PlainCalculatorFace());
	}

}
