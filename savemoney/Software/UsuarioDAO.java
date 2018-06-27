import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {

	/**Variavel estatica que definira se o acesso (Autenticacao) realmente aconteceu */
	public static boolean acesso;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost/savemoney";

	/**Esse metodo retorna um Objeto do tipo Usuario ja preenchido com os dados do Usuario Logado
	 * Dessa forma poderemos trabalhar com os dados recuperados do banco */
	public Usuario Acesso(String login, String senha) {
		
		/**Instancia um novo usuario */
		Usuario user = new Usuario();
		
		Connection conn = null;
		Statement consulta = null;
		ResultSet tabela = null;

		
		Connection connection = null; // gerencia a conexao
		Statement statement = null; // instrucao de consulta

		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, "root", "");
			statement = connection.createStatement();
			statement.execute("UPDATE tbl_usuario SET ultimoAcesso = CURRENT_TIMESTAMP WHERE loginUsuario= '"+login+"' and senhaUsuario='"+senha+"'");
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
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/savemoney", "root", "");
			consulta = (Statement) conn.createStatement();
			/**Realiza a consulta no banco passando dois parametros: login e senha */
		
			tabela = consulta.executeQuery("SELECT idUsuario, loginUsuario, senhaUsuario from tbl_usuario WHERE loginUsuario= '"+ login + "'and senhaUsuario='" + senha + "'");
			

			/**Se  os dados que foram passados existirem no banco de dados entao pegamos esses dados e passamos para o objeto que foi instanciado */
			if (tabela.next()) {
				/**Repare que para pegar os dados temos que usar o tabela.get... */
				user.setIdUsuario(tabela.getInt("idUsuario"));
				user.setLoginUsuario(tabela.getString("loginUsuario"));
				user.setSenhaUsuario(tabela.getString("senhaUsuario"));
				
				/**A variavel Acesso recebe True, ou seja estamos autenticados */
				acesso = true;
				
				
			} else {
				/**A variavel recebe false, estamos ferrados */
				acesso = false;
			
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}
		return user;

	}
	

}
