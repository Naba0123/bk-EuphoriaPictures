package euphoria.Picture.ChooseArea;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ChooseShow extends JLabel {

	private double standardX;
	private double standardY;
	private int width;
	private int height;

	private BufferedImage image;

	public ChooseShow(){
	}

	public void showIcon(String str) {
		try {
			image = ImageIO.read(new File(str));
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
		getStandardSize();
		image = resizeImage();
		ImageIcon ii = new ImageIcon(image);
		setIcon(ii);
		this.setHorizontalAlignment(JLabel.CENTER);
		image = null;
		ii = null;
	}

	public BufferedImage resizeImage() {

		BufferedImage resizedImage = null;
		// 縮小する必要があるかを判定
		if (height != image.getHeight()) {
			calcSize(); // 長辺を基準にして縮小後のサイズを求める
			resizedImage = new BufferedImage(width, height, image.getType());
			// シャギー軽減のためのヒントあり 綺麗だが処理は遅い
			resizedImage.getGraphics().drawImage(image.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING), 0, 0, width, height, null);
		} else {
			resizedImage = image;
		}
		return resizedImage;
	}

	// 縮小後のサイズを計算
	private void calcSize() {
		width = image.getWidth();
		height = image.getHeight();
		double magnification = 0;
		double magnificationX = 0;
		double magnificationY = 0;
		// 長辺を基準として縦横の縮小倍率を求める
		magnificationX = (standardX / (double) height);
		magnificationY = (standardY / (double) width);
		magnification = Math.min(magnificationX, magnificationY);
		if (magnification < 1) {
			height = (int) (height * magnification);
			width = (int) (width * magnification);
		}
	}

	private void getStandardSize() {
		Dimension maxSize = getSize();
		standardX = (int) maxSize.getHeight();
		standardY = (int) maxSize.getWidth();
	}

}
