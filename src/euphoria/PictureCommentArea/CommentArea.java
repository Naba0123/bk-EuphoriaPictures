package euphoria.PictureCommentArea;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CommentArea extends JPanel {

	public CommentArea() {

		// CommentAreaの初期設定
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();

		// 各コンポーネントの定義
		JLabel titleLabel = new JLabel("写真のタイトル");
		JTextField titleField = new JTextField("タイトルを入力してください");
		JLabel explanationLabel = new JLabel("写真の説明");
		JTextField explanationField = new JTextField("説明を入力してください");

		// 各コンポーネントのgridを設定する
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.1d;
		gbc.insets = new Insets(2, 2, 2, 2);
		layout.setConstraints(titleLabel, gbc); // titleLabel : 0, 0
		gbc.gridx = 1;
		gbc.weightx = 3.0d;
		gbc.fill = GridBagConstraints.BOTH;
		layout.setConstraints(titleField, gbc); // titleField : 1, 0
		gbc.gridy = 1;
		layout.setConstraints(explanationField, gbc); // explanationField : 1, 1
		gbc.gridx = 0;
		gbc.weightx = 0.1d;
		gbc.fill = GridBagConstraints.NONE;
		layout.setConstraints(explanationLabel, gbc); // explanationLabel : 0, 1

		// 各コンポーネントの組み込み
		add(titleLabel);
		add(titleField);
		add(explanationLabel);
		add(explanationField);

	}
}
