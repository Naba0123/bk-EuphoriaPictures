package euphoria.PictureChooseArea;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ChooseArea extends JPanel {

	public ChooseArea() {

		// ChooseAreaの初期設定
		setBackground(Color.orange);
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 5, 5, 5));

		// 各コンポーネントの定義
		ChooseText chooseFileText = new ChooseText("選択されていません"); // ファイル名とか
		ChooseFile chooseFileButton = new ChooseFile(chooseFileText, "画像の選択"); // 選択ボタン

		// chooseFileTextの設定
		chooseFileText.setHorizontalAlignment(JLabel.RIGHT); // 右寄せ
		chooseFileText.setBorder(new EmptyBorder(0, 0, 0, 5));

		// 各コンポーネントの組み込み
		add(chooseFileText, BorderLayout.CENTER);
		add(chooseFileButton, BorderLayout.EAST);

	}

}
