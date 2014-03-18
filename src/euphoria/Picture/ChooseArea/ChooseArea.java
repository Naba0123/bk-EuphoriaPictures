package euphoria.Picture.ChooseArea;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ChooseArea extends JPanel {

	public ChooseArea() {

		// ChooseAreaの初期設定
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();

		// 各コンポーネントの定義
		ChooseText text = new ChooseText("選択されていません"); // ファイル名とか
		ChooseShow show = new ChooseShow(); // 選択した画像の表示
		ChooseFile button = new ChooseFile(text, show, "画像の選択"); // 選択ボタン

		// chooseFileTextの設定
		text.setHorizontalAlignment(JLabel.RIGHT); // 右寄せ

		// 各コンポーネントのgridの設定
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0d;
		gbc.weighty = 0.0d;
		gbc.insets = new Insets(2, 2, 2, 2);
		layout.setConstraints(text, gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.0d;
		layout.setConstraints(button, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.weightx = 1.0d;
		gbc.weighty = 1.0d;
		gbc.fill = GridBagConstraints.BOTH;
		layout.setConstraints(show, gbc);


		// 各コンポーネントの組み込み
		add(show);
		add(text);
		add(button);

	}

}
