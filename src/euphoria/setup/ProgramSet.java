package euphoria.setup;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ProgramSet {

	/**
	 * フレームの初期設定を行う
	 * @param jf 操作対象のJFrameインスタンス
	 * @param t フレームのタイトル
	 * @param w フレームの横幅
	 * @param h フレームの高さ
	 * @param mw フレームの最小横幅
	 * @param mh フレームの最小高さ
	 * @param op フレームの終了オプション
	 */
	public static void FrameSet(JFrame jf, String t, int w, int h, int mw, int mh, int op) {

		// フレームのタイトルの設定
		jf.setTitle(t);
		// フレーム最小サイズの設定
		jf.setMinimumSize(new Dimension(mw, mh));
		// フレーム初期サイズの設定
		jf.setSize(new Dimension(w, h));
		// フレーム終了処理の設定
		jf.setDefaultCloseOperation(op);
		// フレームの表示位置の設定
		jf.setLocationRelativeTo(null);
		// フレームのUIの設定
		String lafClassName = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		try {
			UIManager.setLookAndFeel(lafClassName);
			SwingUtilities.updateComponentTreeUI(jf);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
