package euphoria.Picture.CommentArea;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CommentArea extends JPanel {

	// GridBagLayout
	GridBagLayout layout;
	GridBagConstraints gbc;

	// コンポーネントの定義
	JLabel titleLabel;
	JTextField titleField;
	JLabel explanationLabel;
	JTextField explanationField;


	public CommentArea() {

		// CommentAreaの初期設定
		layout = new GridBagLayout();
		setLayout(layout);
		gbc = new GridBagConstraints();

		// 各コンポーネントの定義
		titleLabel = new JLabel("タイトル");
		titleField = new JTextField("タイトルを入力してください");
		explanationLabel = new JLabel("説明");
		explanationField = new JTextField("説明を入力してください");

		gridSetUp();

		// 各コンポーネントの組み込み
		add(titleLabel);
		add(titleField);
		add(explanationLabel);
		add(explanationField);

	}

	private void gridSetUp() {
		// 各コンポーネントのgridの設定
		gbc.weightx = 0.0d;
		gbc.insets = new Insets(5, 10, 5, 10);
		layout.setConstraints(titleLabel, gbc); // titleLabel : 0, 0
		gbc.gridx = 1;
		gbc.weightx = 3.0d;
		gbc.fill = GridBagConstraints.BOTH;
		layout.setConstraints(titleField, gbc); // titleField : 1, 0
		gbc.gridy = 1;
		layout.setConstraints(explanationField, gbc); // explanationField : 1, 1
		gbc.gridx = 0;
		gbc.weightx = 0.0d;
		gbc.fill = GridBagConstraints.NONE;
		layout.setConstraints(explanationLabel, gbc); // explanationLabel : 0, 1
	}
}
