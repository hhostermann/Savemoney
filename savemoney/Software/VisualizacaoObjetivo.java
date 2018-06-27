import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VisualizacaoObjetivo extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCustoDoObjetivo;
	private JTextField textDisponibilidadeMensal;
	private JTextField textDisponibilidadeDiaria;
	private JTextField textDepositoretirada;
	private JTextField textSaldo;
	private JTextField textTempoms;
	private JTextField textTempoDia;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost/savemoney";/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizacaoObjetivo frame = new VisualizacaoObjetivo();
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
	public VisualizacaoObjetivo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(49, 33, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCustoDoObjetivo = new JLabel("Custo do Objetivo: ");
		lblCustoDoObjetivo.setBounds(49, 80, 119, 14);
		contentPane.add(lblCustoDoObjetivo);
		
		JLabel lblDisponibilidadeMensal = new JLabel("Disponibilidade Mensal: ");
		lblDisponibilidadeMensal.setBounds(49, 127, 139, 14);
		contentPane.add(lblDisponibilidadeMensal);
		
		JLabel lblTempoms = new JLabel("Tempo de Conclus\u00E3o (M\u00EAs):");
		lblTempoms.setBounds(49, 221, 169, 14);
		contentPane.add(lblTempoms);
		
		JLabel lblTempoDia = new JLabel("Tempo de Conclus\u00E3o (Dia):");
		lblTempoDia.setBounds(49, 268, 169, 14);
		contentPane.add(lblTempoDia);
		
		JLabel lblDisponibilidadeDiaria = new JLabel("Disponibilidade Diaria: ");
		lblDisponibilidadeDiaria.setBounds(49, 174, 139, 14);
		contentPane.add(lblDisponibilidadeDiaria);
		
		JLabel lblSaldo = new JLabel("Saldo: ");
		lblSaldo.setBounds(359, 106, 46, 14);
		contentPane.add(lblSaldo);
		
		textNome = new JTextField();
		textNome.setBounds(186, 30, 86, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textCustoDoObjetivo = new JTextField();
		textCustoDoObjetivo.setBounds(186, 77, 86, 20);
		contentPane.add(textCustoDoObjetivo);
		textCustoDoObjetivo.setColumns(10);
		
		textDisponibilidadeMensal = new JTextField();
		textDisponibilidadeMensal.setBounds(203, 124, 86, 20);
		contentPane.add(textDisponibilidadeMensal);
		textDisponibilidadeMensal.setColumns(10);
		
		textDisponibilidadeDiaria = new JTextField();
		textDisponibilidadeDiaria.setBounds(226, 171, 86, 20);
		contentPane.add(textDisponibilidadeDiaria);
		textDisponibilidadeDiaria.setColumns(10);
		
		textDepositoretirada = new JTextField();
		textDepositoretirada.setBounds(415, 55, 86, 20);
		contentPane.add(textDepositoretirada);
		textDepositoretirada.setColumns(10);
		
		JButton buttonMais = new JButton("+");
		buttonMais.setBounds(359, 54, 46, 23);
		contentPane.add(buttonMais);
		
		JButton buttonMenos = new JButton("-");
		buttonMenos.setBounds(511, 54, 45, 23);
		contentPane.add(buttonMenos);
		
		textSaldo = new JTextField();
		textSaldo.setBounds(438, 103, 86, 20);
		contentPane.add(textSaldo);
		textSaldo.setColumns(10);
		
		JLabel lblDepositoretirada = new JLabel("Deposito/Retirada");
		lblDepositoretirada.setBounds(394, 33, 119, 14);
		contentPane.add(lblDepositoretirada);
		
		textTempoms = new JTextField();
		textTempoms.setBounds(238, 218, 86, 20);
		contentPane.add(textTempoms);
		textTempoms.setColumns(10);
		
		textTempoDia = new JTextField();
		textTempoDia.setBounds(215, 265, 86, 20);
		contentPane.add(textTempoDia);
		textTempoDia.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(412, 217, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(412, 259, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnDepositarDiponibilidadeFinanceiro = new JButton("Depositar Disponibilidade Mensal");
		btnDepositarDiponibilidadeFinanceiro.setBounds(328, 170, 241, 23);
		contentPane.add(btnDepositarDiponibilidadeFinanceiro);
		
		
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName(JDBC_DRIVER); // carrega classe de driver do banco de dados

			// estabelece conexão com o banco de dados
			connection = DriverManager.getConnection(DATABASE_URL, "root", "");

			// cria Statement para consultar banco de dados
			statement = connection.createStatement();
			statement.execute("Select FROM tab_usuario WHERE cod=('" + cod + "');");

		} // fim do try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		} // fim do catch
		catch (ClassNotFoundException classNotFound) {
			classNotFound.printStackTrace();
			System.exit(1);
		} // fim do catch
		finally // assegura que a instrucao e conexao sao fechadas adequadamente
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
	}

}
