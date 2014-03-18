package euphoria.Picture.ChooseArea;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

public class ChooseFile extends JButton implements ActionListener {

	private ChooseText fileText;
	private ChooseShow fileShow;

	/**
	 * コンストラクタ
	 * @param ct 出力文字として対応付けるChooseText extends JLabelのインスタンス
	 * @param str ボタンの名前
	 */
	ChooseFile(ChooseText ct, ChooseShow cs, String str) {
		fileText = ct;
		fileShow = cs;
		setText(str);
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		JFileChooser filechooser = new JFileChooser("c:\\users");
		filechooser.setAccessory(new ImagePreview(filechooser));

		int selected = filechooser.showOpenDialog(this);
		if (selected == JFileChooser.APPROVE_OPTION) {
			File file = filechooser.getSelectedFile();
			fileText.setLabelText(file.getAbsolutePath());
			fileShow.showIcon(file.getAbsolutePath());
		} else if (selected == JFileChooser.CANCEL_OPTION) {
			fileText.setLabelText("選択されていません");
		} else if (selected == JFileChooser.ERROR_OPTION) {
			fileText.setLabelText("エラー又は取消しがありました");
		}

	}

	//http://docs.oracle.com/javase/tutorial/uiswing/examples/components/FileChooserDemo2Project/src/components/ImagePreview.java
	class ImagePreview extends JComponent implements PropertyChangeListener {
		private final int PREVIEW_WIDTH = 400;
		private static final int PREVIEW_MARGIN = 10;
		private ImageIcon thumbnail = null;
		private File file = null;

		public ImagePreview(JFileChooser fc) {
			setPreferredSize(new Dimension(PREVIEW_WIDTH + PREVIEW_MARGIN * 2, 50));
			fc.addPropertyChangeListener(this);
		}

		public void loadImage() {
			if (file == null) {
				thumbnail = null;
				return;
			}
			ImageIcon tmpIcon = new ImageIcon(file.getPath());
			if (tmpIcon.getIconWidth() > PREVIEW_WIDTH) {
				//Image img = tmpIcon.getImage().getScaledInstance(
				//     PREVIEW_WIDTH,-1,Image.SCALE_DEFAULT);
				//The Perils of Image.getScaledInstance() | Java.net
				//http://today.java.net/pub/a/today/2007/04/03/perils-of-image-getscaledinstance.html
				float scale = PREVIEW_WIDTH / (float) tmpIcon.getIconWidth();
				int newW = (int) (tmpIcon.getIconWidth() * scale);
				int newH = (int) (tmpIcon.getIconHeight() * scale);
				BufferedImage img = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2 = (Graphics2D) img.getGraphics();
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
						RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				g2.drawImage(tmpIcon.getImage(), 0, 0, newW, newH, null);
				g2.dispose();

				thumbnail = new ImageIcon(img);
			} else {
				thumbnail = tmpIcon;
			}
		}

		@Override
		public void propertyChange(PropertyChangeEvent e) {
			boolean update = false;
			String prop = e.getPropertyName();
			if (JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(prop)) {
				file = null;
				update = true;
			} else if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(prop)) {
				file = (File) e.getNewValue();
				update = true;
			}
			if (update) {
				thumbnail = null;
				if (isShowing()) {
					loadImage();
					repaint();
				}
			}
		}

		@Override
		protected void paintComponent(Graphics g) {
			if (thumbnail == null) {
				loadImage();
			}
			if (thumbnail != null) {
				int x = getWidth() / 2 - thumbnail.getIconWidth() / 2;
				int y = getHeight() / 2 - thumbnail.getIconHeight() / 2;
				if (y < 0)
					y = 0;
				if (x < PREVIEW_MARGIN)
					x = PREVIEW_MARGIN;
				thumbnail.paintIcon(this, g, x, y);
			}
		}
	}
}