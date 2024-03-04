package CODTECH;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		double total = 0;
		Scanner input = new Scanner(System.in);
		total = doCalculator(input, total);
		System.out.println("The total value is = " + total);

	}

	public static double doCalculator(Scanner input, double store) {
		int count = 0;
		double num = 0, num1 = 0;
		char ch = ' ';
		double total = 0;
		// loop run till user input will be '='
		while (true) {

			try {
				// only first time need two input later we are going to take answer as the one input
				
				if (count == 0) {
					System.out.println("Kindly Enter a Number1");
					num = input.nextDouble();
				} else {
					
						num = total;
					
				}
				System.out.println("Kindly Enter a operator");
				ch = input.next().charAt(0);
				if (ch == '=') {

					break;
				} else if (ch != '+' && ch != '-' && ch != '*' && ch != '/') {
					throw new InputincorrectException("kindly enter a correct opeartor");
				}

				else if (ch == '/' && num == 0) {

					 new ArithmeticException("Anything divide by 0 is infintiy");

				}
				System.out.println("Kindly Enter a Number2");
				// getting user input 
				num1 = input.nextDouble();
				// after getting inputs now calling cal method for mathematical operation
				total = cal(num, ch, num1);
				System.out.println("total is..." + total);
				count++;

			} 
			// catch incorrect operator
			catch (InputincorrectException e) {
				System.out.println("kindly enter a correct opeartor");
				System.out.println();

			} 
			// Consume the invalid input
			catch (InputMismatchException e) {
				System.out.println("Kindly enter a valid input ");
				System.out.println();
				input.next();

			}
			
		}
		return total;
	}
	// for mathematical operation
	public static double cal(double num, char ch, double num1) {
		switch (ch) {
		case '-':
			return num - num1;
		case '+':
			return num + num1;
		case '*':
			return num * num1;
		case '/':
			return num / num1;
		default:
			return 0;
		}

	}
}
// customerized exception
class InputincorrectException extends Exception {
	public InputincorrectException(String str) {
		super(str);
	}

}