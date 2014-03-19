package euphoria.Picture.ChooseArea;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooseArea extends JPanel {

	static JLabel chooseText;
	static ChooseShow chooseShow;
	static ChooseFile chooseFile;

	public ChooseArea() {

		// ChooseAreaの初期設定
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();

		// 各コンポーネントの定義
		chooseText = new JLabel("選択されていません"); // ファイル名とか
		chooseShow = new ChooseShow(); // 選択した画像の表示
		chooseFile = new ChooseFile("写真の選択"); // 選択ボタン

		// chooseFileTextの設定
		chooseText.setHorizontalAlignment(JLabel.RIGHT); // 右寄せ

		// 各コンポーネントのgridの設定
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0d;
		gbc.weighty = 0.0d;
		gbc.insets = new Insets(5, 10, 10, 10);
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(chooseText, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.0d;
		layout.setConstraints(chooseFile, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.weightx = 1.0d;
		gbc.weighty = 1.0d;
		gbc.fill = GridBagConstraints.BOTH;
		layout.setConstraints(chooseShow, gbc);

		// 各コンポーネントの組み込み
		add(chooseShow);
		add(chooseText);
		add(chooseFile);

	}

}
