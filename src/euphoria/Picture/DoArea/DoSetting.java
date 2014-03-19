package euphoria.Picture.DoArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class DoSetting extends JFrame {

	// 枠JPanelの定義
	JPanel settingPanel;
	JPanel selectPanel;

	// selectButtonの定義
	SettingOK settingOK;
	SettingCancel settingCancel;

	// デフォルトウィンドウサイズ
	private int width;
	private int height;
	// 最小ウィンドウサイズ
	private int minWidth;
	private int minHeight;
	// ウィンドウのタイトル
	private String title;

	// レイアウト関連
	private GridBagLayout layout;
	private GridBagConstraints gbc;

	// 一時変数
	static JTextField tmpUserName;
	static JTextField tmpPassWord;
	static ChooseKey tmpKeyPathButton;
	static JTextField tmpKeyPath;
	static JTextField tmpHostName;
	static JTextField tmpPortNumber;
	static JTextField tmpUploadPath;

	// 初期化フィールド
	{
		width = 480;
		height = 260;
		minWidth = 380;
		minHeight = 260;
		title = "アップロード設定";

		tmpUserName = new JTextField(DoArea.userNameField.getText());
		tmpPassWord = new JTextField(DoArea.passWordField.getText());
		tmpKeyPathButton = new ChooseKey("秘密鍵の選択");
		tmpKeyPath = new JTextField(DoArea.keyPathField.getText());
		tmpHostName = new JTextField(DoArea.hostNameField.getText());
		tmpPortNumber = new JTextField(DoArea.portNumberField.getText());
		tmpUploadPath = new JTextField(DoArea.uploadPathField.getText());

		settingPanel = new JPanel();
		selectPanel = new JPanel();

		settingOK = new SettingOK();
		settingCancel = new SettingCancel();
	}

	DoSetting() {
		// メインフレーム設定
		setSize(width, height);
		setTitle(title);
		startUp();

		// Gridの設定
		setGrid();

		// コンポーネントの追加
		addCompornents();

	}

	private void startUp() {
		// 閉じるボタンでウィンドウを閉じる
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// 画面中央に表示
		setLocationRelativeTo(null);
		// 最小サイズの設定
		setMinimumSize(new Dimension(minWidth, minHeight));

		// ウィンドウのUIはWindowsで
		String lafClassName = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		try {
			UIManager.setLookAndFeel(lafClassName);
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Gridの定義
		layout = new GridBagLayout();
		settingPanel.setLayout(layout);
		gbc = new GridBagConstraints();

	}

	private void setGrid() {
		gbc.insets = new Insets(5, 5, 5, 5);
		layout.addLayoutComponent(DoArea.userNameLabel, gbc);
		gbc.gridy = 1;
		layout.addLayoutComponent(DoArea.passWordLabel, gbc);
		gbc.gridy = 2;
		layout.addLayoutComponent(DoArea.keyPathLabel, gbc);
		gbc.gridx = 2;
		layout.addLayoutComponent(tmpKeyPathButton, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		layout.addLayoutComponent(DoArea.hostNameLabel, gbc);
		gbc.gridy = 4;
		layout.addLayoutComponent(DoArea.portNumberLabel, gbc);
		gbc.gridy = 5;
		layout.addLayoutComponent(DoArea.uploadPathLabel, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0d;
		gbc.gridwidth = 2;
		layout.addLayoutComponent(tmpUserName, gbc);
		gbc.gridy = 1;
		layout.addLayoutComponent(tmpPassWord, gbc);
		gbc.gridwidth = 1;
		gbc.gridy = 2;
		layout.addLayoutComponent(tmpKeyPath, gbc);
		gbc.gridwidth = 2;
		gbc.gridy = 3;
		layout.addLayoutComponent(tmpHostName, gbc);
		gbc.gridy = 4;
		layout.addLayoutComponent(tmpPortNumber, gbc);
		gbc.gridy = 5;
		layout.addLayoutComponent(tmpUploadPath, gbc);

	}

	private void addCompornents() {
		// コンポーネント追加
		settingPanel.add(DoArea.userNameLabel);
		settingPanel.add(tmpUserName);
		settingPanel.add(DoArea.passWordLabel);
		settingPanel.add(tmpPassWord);
		settingPanel.add(DoArea.keyPathLabel);
		settingPanel.add(tmpKeyPathButton);
		settingPanel.add(tmpKeyPath);
		settingPanel.add(DoArea.hostNameLabel);
		settingPanel.add(tmpHostName);
		settingPanel.add(DoArea.portNumberLabel);
		settingPanel.add(tmpPortNumber);
		settingPanel.add(DoArea.uploadPathLabel);
		settingPanel.add(tmpUploadPath);

		// selectButton
		selectPanel.add(settingOK);
		selectPanel.add(settingCancel);

		// パネルの追加
		add(settingPanel, BorderLayout.CENTER);
		add(selectPanel, BorderLayout.SOUTH);
	}

}
