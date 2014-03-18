package euphoria;

public class EuphoriaPictures {



	/** メインフレ―ムのインスタンス */
	private MainFrame mf;

	/**
	 * メインメソッド
	 * @param args プログラム引数
	 */
	public static void main(String[] args) {
		EuphoriaPictures ep = new EuphoriaPictures();
		ep.show();
	}

	/**
	 * コンストラクタ
	 */
	EuphoriaPictures() {
		mf = new MainFrame();
	}

	/**
	 * メインフレームを表示にする
	 */
	public void show() {
		mf.setVisible(true);
	}

}