package euphoria.Picture.DoArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class ChooseKey extends JButton implements ActionListener {

	ChooseKey(String str) {
		setText(str);
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		JFileChooser filechooser = new JFileChooser("c:\\users");

		int selected = filechooser.showOpenDialog(this);
		if (selected == JFileChooser.APPROVE_OPTION) {
			File file = filechooser.getSelectedFile();
			DoSetting.tmpKeyPath.setText(file.getAbsolutePath());
		} else if (selected == JFileChooser.CANCEL_OPTION) {
			// DoSetting.tmpKeyPath.setText("選択されていません");
		} else if (selected == JFileChooser.ERROR_OPTION) {
			DoSetting.tmpKeyPath.setText("エラー又は取消しがありました");
		}

	}
}
