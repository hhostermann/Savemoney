import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ModeloKanitz extends JFrame {

	private JPanel contentPane;
	private JTextField textField_PatrimonioLiquido;
	private JTextField textField_AtivoCirculante;
	private JTextField textField_LucroLiquido;
	private JTextField textField_RealizavelLongoPrazo;
	private JTextField textField_ExigivelTotal;
	private JTextField textField_Estoques;
	private JTextField textField_PassivoCirculante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModeloKanitz frame = new ModeloKanitz();
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
	public ModeloKanitz() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			
		JLabel lblPatrimnioLquido = new JLabel("Patrim\u00F4nio L\u00EDquido:");
		lblPatrimnioLquido.setBounds(26, 143, 150, 14);
		contentPane.add(lblPatrimnioLquido);
		
		JLabel lblLucroLquido = new JLabel("Lucro L\u00EDquido:");
		lblLucroLquido.setBounds(26, 282, 150, 14);
		contentPane.add(lblLucroLquido);
		
		JLabel lblAtivoCirculante = new JLabel("Ativo Circulante:");
		lblAtivoCirculante.setBounds(26, 207, 150, 14);
		contentPane.add(lblAtivoCirculante);
		
		JLabel lblRealizvelALongo = new JLabel("Realiz\u00E1vel a Longo Prazo:");
		lblRealizvelALongo.setBounds(338, 207, 150, 14);
		contentPane.add(lblRealizvelALongo);
		
		JLabel lblExigvelTotal = new JLabel("Exig\u00EDvel Total:");
		lblExigvelTotal.setBounds(338, 143, 150, 14);
		contentPane.add(lblExigvelTotal);
		
		JLabel lblEstoques = new JLabel("Estoques:");
		lblEstoques.setBounds(338, 282, 150, 14);
		contentPane.add(lblEstoques);
		
		JLabel lblPassivoCirculante = new JLabel("Passivo Circulante:");
		lblPassivoCirculante.setBounds(26, 344, 150, 14);
		contentPane.add(lblPassivoCirculante);
		
		textField_PatrimonioLiquido = new JTextField();
		textField_PatrimonioLiquido.setBounds(152, 140, 160, 20);
		contentPane.add(textField_PatrimonioLiquido);
		textField_PatrimonioLiquido.setColumns(10);
		
		textField_AtivoCirculante = new JTextField();
		textField_AtivoCirculante.setBounds(134, 204, 178, 20);
		contentPane.add(textField_AtivoCirculante);
		textField_AtivoCirculante.setColumns(10);
		
		textField_LucroLiquido = new JTextField();
		textField_LucroLiquido.setBounds(122, 279, 190, 20);
		contentPane.add(textField_LucroLiquido);
		textField_LucroLiquido.setColumns(10);
		
		textField_RealizavelLongoPrazo = new JTextField();
		textField_RealizavelLongoPrazo.setBounds(498, 204, 126, 20);
		contentPane.add(textField_RealizavelLongoPrazo);
		textField_RealizavelLongoPrazo.setColumns(10);
		
		textField_ExigivelTotal = new JTextField();
		textField_ExigivelTotal.setBounds(434, 140, 190, 20);
		contentPane.add(textField_ExigivelTotal);
		textField_ExigivelTotal.setColumns(10);
		
		textField_Estoques = new JTextField();
		textField_Estoques.setBounds(409, 279, 215, 20);
		contentPane.add(textField_Estoques);
		textField_Estoques.setColumns(10);
		
		textField_PassivoCirculante = new JTextField();
		textField_PassivoCirculante.setBounds(152, 341, 160, 20);
		contentPane.add(textField_PassivoCirculante);
		textField_PassivoCirculante.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(26, 98, 598, 2);
		contentPane.add(separator);
		
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
				}

			private void calcular() {
				String mensagem = null;
				float x1, x2, x3, x4, x5 = 0;
				
				String patrimonioliquido = textField_PatrimonioLiquido.getText().trim();
				float pl = Float.parseFloat(patrimonioliquido);
				
				String ativocirculante = textField_AtivoCirculante.getText().trim();
				float ac = Float.parseFloat(ativocirculante);
				
				String lucroliquido = textField_LucroLiquido.getText().trim();
				float ll = Float.parseFloat(lucroliquido);
				
				String realizavellongoprazo = textField_RealizavelLongoPrazo.getText().trim();
				float rlp = Float.parseFloat(realizavellongoprazo);
				
				String exigiveltotal = textField_ExigivelTotal.getText().trim();
				float et = Float.parseFloat(exigiveltotal);
				
				String estoques = textField_Estoques.getText().trim();
				float e = Float.parseFloat(estoques);
				
				String passivocirculante = textField_PassivoCirculante.getText().trim();
				float pc = Float.parseFloat(passivocirculante);
				
				x1 = ll / pl;
				x2 = (ac + rlp) / e;
				x3 = (ac - e) / pc;
				x4 = ac / pc;
				x5 = et / pl;
				
				float resultado = (float) ((0.005 * x1) + (1.65 * x2) + (3.55 * x3) - (1.06 * x4) - (0.33 * x5));   
				if (resultado >= 0){
					mensagem = "O valor é de: "+resultado+ "\nEmpresas sem problemas financeiros – Solventes";
				}
				if (resultado < 0 && resultado >= -3){
					mensagem = "O valor é de: "+resultado+ "\nEmpresas com situação financeira indefinida";
				}
				if (resultado < -3){
					mensagem = "O valor é de: "+resultado+ "\nEmpresa enfrentando problemas financeiros – insolventes";
					}
						
				JOptionPane.showMessageDialog(null,mensagem);
				textField_PatrimonioLiquido.setText(""); // limpa os campos
				textField_AtivoCirculante.setText(""); 
				textField_LucroLiquido.setText(""); 
				textField_RealizavelLongoPrazo.setText("");
				textField_ExigivelTotal.setText(""); 
				textField_Estoques.setText(""); 
				textField_PassivoCirculante.setText(""); 
				
				textField_PatrimonioLiquido.requestFocus(); // Após o cadastro foca no campo nome
			}
		});
		btnCalcular.setBounds(382, 381, 89, 23);
		contentPane.add(btnCalcular);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Escolha escolha = new Escolha();
				dispose(); // fecha a primeira tela
				escolha.setVisible(true); // chama a segunda tela
			}
		});
		btnVoltar.setBounds(535, 381, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel eva = new JLabel("");
		eva.setBounds(35, 11, 580, 76);
		ImageIcon imagem2 = new ImageIcon(getClass().getResource("kanitz.png"));
		Image imag2 = imagem2.getImage().getScaledInstance(eva.getWidth(), eva.getHeight(), Image.SCALE_DEFAULT);
		contentPane.setLayout(null);
		eva.setIcon(new ImageIcon(imag2));
		contentPane.add(eva);
		
		JLabel foto = new JLabel("");
		foto.setBounds(-15, -32, 675, 461);
		ImageIcon imagem = new ImageIcon(getClass().getResource("fundo.jpg"));
		Image imag = imagem.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT);
		contentPane.setLayout(null);
		foto.setIcon(new ImageIcon(imag));
		contentPane.add(foto);
		
		
	}
}
