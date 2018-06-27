	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class AdmDAO {

		/**Variavel estatica que definira se o acesso (Autenticacao) realmente aconteceu */
		public static boolean acesso_adm;

		/**Esse metodo retorna um Objeto do tipo Usuario ja preenchido com os dados do Usuario Logado
		 * Dessa forma poderemos trabalhar com os dados recuperados do banco */
		public Usuario Acesso(String login, String senha) {
			
			/**Instancia um novo usuario */
			Usuario user = new Usuario();
			
			Connection conn = null;
			Statement consulta = null;
			ResultSet tabela = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/savemoney", "root", "");
				consulta = (Statement) conn.createStatement();
				/**Realiza a consulta no banco passando dois parametros: login e senha */
				tabela = consulta.executeQuery(	"SELECT idUsuario, loginUsuario, senhaUsuario from tbl_usuario WHERE loginUsuario= 'Savemoney'and senhaUsuario='" + senha + "'");
				
				/**Se  os dados que foram passados existirem no banco de dados entao pegamos esses dados e passamos para o objeto que foi instanciado */
				if (tabela.next()) {
					/**Repare que para pegar os dados temos que usar o tabela.get... */
					user.setIdUsuario(tabela.getInt("idUsuario"));
					user.setLoginUsuario(tabela.getString("loginUsuario"));
					user.setSenhaUsuario(tabela.getString("senhaUsuario"));
					/**A variavel Acesso recebe True, ou seja estamos autenticados */
					acesso_adm = true;
				} else {
					/**A variavel recebe false, estamos ferrados */
					acesso_adm = false;
				}

			} catch (ClassNotFoundException | SQLException e) {
				e.getMessage();
			}
			return user;

		}
		

	}

	
	
