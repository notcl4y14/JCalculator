package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar {
	public Toolbar() {
		this.setFloatable(false);

		JButton buttonAbout = new JButton("About");
		buttonAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AboutFrame();
			}
		});
		
		this.add(buttonAbout);
	}
}
