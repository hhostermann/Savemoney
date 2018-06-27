import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class NovoUsuario extends JFrame {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost/savemoney";
	
	
	
	private JPanel contentPane;
	private JTextField textNome;
	private JPasswordField passwordSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoUsuario frame = new NovoUsuario();
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
	public NovoUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Novo Usu\u00E1rio: ");
		lblUsurio.setBounds(55, 50, 86, 14);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setBounds(55, 111, 46, 14);
		contentPane.add(lblSenha);
		
		textNome = new JTextField();
		textNome.setBounds(165, 47, 86, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = textNome.getText().trim(); // trim() pega só o que esta escrito no campo
				String senha = passwordSenha.getText().trim();

				Connection connection = null; // gerencia a conexao
				Statement statement = null; // instrucao de consulta

				try {
					Class.forName(JDBC_DRIVER);
					connection = DriverManager.getConnection(DATABASE_URL, "root", "");
					statement = connection.createStatement();
					statement.execute(	"INSERT INTO `tbl_usuario` (`loginUsuario`, `senhaUsuario`) VALUES ('"+ nome +"', '"+ senha +"')");
				} // fim do try
					
				catch (SQLException sqlException) {
						sqlException.printStackTrace();
						System.exit(1);
					} // fim do catch
					catch (ClassNotFoundException classNotFound) {
						classNotFound.printStackTrace();
						System.exit(1);
					} // fim do catch
					finally // assegura que a instrucao e conexao sao fechadas
							// adequadamente
					{
						try {
							statement.close();
							connection.close();
						} // fim do try
						catch (Exception exception) {
							exception.printStackTrace();
							System.exit(1);
						} // fim do catch
					} // fim do finally

		
				Escolha escolha = new Escolha();
				dispose(); // fecha a primeira tela
				escolha.setVisible(true); // chama a segunda tela
				
			}
		});
		btnSalvar.setBounds(52, 194, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Escolha escolha = new Escolha();
				dispose(); // fecha a primeira tela
				escolha.setVisible(true); // chama a segunda tela
			}
		});
		btnCancelar.setBounds(267, 194, 89, 23);
		contentPane.add(btnCancelar);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(165, 108, 126, 20);
		contentPane.add(passwordSenha);
	}
}
