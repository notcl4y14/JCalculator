import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import components.Calculator;
import components.Toolbar;

public class JCalculator {
	public static int BUTTON_WIDTH = 100;
	public static int BUTTON_HEIGHT = 100;
	public static int OUTPUT_HEIGHT = 100;
	public static int GRID_SIZE_X = 4;
	public static int GRID_SIZE_Y = 5;

	public Calculator calculator;

	public JCalculator() {
		this.calculator = new Calculator();

		// Init variables
		int frameWidth = GRID_SIZE_X * BUTTON_WIDTH;
		int frameHeight = GRID_SIZE_Y * BUTTON_HEIGHT;
		
		// Init frame
		JFrame frame = new JFrame("JCalculator v1.0");
		frame.setSize(frameWidth, frameHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JPanels
		JPanel toolbarPanel = new JPanel();
		toolbarPanel.setLayout(new BorderLayout());

		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new BorderLayout());
		
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(GRID_SIZE_Y, GRID_SIZE_X));

		// Add components to JPanels
		toolbarPanel.add(new Toolbar(), BorderLayout.NORTH);

		JTextField outputHandle = new JTextField();
		outputPanel.add(outputHandle);
		this.calculator.setOutputHandle(outputHandle);
		
		gridPanel.add(this.newClearButton("C"));
		gridPanel.add(this.newClearLastButton("CE"));
		gridPanel.add(this.newNegateButton("*-1"));
		gridPanel.add(this.newPowerButton("x^y"));

		gridPanel.add(this.newNumberButton('7'));
		gridPanel.add(this.newNumberButton('8'));
		gridPanel.add(this.newNumberButton('9'));
		gridPanel.add(this.newOperatorButton('+'));

		gridPanel.add(this.newNumberButton('4'));
		gridPanel.add(this.newNumberButton('5'));
		gridPanel.add(this.newNumberButton('6'));
		gridPanel.add(this.newOperatorButton('-'));
		
		gridPanel.add(this.newNumberButton('1'));
		gridPanel.add(this.newNumberButton('2'));
		gridPanel.add(this.newNumberButton('3'));
		gridPanel.add(this.newOperatorButton('*'));

		gridPanel.add(this.newNumberButton('.'));
		gridPanel.add(this.newNumberButton('0'));
		gridPanel.add(this.newCalculateButton('='));
		gridPanel.add(this.newOperatorButton('/'));

		// Add JPanels to frame
		frame.add(toolbarPanel, BorderLayout.NORTH);
		frame.add(outputPanel, BorderLayout.CENTER);
		frame.add(gridPanel, BorderLayout.SOUTH);

		// Show frame
		frame.setVisible(true);
	}

	private JButton newNumberButton(char num) {
		JButton button = new JButton("" + num);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.addNumber(num);
			}
		});

		return button;
	}

	private JButton newOperatorButton(char operator) {
		JButton button = new JButton("" + operator);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.setOperator(operator);
			}
		});

		return button;
	}

	private JButton newPowerButton(String operator) {
		JButton button = new JButton("" + operator);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.setOperator('^');
			}
		});

		return button;
	}

	private JButton newCalculateButton(char operator) {
		JButton button = new JButton("" + operator);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.calculate();
			}
		});

		return button;
	}

	private JButton newNegateButton(String string) {
		JButton button = new JButton(string);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.negate();
			}
		});

		return button;
	}

	private JButton newClearButton(String string) {
		JButton button = new JButton(string);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.clear();
			}
		});

		return button;
	}

	private JButton newClearLastButton(String string) {
		JButton button = new JButton(string);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.clearLast();
			}
		});

		return button;
	}

	public static void main(String[] args) {
		new JCalculator();
	}
}
