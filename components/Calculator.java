package components;

import javax.swing.JTextField;

public class Calculator {
	public String output;
	public String num1;
	public String num2;
	public char operator;
	public int currentNum;
	// public boolean hasCalculated; // Used for changing operators without calculating again
	// public char lastOperator; // This one too
	public JTextField outputHandle;

	public Calculator() {
		this.output = "";
		this.num1 = "";
		this.num2 = "";
		this.operator = 0;
		this.currentNum = 0;
		// this.hasCalculated = false;
		// this.lastOperator = 0;
	}

	// Current number
	private void setCurrentNumber(String string) {
		switch (this.currentNum) {
			case 0:
				this.num1 = string;
				break;
			case 1:
				this.num2 = string;
				break;
		}
	}

	private String getCurrentNumber() {
		switch (this.currentNum) {
			case 0:
				return this.num1;
			case 1:
				return this.num2;
		}

		return "";
	}

	// Output
	public void setOutputHandle(JTextField outputHandle) {
		this.outputHandle = outputHandle;
	}

	public void setOutput(String string) {
		this.output = string;
		this.outputHandle.setText(string);
	}

	public void addOutput(String string) {
		this.output += string;
		this.outputHandle.setText(this.outputHandle.getText() + string);
	}
	public void addOutput(char string) {
		this.output += string;
		this.outputHandle.setText(this.outputHandle.getText() + string);
	}

	// Clear
	public void clear() {
		this.setOutput("");
		// this.hasCalculated = false;
		// this.lastOperator = 0;
		this.num1 = "";
		this.num2 = "";
		this.currentNum = 0;
	}

	public void clearLast() {
		String string = this.output.substring(0, this.output.length() - 1);
		this.setCurrentNumber(string);
		this.setOutput(string);
	}

	// Number / Operator
	public void addNumber(char symbol) {
		this.setCurrentNumber(this.getCurrentNumber() + symbol);
		this.setOutput(this.getCurrentNumber());
	}

	public void setOperator(char operator) {
		// this.lastOperator = this.operator;
		this.operator = operator;
		
		switch (this.currentNum) {
			case 0:
				this.currentNum = 1;
				break;
			// case 1:
				// if (this.hasCalculated && this.lastOperator == operator) {
					// this.calculate();
				// }
				// break;
		}
	}

	public void negate() {
		String number = this.getCurrentNumber();
		boolean hasMinus = number.charAt(0) == '-';

		if (hasMinus) {
			this.setCurrentNumber( number.substring(1, number.length()) );
		} else {
			this.setCurrentNumber('-' + number);
		}

		this.setOutput(this.getCurrentNumber());
	}

	// Calculation
	public void calculate() {
		float num1 = Float.parseFloat(this.num1);
		float num2 = Float.parseFloat(this.num2 == "" ? this.num1 : this.num2);
		String result = "";

		switch (this.operator) {
			case '+':
				result = String.valueOf(this.add(num1, num2));
				break;
			case '-':
				result = String.valueOf(this.subtract(num1, num2));
				break;
			case '*':
				result = String.valueOf(this.multiply(num1, num2));
				break;
			case '/':
				if (num2 == 0) {
					result = "Cannot divide by 0";
					break;
				}

				result = String.valueOf(this.divide(num1, num2));
				break;
			case '^':
				result = String.valueOf(this.power(num1, num2));
				break;
			default:
				result = this.output;
				break;
		}

		this.setOutput(result);
		this.num1 = result;
		// this.num2 = "";
		// this.hasCalculated = true;
	}

	private float add(float num1, float num2) {
		return num1 + num2;
	}

	private float subtract(float num1, float num2) {
		return num1 - num2;
	}

	private float multiply(float num1, float num2) {
		return num1 * num2;
	}

	private float divide(float num1, float num2) {
		return num1 / num2;
	}

	private float power(float num1, float num2) {
		return (float)Math.pow(num1, num2);
	}
}
