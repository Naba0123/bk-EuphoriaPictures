package euphoria.Picture.Do.Setting;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class SettingCancel extends JButton implements ActionListener {

	public SettingCancel() {
		setText("キャンセル");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Component c = (Component) e.getSource();
		Window w = SwingUtilities.getWindowAncestor(c);
		w.dispose();
	}

}
