package euphoria.pictures.doUpload;

import javax.swing.JDialog;

import euphoria.setup.ProgramSet;

/**
 * アップロードを実行するためのダイアログを生成し、実行するクラス
 * @author Nanban
 *
 */
public class DoUpload {

	public static JDialog uploadDialog;

	// デフォルトダイアログサイズ
	private static final int width = 400;
	private static final int height = 300;
	// 最小ダイアログサイズ
	private static final int minWidth = 400;
	private static final int minHeight = 300;
	// ダイアログのタイトル
	private static final String title = "アップロード実行";

	public DoUpload() {
		uploadDialog = new JDialog();
		ProgramSet.DialogSet(uploadDialog, title, width, height, minWidth, minHeight);

		setup();

		uploadDialog.setVisible(true);
	}

	private void setup() {

	}

}
