package euphoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import euphoria.Picture.ChooseArea.ChooseArea;
import euphoria.Picture.CommentArea.CommentArea;
import euphoria.Picture.UploadArea.UploadArea;

/**
 * メインフレームのクラス
 * @author Nanban
 */
public class MainFrame extends JFrame {

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

	// 各コンポーネントの定義
	private ChooseArea choose;
	private CommentArea comment;
	private UploadArea upload;

	// 初期化フィールド
	{
		width = 960;
		height = 720;
		minWidth = 640;
		minHeight = 480;
		title = "Euphoria Pictures";
	}

	/**
	 * コンストラクタ
	 */
	public MainFrame() {

		// メインフレーム設定
		setSize(width, height);
		setTitle(title);
		startUp();

		// 各コンポーネントの定義
		choose = new ChooseArea();
		comment = new CommentArea();
		upload = new UploadArea();

		// GridBagLayoutの定義
		layout = new GridBagLayout();
		setLayout(layout);
		gbc = new GridBagConstraints();
		gridSetUp();

		// TitledBorderの設定
		titledSetUp();

		// コンポーネントの組み込み
		Container contentPane = getContentPane();
		contentPane.add(choose);
		contentPane.add(comment);
		contentPane.add(upload);

	}

	/**
	 * ウィンドウの初期処理をしてくれるメソッド
	 */
	private void startUp() {
		// 閉じるボタンでプログラム終了
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 画面中央に表示
		setLocationRelativeTo(null);
		// レイアウト方式はBorderLayout
		setLayout(new BorderLayout());
		// 最小サイズの設定
		setMinimumSize(new Dimension(minWidth, minHeight));

		// ウィンドウのUIはWindowsで
		String lafClassName = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		// String lafClassName = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
		try {
			UIManager.setLookAndFeel(lafClassName);
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void gridSetUp() {
		gbc.fill = GridBagConstraints.BOTH;

		gbc.weightx = 1.0d;
		gbc.weighty = 1.0d;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(10, 10, 10, 10);
		layout.addLayoutComponent(choose, gbc);

		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.weighty = 0.0d;
		gbc.insets = new Insets(0, 10, 10, 10);
		layout.addLayoutComponent(comment, gbc);

		gbc.gridy = 1;
		gbc.gridx = 1;
		gbc.weightx = 0.0d;
		gbc.insets = new Insets(0, 0, 10, 10);
		layout.addLayoutComponent(upload, gbc);
	}

	private void titledSetUp() {
		// choose
		LineBorder chooseBorder = new LineBorder(Color.black, 1);
		TitledBorder chooseTitle = new TitledBorder(chooseBorder, "写真の選択");
		choose.setBorder(chooseTitle);

		// comment
		LineBorder commentBorder = new LineBorder(Color.black, 1);
		TitledBorder commentTitle = new TitledBorder(commentBorder, "写真の情報を入力");
		comment.setBorder(commentTitle);

		// upload
		LineBorder uploadBorder = new LineBorder(Color.black, 1);
		TitledBorder uploadTitle = new TitledBorder(uploadBorder, "各種操作");
		upload.setBorder(uploadTitle);
	}

}
