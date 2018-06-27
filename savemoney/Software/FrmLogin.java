import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class FrmLogin extends JFrame  {

	private JFrame frame;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin window = new FrmLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmLogin() {
		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 644, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 628, 417);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(39, 242, 46, 14);
		panel.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenha.setBounds(39, 281, 46, 14);
		panel.add(lblSenha);

		txtLogin = new JTextField();
		txtLogin.setBounds(95, 240, 472, 20);
		panel.add(txtLogin);
		txtLogin.setColumns(10);
		
//		JLabel nature = new JLabel("");
//		nature.setBounds(50, 127, 187, 158);
//		ImageIcon imagem = new ImageIcon(getClass().getResource("nature.jpg"));
//		Image imag = imagem.getImage().getScaledInstance(nature.getWidth(), nature.getHeight(), Image.SCALE_DEFAULT);
//		contentPane.setLayout(null);
//		nature.setIcon(new ImageIcon(imag));
//		contentPane.add(nature);
//		
//		JLabel logo = new JLabel("");
//		logo.setBounds(399, 127, 187, 158);
//		ImageIcon imagem2 = new ImageIcon(getClass().getResource("logo.jpg"));
//		Image imag2 = imagem2.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT);
//		contentPane.setLayout(null);
//		logo.setIcon(new ImageIcon(imag2));
//		contentPane.add(logo);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = new Usuario();
				usuario = usuarioDAO.Acesso(txtLogin.getText(), txtSenha.getText());
				if (UsuarioDAO.acesso) {
					JOptionPane.showMessageDialog(null, "Bem-Vindo " + usuario.getLoginUsuario()+ " !");
					
					Escolha escolha = new Escolha();
					dispose(); // fecha a primeira tela
					escolha.setVisible(true); // chama a segunda tela
				
				} else {
					JOptionPane.showMessageDialog(null, "Login ou Senha Incorretos");
				}

			}
		});
		btnEntrar.setBounds(163, 332, 304, 23);
		panel.add(btnEntrar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(95, 279, 472, 20);
		panel.add(txtSenha);
		
		
	}
}
