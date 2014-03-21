package euphoria.Picture.Do.Test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import euphoria.Picture.Do.Setting.SettingCancel;

public class DoTest extends JFrame {

	// Panelの設定
	private JPanel textPanel;
	private JPanel buttonPanel;

	// 結果テキストの設定
	static JLabel checkSetting;
	static JLabel checkSettingResult;
	static JLabel checkConnect;
	static JLabel checkConnectResult;
	static JLabel checkFileTransport;
	static JLabel checkFileTransportResult;

	// デフォルトウィンドウサイズ
	private int width;
	private int height;
	// 最小ウィンドウサイズ
	private int minWidth;
	private int minHeight;
	// ウィンドウのタイトル
	private String title;

	// レイアウト関連
	private GridBagLayout layoutPanel;
	private GridBagConstraints gbcPanel;
	private GridBagLayout layoutTest;
	private GridBagConstraints gbcTest;

	static DoSFTPTest testSFTP;
	static JLabel testResult;

	// 初期化フィールド
	{
		width = 350;
		height = 260;
		minWidth = 350;
		minHeight = 280;
		title = "接続テスト";

		textPanel = new JPanel();
		buttonPanel = new JPanel();

		testSFTP = new DoSFTPTest("テスト実行");
		testResult = new JLabel("テストしてください");

		checkSetting = new JLabel("アップロード設定のチェック :");
		checkSettingResult = new JLabel();
		checkConnect = new JLabel("コネクション確立のチェック :");
		checkConnectResult = new JLabel();
		checkFileTransport = new JLabel("ファイル転送のチェック :");
		checkFileTransportResult = new JLabel();
	}

	DoTest() {

		setSize(width, height);
		setTitle(title);
		startUp();

		setGrid();

		titledSetUp();

		addComponents();

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
		layoutPanel = new GridBagLayout();
		setLayout(layoutPanel);
		gbcPanel = new GridBagConstraints();

		layoutTest = new GridBagLayout();
		textPanel.setLayout(layoutTest);
		gbcTest = new GridBagConstraints();
	}

	private void addComponents() {

		textPanel.add(checkSetting);
		textPanel.add(checkSettingResult);
		textPanel.add(checkConnect);
		textPanel.add(checkConnectResult);
		textPanel.add(checkFileTransport);
		textPanel.add(checkFileTransportResult);
		textPanel.add(testResult);

		buttonPanel.add(testSFTP);
		buttonPanel.add(new SettingCancel());

		getContentPane().add(textPanel);
		getContentPane().add(buttonPanel);
	}

	private void setGrid() {
		gbcPanel.insets = new Insets(10, 10, 5, 10);
		gbcPanel.fill = GridBagConstraints.BOTH;
		gbcPanel.weightx = 1.0d;
		gbcPanel.weighty = 1.0d;
		layoutPanel.setConstraints(textPanel, gbcPanel);

		gbcPanel.insets = new Insets(0, 10, 10, 10);
		gbcPanel.gridy = 1;
		gbcPanel.weightx = 0.0d;
		gbcPanel.weighty = 0.0d;
		gbcPanel.fill = gbcPanel.fill = GridBagConstraints.NONE;
		layoutPanel.setConstraints(buttonPanel, gbcPanel);

		gbcTest.insets = new Insets(10, 10, 10, 10);
		layoutTest.setConstraints(checkSetting, gbcTest);
		gbcTest.gridx = 1;
		layoutTest.setConstraints(checkSettingResult, gbcTest);
		gbcTest.gridx = 0;
		gbcTest.gridy = 1;
		layoutTest.setConstraints(checkConnect, gbcTest);
		gbcTest.gridx = 1;
		layoutTest.setConstraints(checkConnectResult, gbcTest);
		gbcTest.gridx = 0;
		gbcTest.gridy = 2;
		layoutTest.setConstraints(checkFileTransport, gbcTest);
		gbcTest.gridx = 1;
		layoutTest.setConstraints(checkFileTransportResult, gbcTest);
		gbcTest.gridx = 0;
		gbcTest.gridy = 3;
		gbcTest.gridwidth = 2;
		layoutTest.setConstraints(testResult, gbcTest);

	}

	private void titledSetUp() {
		// settingPanel
		LineBorder textBorder = new LineBorder(Color.black, 1);
		TitledBorder textTitle = new TitledBorder(textBorder, "テスト結果");
		textPanel.setBorder(textTitle);
	}

}
