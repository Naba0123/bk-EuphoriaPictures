package euphoria.Picture.Do;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import euphoria.Picture.Do.Setting.ButtonSetting;
import euphoria.Picture.Do.Test.ButtonTest;

public class DoArea extends JPanel {

	public static JLabel userNameLabel;
	public static JLabel passWordLabel;
	public static JLabel keyPathLabel;
	public static JLabel hostNameLabel;
	public static JLabel portNumberLabel;
	public static JLabel uploadPathLabel;

	public static JLabel userNameField;
	public static JLabel passWordField;
	public static JLabel keyPathField;
	public static JLabel hostNameField;
	public static JLabel portNumberField;
	public static JLabel uploadPathField;

	// 初期化
	{
		// Label
		userNameLabel = new JLabel("ユーザー名");
		passWordLabel = new JLabel("パスワード");
		keyPathLabel = new JLabel("秘密鍵パス");
		hostNameLabel = new JLabel("ホスト名");
		portNumberLabel = new JLabel("ポート番号");
		uploadPathLabel = new JLabel("アップロード先");
		// TextField
		userNameField = new JLabel("USERNAME");
		passWordField = new JLabel("PASSWORD");
		keyPathField = new JLabel("c:\\");
		hostNameField = new JLabel("hogehoge.com");
		portNumberField = new JLabel("22");
		uploadPathField = new JLabel("/var/www/tmp/");
	}

	public DoArea() {

		// 初期設定
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();

		// コンポーネントの定義
		ButtonSetting setting = new ButtonSetting("アップロード設定");
		ButtonTest test = new ButtonTest("接続テスト");
		JButton upload = new JButton("アップロード実行");

		// gridBagLayoutの設定
		gbc.insets = new Insets(5, 5, 5, 5);
		layout.setConstraints(setting, gbc);

		gbc.gridy = 1;
		layout.setConstraints(test, gbc);

		gbc.gridy = 2;
		layout.setConstraints(upload, gbc);

		// コンポーネントの組み込み
		add(setting);
		add(test);
		add(upload);

	}

}
