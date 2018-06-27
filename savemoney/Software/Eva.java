import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Eva extends JFrame {

	private JPanel contentPane;
	private JTextField textEBIT;
	private JTextField textIr;
	private JTextField textWacc;
	private JTextField textCustoTerceiros;
	private JTextField textDespesasOperacionais;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eva frame = new Eva();
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
	public Eva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(35, 98, 580, 2);
		contentPane.add(separator);
		
		JLabel lblEbit = new JLabel("EBIT:");
		lblEbit.setBounds(35, 138, 46, 14);
		contentPane.add(lblEbit);
		
		JLabel lblJrcsl = new JLabel("IR/CSL:");
		lblJrcsl.setBounds(35, 202, 46, 14);
		contentPane.add(lblJrcsl);
		
		JLabel lblCustoPrpriowacc = new JLabel("Custo Pr\u00F3prio (WACC):");
		lblCustoPrpriowacc.setBounds(186, 273, 136, 14);
		contentPane.add(lblCustoPrpriowacc);
		
		JLabel lblCustoTerceiros = new JLabel("Custo Terceiros:");
		lblCustoTerceiros.setBounds(306, 202, 103, 14);
		contentPane.add(lblCustoTerceiros);
		
		JLabel lblDespesasOperacionais = new JLabel("Despesas Operacionais:");
		lblDespesasOperacionais.setBounds(306, 138, 141, 14);
		contentPane.add(lblDespesasOperacionais);
		
		textEBIT = new JTextField();
		textEBIT.setBounds(81, 135, 175, 20);
		contentPane.add(textEBIT);
		textEBIT.setColumns(10);
		
		textIr = new JTextField();
		textIr.setBounds(88, 199, 168, 20);
		contentPane.add(textIr);
		textIr.setColumns(10);
		
		textWacc = new JTextField();
		textWacc.setBounds(332, 270, 158, 20);
		contentPane.add(textWacc);
		textWacc.setColumns(10);
		
		textCustoTerceiros = new JTextField();
		textCustoTerceiros.setBounds(419, 199, 196, 20);
		contentPane.add(textCustoTerceiros);
		textCustoTerceiros.setColumns(10);
		
		textDespesasOperacionais = new JTextField();
		textDespesasOperacionais.setBounds(457, 135, 158, 20);
		contentPane.add(textDespesasOperacionais);
		textDespesasOperacionais.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
				}

			private void calcular() {
				String mensagem = null;
							
				String ebit = textEBIT.getText().trim();
				float e = Float.parseFloat(ebit);
				
				String ir = textIr.getText().trim();
				float i = Float.parseFloat(ir);
				
				
				
				String wacc = textWacc.getText().trim();
				float w = Float.parseFloat(wacc);
				
				String cter = textCustoTerceiros.getText().trim();
				float c = Float.parseFloat(cter);
				
				String desp = textDespesasOperacionais.getText().trim();
				float d = Float.parseFloat(desp);
				
							
				float nopat = e - i;
				float resultado = (nopat - c) - d;
				
		
				JOptionPane.showMessageDialog(null,"O resutado do NOPAT é de: R$ "+nopat+ "\nO resutado final do EVA é de: R$ " +resultado);
				textEBIT.setText(""); // limpa os campos
				textIr.setText(""); 
				textWacc.setText(""); 
				textCustoTerceiros.setText(""); 
				textDespesasOperacionais.setText(""); 
				
				textEBIT.requestFocus(); // Após o cadastro foca no campo nome
			}
		});
		btnCalcular.setBounds(157, 346, 89, 23);
		contentPane.add(btnCalcular);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Escolha escolha = new Escolha();
				dispose(); // fecha a primeira tela
				escolha.setVisible(true); // chama a segunda tela
			}
		});
		btnVoltar.setBounds(403, 346, 89, 23);
		contentPane.add(btnVoltar);

		JLabel eva = new JLabel("");
		eva.setBounds(35, 11, 580, 76);
		ImageIcon imagem2 = new ImageIcon(getClass().getResource("eva.png"));
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
