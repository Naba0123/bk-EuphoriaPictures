package euphoria.Picture.UploadArea;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class UploadArea extends JPanel {

	public UploadArea() {

		// 初期設定
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();

		// コンポーネントの定義
		JButton button = new JButton("アップロード設定");
		JButton button2 = new JButton("接続確認");
		JButton button3 = new JButton("アップロードの実行");

		// gridBagLayoutの設定
		gbc.insets = new Insets(5, 5, 5, 5);
		layout.setConstraints(button, gbc);

		gbc.gridy = 1;
		layout.setConstraints(button2, gbc);

		gbc.gridy = 2;
		layout.setConstraints(button3, gbc);

		// コンポーネントの組み込み
		add(button);
		add(button2);
		add(button3);

	}

}
