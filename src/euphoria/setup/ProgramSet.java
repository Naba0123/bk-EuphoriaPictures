package euphoria.setup;

import java.awt.Dialog;
import java.awt.Dimension;

import javax.swing.JDialog;
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

	/**
	 * ダイアログの初期設定を行う
	 * @param jd 操作対象のJDialogインスタンス
	 * @param t ダイアログのタイトル
	 * @param w ダイアログの横幅
	 * @param h ダイアログの高さ
	 * @param mw ダイアログの最小横幅
	 * @param mh ダイアログの最小高さ
	 */
	public static void DialogSet(JDialog jd, String t, int w, int h, int mw, int mh) {
		// ダイアログのタイトルの設定
		jd.setTitle(t);
		// ダイアログ最小サイズの設定
		jd.setMinimumSize(new Dimension(mw, mh));
		// ダイアログ初期サイズの設定
		jd.setSize(new Dimension(w, h));
		// ダイアログの表示位置の設定
		jd.setLocationRelativeTo(null);
		// 他フレームの操作を拒否させる
		jd.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
	}

}
