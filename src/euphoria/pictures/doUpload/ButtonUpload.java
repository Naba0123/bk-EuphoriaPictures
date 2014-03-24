package euphoria.pictures.doUpload;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonUpload extends JButton implements ActionListener {

	public ButtonUpload(String title) {
		setText(title);
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		DoUpload du = new DoUpload();
		du.setVisible(true);
	}

}
