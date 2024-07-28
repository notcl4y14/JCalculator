package components;

import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AboutFrame extends JFrame {
	public AboutFrame() {
		this.setTitle("About JCalculator");
		this.setSize(500, 250);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));

		this.add(new JLabel("<html>JCalculator v1.0<br>Written in Java :P<br><br>GitHub repo: <a href=\"https://github.com/notcl4y14/JCalculator\">https://github.com/notcl4y14/JCalculator</html>"));
		this.add(new TextField("https://github.com/notcl4y14/JCalculator"));

		this.setVisible(true);
	}
}
