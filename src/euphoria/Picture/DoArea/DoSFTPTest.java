package euphoria.Picture.DoArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class DoSFTPTest extends JButton implements ActionListener {

	private String messagePath;

	{
		messagePath = "/home/" + DoArea.userNameField.getText() + "/" + "MessageByServer";
	}

	DoSFTPTest(String title) {
		setText(title);
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		DoTest.checkSettingResult.setText("");
		DoTest.checkConnectResult.setText("");
		DoTest.checkFileTransportResult.setText("");
		DoTest.testResult.setText("");

		// 設定テスト
		if (checkSetting()) {
		} else {
			DoTest.checkSettingResult.setText("NG");
			DoTest.testResult.setText("接続テストに失敗しましたよ。");
			return;
		}
		DoTest.checkSettingResult.setText("OK");

		JSch jsch = new JSch();
		Session session;
		try {
			// 秘密鍵の登録
			jsch.addIdentity(DoArea.keyPathField.getText(), DoArea.passWordField.getText());
			// connect session
			session = jsch.getSession(DoArea.userNameField.getText(), DoArea.hostNameField.getText(), Integer.valueOf(DoArea.portNumberField.getText()));
			// known_hostsのチェックをスルーする
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
		} catch (JSchException es) {
			es.printStackTrace();
			DoTest.checkConnectResult.setText("NG");
			DoTest.testResult.setText("接続テストに失敗しました");
			return;
		}
		DoTest.checkConnectResult.setText("OK");

		ChannelSftp channel;
		try {
			// sftp remotely
			channel = (ChannelSftp) session.openChannel("sftp");
			channel.connect();
			// サーバからのメッセージファイルを受信
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			channel.get(messagePath, baos);
			DoTest.testResult.setText(baos.toString("UTF-8"));
			channel.disconnect();
			session.disconnect();
			DoTest.checkFileTransportResult.setText("OK");
		} catch (JSchException | SftpException | UnsupportedEncodingException es) {
			es.printStackTrace();
			DoTest.checkFileTransportResult.setText("NG");
			DoTest.testResult.setText("接続できませんでした。");
			return;
		}

	}

	private boolean checkSetting() {
		if (DoArea.userNameField.getText().isEmpty())
			return false;
		if (DoArea.passWordField.getText().isEmpty())
			return false;
		if (DoArea.keyPathField.getText().isEmpty())
			return false;
		if (DoArea.hostNameField.getText().isEmpty())
			return false;
		if (DoArea.portNumberField.getText().isEmpty())
			return false;
		if (DoArea.uploadPathField.getText().isEmpty())
			return false;
		return true;
	}

}
