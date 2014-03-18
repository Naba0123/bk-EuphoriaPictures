package euphoria.Picture.ChooseArea;

import javax.swing.JLabel;

public class ChooseText extends JLabel {

	public String str;

	/**
	 *コンストラクタ。初期メッセージを決める。
	 * @param str 初期メッセージ
	 */
	public ChooseText(String str) {
		setText(str);
	}

	/**
	 * 指定された文字列で表示を書き換える
	 * @param str 書き換えたい文字列
	 */
	public void setLabelText(String str) {
		setText(str);
		this.str = str;
	}

	/**
	 * 現在表示されている値を返す
	 * @return 現在表示されている文字列
	 */
	public String getLabelString() {
		return str;
	}

}
