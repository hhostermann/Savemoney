import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class AlterarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarUsuario frame = new AlterarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AlterarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(136, 272, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(379, 272, 89, 23);
		contentPane.add(btnCancelar);
		
		textField = new JTextField();
		textField.setBounds(251, 131, 117, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(179, 134, 46, 14);
		contentPane.add(lblUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(251, 192, 117, 20);
		contentPane.add(passwordField);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setBounds(179, 195, 46, 14);
		contentPane.add(lblSenha);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(251, 63, 117, 20);
		contentPane.add(comboBox);
	}
}
