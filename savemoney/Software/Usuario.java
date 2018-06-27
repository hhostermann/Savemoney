public class Usuario {

	private Integer idUsuario;
	private String loginUsuario;
	private String senhaUsuario;
	private String ultimoAcesso;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
		}

	public String getultimoAcesso() {
		return ultimoAcesso;
	}

	public void setultimoAcesso(String ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
		}

}
