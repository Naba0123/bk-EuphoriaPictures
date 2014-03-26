package euphoria.pictures.doArea;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import euphoria.pictures.doSetting.DoSetting;
import euphoria.pictures.doTest.DoTest;
import euphoria.pictures.doUpload.DoUpload;
import euphoria.setup.ConfigurationXML;

public class DoArea extends JPanel implements ActionListener {

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

	public static String configuration;
	public static String configComment;
	public static String configUserName;
	public static String configPassWord;
	public static String configKeyPath;
	public static String configHostName;
	public static String configPortNumber;
	public static String configUploadPath;

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
		passWordField = new JLabel("");
		keyPathField = new JLabel("c:\\");
		hostNameField = new JLabel("hogehoge.com");
		portNumberField = new JLabel("22");
		uploadPathField = new JLabel("/var/www/tmp/");
		// Configuration
		configuration = "config.xml";
		configComment = "Euphoria Pictures用設定ファイル";
		configUserName = "username";
		configPassWord = "password";
		configKeyPath = "keypath";
		configHostName = "hostname";
		configPortNumber = "port";
		configUploadPath = "upload";
	}

	public DoArea() {

		// 設定ファイルの読み込み
		setConfig();

		// 初期設定
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();

		// コンポーネントの定義
		JButton setting = new JButton("アップロード設定");
		JButton test = new JButton("接続テスト");
		JButton upload = new JButton("アップロード実行");

		// コンポーネントのアクション設定
		setting.addActionListener(this);
		setting.setActionCommand("setting");
		test.addActionListener(this);
		test.setActionCommand("test");
		upload.addActionListener(this);
		upload.setActionCommand("upload");

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

	private void setConfig() {
		new ConfigurationXML();
		if (ConfigurationXML.loadXML(configuration)) {
			userNameField.setText(ConfigurationXML.getProperty(configUserName));
			keyPathField.setText(ConfigurationXML.getProperty(configKeyPath));
			hostNameField.setText(ConfigurationXML.getProperty(configHostName));
			portNumberField.setText(ConfigurationXML.getProperty(configPortNumber));
			uploadPathField.setText(ConfigurationXML.getProperty(configUploadPath));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("setting")) {
			new DoSetting();
		} else if (command.equals("test")) {
			new DoTest();
		} else if (command.equals("upload")) {
			new DoUpload();
		}
	}

}
