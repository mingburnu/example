package code.encrypt;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Encoder {

	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private JTextField textField;

	public Encoder() {
		prepareGUI();
	}

	public static void main(String[] args) {
		Encoder encoder = new Encoder();
		encoder.showEventDemo();
	}

	private void prepareGUI() {
		mainFrame = new JFrame("Passwrod Encryptor (commons-codec-1.10.jar)");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 1));

		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);

		statusLabel.setSize(350, 100);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		textField = new JTextField(10);
		textField.setEditable(true);

		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(textField);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}

	private void showEventDemo() {
		headerLabel.setText("Please input password and click button.");

		JButton submitButton = new JButton("Submit");

		submitButton.setActionCommand("Submit");

		submitButton.addActionListener(new ButtonClickListener());

		controlPanel.add(textField);
		controlPanel.add(submitButton);

		mainFrame.setVisible(true);
	}

	private class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str = textField.getText();

			try {
				str = mixNormal(str);

				byte[] utf8 = str.getBytes("UTF8");

				str = new String(
						org.apache.commons.codec.binary.Base64
								.encodeBase64(utf8));

			} catch (Exception exception) {
				str = "Error";
			}

			statusLabel.setText(str);
		}
	}

	private static String mixNormal(String str) {
		Date currentTime = new Date();
		SimpleDateFormat timeFormatter = new SimpleDateFormat("ssSSS",
				Locale.TAIWAN);
		String time = timeFormatter.format(currentTime);
		str = time.substring(0, 2) + str + time.substring(2, 5);
		return str;
	}
}
