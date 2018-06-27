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
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AdicionarObjetivo extends JFrame {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost/savemoney";
	
	private JPanel contentPane;
	private JTextField textDescricao;
	private JTextField textDispMensal;
	private JTextField textCusto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarObjetivo frame = new AdicionarObjetivo();
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
	public AdicionarObjetivo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Cadastro de Objetivo");
		JLabel lblDescricao = new JLabel("Descreva seu objetivo:");
		lblDescricao.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblDescricao.setBounds(37, 64, 155, 14);
		contentPane.add(lblDescricao);
		
		JLabel lblDisponibilidadeMensal = new JLabel("Disponibilidade Mensal: ");
		lblDisponibilidadeMensal.setBounds(58, 111, 142, 14);
		contentPane.add(lblDisponibilidadeMensal);
		
		JLabel lblCusto = new JLabel("Custo: ");
		lblCusto.setBounds(58, 162, 46, 14);
		contentPane.add(lblCusto);
		
		textDescricao = new JTextField();
		textDescricao.setBounds(229, 62, 173, 20);
		contentPane.add(textDescricao);
		textDescricao.setColumns(10);
		
		textDispMensal = new JTextField();
		textDispMensal.setBounds(229, 108, 86, 20);
		contentPane.add(textDispMensal);
		textDispMensal.setColumns(10);
		
		textCusto = new JTextField();
		textCusto.setBounds(229, 159, 86, 20);
		contentPane.add(textCusto);
		textCusto.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int idUsuario = 0;
				Connection connection = null; // gerencia a conexao
				Statement statement = null; // instrucao de consulta
				
				try {
					Class.forName(JDBC_DRIVER);
					connection = DriverManager.getConnection(DATABASE_URL, "root", "");
					statement = connection.createStatement();
					statement.execute("SELECT `idUsuario` FROM `tbl_usuario` ORDER BY ultimoAcesso DESC ");
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
				
				
				 String nome = textDescricao.getText().trim(); // trim() pega só o que esta escrito no campo
				
				 String custoObjetivo = textCusto.getText().trim();
				 float custoObj = Float.parseFloat(custoObjetivo);
				 
				 
				 String disponibilidadeMensal = textDispMensal.getText().trim();
			     float dispMensal = Float.parseFloat(disponibilidadeMensal);
			   
			     double disponibilidadeDiaria = (dispMensal/30);
			     double tempoMes = (custoObj / dispMensal);
			     double tempoDias = (custoObj / disponibilidadeDiaria);
			     double saldo = 0;
			     

				try {
					Class.forName(JDBC_DRIVER);
					connection = DriverManager.getConnection(DATABASE_URL, "root", "");
					statement = connection.createStatement();
					statement.execute("INSERT INTO `tbl_objetivo`(`nomeObjetivo`, `custoObjetivo`, `dispMensal`, `dispDiaria`, `tempoMes`, `tempoDias`, `saldoObjetivo`, `idUsuario`) VALUES"
							+ " ('"+nome+"',"+custoObj+","+dispMensal+","+disponibilidadeDiaria+","+tempoMes+","+tempoDias+","+saldo+","+idUsuario+")");
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
				
			
				
				Pessoal pessoal = new Pessoal();
				dispose(); // fecha a primeira tela
				pessoal.setVisible(true); // chama a segunda tela
				
							
			}
		});
		btnSalvar.setBounds(76, 229, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pessoal pessoal = new Pessoal();
				dispose(); // fecha a primeira tela
				pessoal.setVisible(true); // chama a segunda tela
				
			}
		});
		btnCancelar.setBounds(241, 229, 89, 23);
		contentPane.add(btnCancelar);
	}
}
