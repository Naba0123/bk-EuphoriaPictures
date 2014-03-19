package euphoria.Picture.DoArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;

public class ButtonTest extends JButton implements ActionListener {

	ButtonTest(String title) {
		setText(title);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(getMemoryInfo());
	}

	public static String getMemoryInfo() {
	    DecimalFormat f1 = new DecimalFormat("#,###KB");
	    DecimalFormat f2 = new DecimalFormat("##.#");
	    long free = Runtime.getRuntime().freeMemory() / 1024;
	    long total = Runtime.getRuntime().totalMemory() / 1024;
	    long max = Runtime.getRuntime().maxMemory() / 1024;
	    long used = total - free;
	    double ratio = (used * 100 / (double)total);
	    String info =
	    "Java メモリ情報 : 合計=" + f1.format(total) + "、" +
	    "使用量=" + f1.format(used) + " (" + f2.format(ratio) + "%)、" +
	    "使用可能最大="+f1.format(max);
	    return info;
	}

}
