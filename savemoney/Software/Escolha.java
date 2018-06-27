import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Escolha extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Escolha frame = new Escolha();
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
	public Escolha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 463);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnConfiguraes = new JMenu("Configura\u00E7\u00F5es");
		menuBar.add(mnConfiguraes);
		
		JMenu mnPrivacidade = new JMenu("Privacidade");
		mnConfiguraes.add(mnPrivacidade);
		
		JMenuItem mntmNovoUsurio = new JMenuItem("Novo Usu\u00E1rio");
		mntmNovoUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Permissao permissao = new Permissao();
				dispose(); // fecha a primeira tela
				permissao.setVisible(true); // chama a segunda tela
			}
		});
		mnPrivacidade.add(mntmNovoUsurio);
		
		JMenuItem mntmAlterarSenha = new JMenuItem("Alterar Senha");
		mntmAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarUsuario alterar = new AlterarUsuario();
				dispose(); // fecha a primeira tela
				alterar.setVisible(true); // chama a segunda tela
			}
		});
		mnPrivacidade.add(mntmAlterarSenha);
		
		JMenuItem mntmExcluirUsurio = new JMenuItem("Excluir Usu\u00E1rio");
		mntmExcluirUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirUsuario excluir = new ExcluirUsuario();
				dispose(); // fecha a primeira tela
				excluir.setVisible(true); // chama a segunda tela
						}
		});
		mnPrivacidade.add(mntmExcluirUsurio);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnConfiguraes.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel empresarial = new JLabel("");
		empresarial.setBounds(50, 127, 187, 158);
		ImageIcon imagem = new ImageIcon(getClass().getResource("empresarial.jpg"));
		Image imag = imagem.getImage().getScaledInstance(empresarial.getWidth(), empresarial.getHeight(), Image.SCALE_DEFAULT);
		contentPane.setLayout(null);
		empresarial.setIcon(new ImageIcon(imag));
		contentPane.add(empresarial);
		
		
		JLabel pessoal = new JLabel("");
		pessoal.setBounds(399, 127, 187, 158);
		ImageIcon imagem2 = new ImageIcon(getClass().getResource("pessoal.jpg"));
		Image imag2 = imagem2.getImage().getScaledInstance(pessoal.getWidth(), pessoal.getHeight(), Image.SCALE_DEFAULT);
		contentPane.setLayout(null);
		pessoal.setIcon(new ImageIcon(imag2));
		contentPane.add(pessoal);
		
		JButton btnModoEmresarial = new JButton("Modo Empresarial");
		btnModoEmresarial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Empresarial empresarial = new Empresarial();
				dispose(); // fecha a primeira tela
				empresarial.setVisible(true); // chama a segunda tela
			}
		});
		btnModoEmresarial.setBounds(85, 306, 147, 39);
		contentPane.add(btnModoEmresarial);
		
		JButton btnModoPessoal = new JButton("Modo Pessoal");
		btnModoPessoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pessoal pessoal = new Pessoal();
				dispose(); // fecha a primeira tela
				pessoal.setVisible(true); // chama a segunda tela
				
				
			}
		});
		btnModoPessoal.setBounds(422, 306, 147, 39);
		contentPane.add(btnModoPessoal);
		
		JLabel foto = new JLabel("");
		foto.setBounds(-15, -32, 675, 461);
		ImageIcon imagem3 = new ImageIcon(getClass().getResource("fundo.jpg"));
		Image imag3 = imagem3.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT);
		contentPane.setLayout(null);
		foto.setIcon(new ImageIcon(imag3));
		contentPane.add(foto);
	}
}
