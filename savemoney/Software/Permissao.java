import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Permissao extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Permissao frame = new Permissao();
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
	public Permissao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsurioAdministrador = new JLabel("Usu\u00E1rio Administrador: ");
		lblUsurioAdministrador.setBounds(63, 61, 150, 14);
		contentPane.add(lblUsurioAdministrador);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setBounds(79, 128, 46, 14);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(154, 125, 130, 20);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(221, 58, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AdmDAO admDAO = new AdmDAO();
				Usuario usuario = new Usuario();
				usuario = admDAO.Acesso(textField.getText(), passwordField.getText());
				if (AdmDAO.acesso_adm) {
							
					NovoUsuario novousuario = new NovoUsuario();
					dispose(); // fecha a primeira tela
					novousuario.setVisible(true); // chama a segunda tela
				
				} else {
					JOptionPane.showMessageDialog(null, "Login ou Senha Incorretos");
				}
				
				
			
				
			}
			
		});
		btnAcessar.setBounds(171, 190, 89, 23);
		contentPane.add(btnAcessar);
	}
}
