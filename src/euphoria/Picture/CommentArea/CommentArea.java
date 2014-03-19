package euphoria.Picture.CommentArea;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CommentArea extends JPanel {

	// GridBagLayout
	private GridBagLayout layout;
	private GridBagConstraints gbc;

	// コンポーネントの定義
	// タイトル
	public JLabel titleLabel;
	public JTextField titleField;
	// 説明
	public JLabel explanationLabel;
	public JTextField explanationField;
	// 撮影日時
	public JLabel dateLabel;
	public DateFormat df;
	public JFormattedTextField dateField;
	// 備考
	public JLabel otherLabel;
	public JTextField otherField;

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
		dateLabel = new JLabel("撮影日時");
		df = DateFormat.getDateInstance();
		dateField = new JFormattedTextField(df);
		dateField.setValue(new Date());
		otherLabel = new JLabel("備考");
		otherField = new JTextField("備考を入力してください");

		gridSetUp();

		// 各コンポーネントの組み込み
		add(titleLabel);
		add(titleField);
		add(explanationLabel);
		add(explanationField);
		add(dateLabel);
		add(dateField);
		add(otherLabel);
		add(otherField);

	}

	private void gridSetUp() {
		// 各コンポーネントのgridの設定

		// Label
		gbc.weightx = 0.0d;
		gbc.insets = new Insets(5, 10, 5, 3);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		layout.setConstraints(titleLabel, gbc); // titleLabel : 0, 0
		gbc.gridy = 1;
		layout.setConstraints(explanationLabel, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		layout.setConstraints(dateLabel, gbc);
		gbc.gridy = 1;
		layout.setConstraints(otherLabel, gbc);

		// Field
		gbc.insets = new Insets(5, 3, 5, 10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0d;
		layout.setConstraints(titleField, gbc);
		gbc.gridy = 1;
		layout.setConstraints(explanationField, gbc);
		gbc.gridx = 3;
		gbc.gridy = 0;
		layout.setConstraints(dateField, gbc);
		gbc.gridy = 1;
		layout.setConstraints(otherField, gbc);

	}
}
