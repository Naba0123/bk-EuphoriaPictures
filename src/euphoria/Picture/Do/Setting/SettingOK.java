package euphoria.Picture.Do.Setting;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import euphoria.Picture.Do.DoArea;

public class SettingOK extends JButton implements ActionListener {

	SettingOK() {
		setText("決定");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (checkSetting()) {
			updateSetting();
			Component c = (Component) e.getSource();
			Window w = SwingUtilities.getWindowAncestor(c);
			w.dispose();
		} else {
			JLabel label = new JLabel("入力が正しくありません。");
			JOptionPane.showMessageDialog(this, label);
		}
	}

	private boolean checkSetting() {
		if (DoSetting.tmpUserName.getText().isEmpty())
			return false;
		if (DoSetting.tmpPassWord.getText().isEmpty())
			return false;
		if (DoSetting.tmpKeyPath.getText().isEmpty())
			return false;
		if (DoSetting.tmpHostName.getText().isEmpty())
			return false;
		if (DoSetting.tmpPortNumber.getText().isEmpty())
			return false;
		if (DoSetting.tmpUploadPath.getText().isEmpty())
			return false;
		return true;
	}

	static void updateSetting() {
		DoArea.userNameField.setText(DoSetting.tmpUserName.getText());
		DoArea.passWordField.setText(DoSetting.tmpPassWord.getText());
		DoArea.keyPathField.setText(DoSetting.tmpKeyPath.getText());
		DoArea.hostNameField.setText(DoSetting.tmpHostName.getText());
		DoArea.portNumberField.setText(DoSetting.tmpPortNumber.getText());
		DoArea.uploadPathField.setText(DoSetting.tmpUploadPath.getText());
	}

}
