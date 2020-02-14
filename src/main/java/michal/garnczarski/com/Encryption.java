package michal.garnczarski.com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Encryption {

	private JFrame frmEncryption;
	private final ButtonGroup encryptionMethodButtonGroup = new ButtonGroup();
	private JTextField keyTextField;
	private JTextField textToEncryptTextField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Encryption window = new Encryption();
					window.frmEncryption.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Encryption() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEncryption = new JFrame();
		frmEncryption.setTitle("Encryption");
		frmEncryption.setBounds(100, 100, 252, 566);
		frmEncryption.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmEncryption.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblSelectEncryptionMethod = new JLabel("Select method of encryption/decryption:");
		lblSelectEncryptionMethod.setBounds(10, 11, 216, 14);
		panel.add(lblSelectEncryptionMethod);
		
		JRadioButton rdbtnCaesarCipher = new JRadioButton("Caesar cipher");
		encryptionMethodButtonGroup.add(rdbtnCaesarCipher);
		rdbtnCaesarCipher.setSelected(true);
		rdbtnCaesarCipher.setBounds(10, 32, 143, 23);
		panel.add(rdbtnCaesarCipher);
		
		JRadioButton rdbtnVigenereCipher = new JRadioButton("Vigenere cipher");
		encryptionMethodButtonGroup.add(rdbtnVigenereCipher);
		rdbtnVigenereCipher.setBounds(10, 58, 143, 23);
		panel.add(rdbtnVigenereCipher);
		
		JLabel lblDefineKey = new JLabel("Define the key:");
		lblDefineKey.setBounds(10, 113, 177, 14);
		panel.add(lblDefineKey);
		
		keyTextField = new JTextField();
		keyTextField.setBounds(10, 138, 216, 20);
		panel.add(keyTextField);
		keyTextField.setColumns(10);
		
		JLabel lblEnterText = new JLabel("Enter text to encrypt/decrypt:");
		lblEnterText.setBounds(10, 194, 177, 14);
		panel.add(lblEnterText);
		
		textToEncryptTextField = new JTextField();
		textToEncryptTextField.setColumns(10);
		textToEncryptTextField.setBounds(10, 217, 216, 100);
		panel.add(textToEncryptTextField);
		
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.setBounds(10, 328, 89, 23);
		panel.add(btnEncrypt);
		
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDecrypt.setBounds(137, 328, 89, 23);
		panel.add(btnDecrypt);
		
		JLabel lblEncrypteddecryptedText = new JLabel("Encrypted/decrypted text:");
		lblEncrypteddecryptedText.setBounds(10, 387, 177, 14);
		panel.add(lblEncrypteddecryptedText);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 412, 216, 100);
		panel.add(textField);
	}
}
