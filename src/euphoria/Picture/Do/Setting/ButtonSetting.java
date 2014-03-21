package euphoria.Picture.Do.Setting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonSetting extends JButton implements ActionListener {

	public ButtonSetting(String title) {
		setText(title);
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		DoSetting ds = new DoSetting();
		ds.setVisible(true);
	}

}
