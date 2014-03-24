package euphoria.pictures.doTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonTest extends JButton implements ActionListener {

	public ButtonTest(String title) {
		setText(title);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DoTest doTest = new DoTest();
		doTest.setVisible(true);
	}

}
