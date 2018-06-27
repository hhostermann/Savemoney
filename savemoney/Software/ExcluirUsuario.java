import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.Color;

public class ExcluirUsuario extends JFrame {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost/savemoney";

	private JPanel contentPane;
	private JTable tabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirUsuario frame = new ExcluirUsuario();
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

	public ExcluirUsuario() {

		setTitle("Menu ExcluirUsuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
				
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(34, 342, 95, 23);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(238, 342, 95, 23);

		JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(59, 34, 274, 229);
		tabela = new JTable();
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Login", "Senha"
			}
		));
		
		scrollPane.setViewportView(tabela);

		Connection connection = null; // gerencia a conexao
		Statement statement = null; // instrucao de consulta

		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, "root", "");
			statement = connection.createStatement();

			String[] tableColumnsName = { "ID", "Login", "Senha" };
			DefaultTableModel val = (DefaultTableModel) tabela.getModel();
			val.setColumnIdentifiers(tableColumnsName); // query
			ResultSet rs = statement.executeQuery("SELECT `idUsuario`, `loginUsuario`, `senhaUsuario` FROM `tbl_usuario`"); 
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
		
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Escolha escolha = new Escolha();
				dispose(); // fecha a primeira tela
				escolha.setVisible(true); // chama a segunda tela
			}
		});

		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String cod = tabela.getValueAt(tabela.getSelectedRow(), 0).toString();
				((DefaultTableModel) tabela.getModel()).removeRow(tabela.getSelectedRow());

				Connection connection = null;
				Statement statement = null;
				try {
					Class.forName(JDBC_DRIVER); // carrega classe de driver do banco de dados

					// estabelece conexão com o banco de dados
					connection = DriverManager.getConnection(DATABASE_URL, "root", "");

					// cria Statement para consultar banco de dados
					statement = connection.createStatement();
					statement.execute("DELETE FROM tab_usuario WHERE cod=('" + cod + "');");

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
		contentPane.add(scrollPane);
		contentPane.add(btnExcluir);
		contentPane.add(btnVoltar);
		
		
	}
}
