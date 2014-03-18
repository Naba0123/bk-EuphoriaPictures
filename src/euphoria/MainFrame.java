package euphoria;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import euphoria.PictureChooseArea.ChooseArea;
import euphoria.PictureCommentArea.CommentArea;

/**
 * メインフレームのクラス
 * @author Nanban
 */
public class MainFrame extends JFrame {

	/** ウィンドウの幅 */
	private int winWidth = 960;
	/** ウィンドウの高さ */
	private int winHeight = 720;
	/** ウィンドウのタイトル */
	private String winTitle = "Euphoria Pictures";

	/**
	 * コンストラクタ
	 */
	public MainFrame() {

		// メインフレーム設定
		setSize(winWidth, winHeight);
		setTitle(winTitle);
		startUp();

		// 各コンポーネントの定義
		ChooseArea choose = new ChooseArea();
		CommentArea comment = new CommentArea();


		// コンポーネントの組み込み
		Container contentPane = getContentPane();
		contentPane.add(choose, BorderLayout.SOUTH);
		contentPane.add(comment, BorderLayout.NORTH);


	}

	/**
	 * ウィンドウの初期処理をしてくれるメソッド
	 */
	private void startUp() {
		// リサイズ不可
//		setResizable(false);
		// 閉じるボタンでプログラム終了
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 画面中央に表示
		setLocationRelativeTo(null);
		// レイアウト方式はBorderLayout
		setLayout(new BorderLayout());

		// ウィンドウのUIはWindowsで
		String lafClassName = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
//		String lafClassName = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
		try {
			UIManager.setLookAndFeel(lafClassName);
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
