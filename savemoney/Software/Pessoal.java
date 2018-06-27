import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pessoal extends JFrame {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost/savemoney";

	private JPanel contentPane;
	private JTable tabela;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pessoal frame = new Pessoal();
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
	public void limpaTabela() {
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	public Pessoal() {

		setTitle("Menu Pessoal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
				
			JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(59, 34, 274, 229);
		tabela = new JTable();
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Objetivo"
			}
		));
		
		// tabela.getColumnModel().getColumn(2).setPreferredWidth(200);

		scrollPane.setViewportView(tabela);

		Connection connection = null; // gerencia a conexao
		Statement statement = null; // instrucao de consulta

		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, "root", "");
			statement = connection.createStatement();

			String[] tableColumnsName = { "Objetivo" };
			DefaultTableModel val = (DefaultTableModel) tabela.getModel();
			val.setColumnIdentifiers(tableColumnsName); // query
			ResultSet rs = statement.executeQuery("SELECT `nomeObjetivo` FROM `tbl_objetivo`"); 
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			int colNo = rsmd.getColumnCount();
			while (rs.next()) {
				Object[] objects = new Object[colNo];
				for (int i = 0; i < colNo; i++) {
					objects[i] = rs.getObject(i + 1);
				}
				val.addRow(objects);
			}
			tabela.setModel(val);

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
		}

		contentPane.add(scrollPane);
		
		button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AdicionarObjetivo objetivo = new AdicionarObjetivo();
				dispose(); // fecha a primeira tela
				objetivo.setVisible(true); // chama a segunda tela
				
				
			}
		});
		button.setBounds(182, 297, 41, 23);
		contentPane.add(button);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
						String cod = null;
						cod = tabela.getValueAt(tabela.getSelectedRow(), 0).toString();
						((DefaultTableModel) tabela.getModel()).removeRow(tabela.getSelectedRow());

						Connection connection = null;
						Statement statement = null;
						try {
							Class.forName(JDBC_DRIVER); // carrega classe de driver do banco de dados

							// estabelece conexão com o banco de dados
							connection = DriverManager.getConnection(DATABASE_URL, "root", "");

							// cria Statement para consultar banco de dados
							statement = connection.createStatement();
							statement.execute("DELETE FROM tbl_objetivo WHERE nomeObjetivo=('" + cod + "');");

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

						JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
					
			}
		});
		btnExcluir.setBounds(257, 297, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Escolha escolha = new Escolha();
				dispose(); // fecha a primeira tela
				escolha.setVisible(true); // chama a segunda tela
				
				
			}
		});
		btnVoltar.setBounds(43, 297, 89, 23);
		contentPane.add(btnVoltar);
		
		
		
	}
}
