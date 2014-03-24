package euphoria.pictures.doSetting;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import euphoria.pictures.doArea.DoArea;
import euphoria.setup.ConfigurationXML;

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
		if (new String(DoSetting.tmpPassWord.getPassword()).isEmpty())
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
		DoArea.passWordField.setText(new String(DoSetting.tmpPassWord.getPassword()));
		DoArea.keyPathField.setText(DoSetting.tmpKeyPath.getText());
		DoArea.hostNameField.setText(DoSetting.tmpHostName.getText());
		DoArea.portNumberField.setText(DoSetting.tmpPortNumber.getText());
		DoArea.uploadPathField.setText(DoSetting.tmpUploadPath.getText());

		ConfigurationXML.setProperty(DoArea.configUserName, DoSetting.tmpUserName.getText());
		ConfigurationXML.setProperty(DoArea.configKeyPath, DoSetting.tmpKeyPath.getText());
		ConfigurationXML.setProperty(DoArea.configHostName, DoSetting.tmpHostName.getText());
		ConfigurationXML.setProperty(DoArea.configPortNumber, DoSetting.tmpPortNumber.getText());
		ConfigurationXML.setProperty(DoArea.configUploadPath, DoSetting.tmpUploadPath.getText());
		ConfigurationXML.storeToXML(DoArea.configuration, DoArea.configComment);
	}

}
