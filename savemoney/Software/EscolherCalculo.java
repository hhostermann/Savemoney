import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EscolherCalculo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EscolherCalculo frame = new EscolherCalculo();
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
	public EscolherCalculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnLiquis = new JButton("Liquidez Imediata ");
		btnLiquis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calcular calcular = new Calcular();
				dispose(); // fecha a primeira tela
			 	calcular.setVisible(true); // chama a segunda tela
				calcular.Calcula_LiquidezImediata();
			}
		});
		btnLiquis.setBounds(23, 52, 290, 23);
		contentPane.add(btnLiquis);

		JButton btnLiquidezSeca = new JButton("Liquidez Seca ");
		btnLiquidezSeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calcular calcular = new Calcular();
				dispose(); // fecha a primeira tela
			 	calcular.setVisible(true); // chama a segunda tela
				calcular.Calcula_LiquidezSeca();
				}
		});
		btnLiquidezSeca.setBounds(23, 127, 290, 23);
		contentPane.add(btnLiquidezSeca);

		JButton btnLiquidezCorrente = new JButton("Liquidez Corrente - Vis\u00E3o Cont\u00E1bil");
		btnLiquidezCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular calcular = new Calcular();
				dispose(); // fecha a primeira tela
			 	calcular.setVisible(true); // chama a segunda tela
				calcular.Calcula_LiquidezCorrenteVC();
							}
		});
		btnLiquidezCorrente.setBounds(23, 202, 290, 23);
		contentPane.add(btnLiquidezCorrente);

		JButton btnLiquidezCorrente_1 = new JButton(" Liquidez Corrente - Vis\u00E3o Gerencial");
		btnLiquidezCorrente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular calcular = new Calcular();
				dispose(); // fecha a primeira tela
			 	calcular.setVisible(true); // chama a segunda tela
				calcular.Calcula_LiquidezCorrenteVG();
			}
		});
		btnLiquidezCorrente_1.setBounds(23, 277, 290, 23);
		contentPane.add(btnLiquidezCorrente_1);

		JButton btnLiquidezTotal = new JButton("Liquidez Total ");
		btnLiquidezTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular calcular = new Calcular();
				dispose(); // fecha a primeira tela
			 	calcular.setVisible(true); // chama a segunda tela
				calcular.Calcula_LiquidezTotal();
			}
		});
		btnLiquidezTotal.setBounds(23, 352, 290, 23);
		contentPane.add(btnLiquidezTotal);

		JButton btnSolvnciaGeral = new JButton("Solv\u00EAncia Geral ");
		btnSolvnciaGeral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular calcular = new Calcular();
				dispose(); // fecha a primeira tela
			 	calcular.setVisible(true); // chama a segunda tela
				calcular.Calcula_SolvenciaGeral();
			}
		});
		btnSolvnciaGeral.setBounds(336, 52, 290, 23);
		contentPane.add(btnSolvnciaGeral);

		JButton btnGrauDeEndividamento = new JButton("Grau de Endividamento");
		btnGrauDeEndividamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular calcular = new Calcular();
				dispose(); // fecha a primeira tela
			 	calcular.setVisible(true); // chama a segunda tela
				calcular.Calcula_GrauDeEndividamento();
			}
		});
		btnGrauDeEndividamento.setBounds(336, 127, 290, 23);
		contentPane.add(btnGrauDeEndividamento);

		JButton btnComposioDeEndividamento = new JButton("Composi\u00E7\u00E3o de Endividamento");
		btnComposioDeEndividamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular calcular = new Calcular();
				dispose(); // fecha a primeira tela
			 	calcular.setVisible(true); // chama a segunda tela
				calcular.Calcula_ComposicaoDeEndividamento();
			}
		});
		btnComposioDeEndividamento.setBounds(336, 202, 290, 23);
		contentPane.add(btnComposioDeEndividamento);

		JButton btnGrauDeGarantia = new JButton("Grau de Garantia de Capitais de Terceiros");
		btnGrauDeGarantia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular calcular = new Calcular();
				dispose(); // fecha a primeira tela
			 	calcular.setVisible(true); // chama a segunda tela
				calcular.Calcula_GrauGarantiaCT();
			}
		});
		btnGrauDeGarantia.setBounds(336, 277, 290, 23);
		contentPane.add(btnGrauDeGarantia);

		JButton btnGrauDeImobilizaes = new JButton("Grau de Imobiliza\u00E7\u00F5es de Capitais Pr\u00F3prios");
		btnGrauDeImobilizaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular calcular = new Calcular();
				dispose(); // fecha a primeira tela
			 	calcular.setVisible(true); // chama a segunda tela
				calcular.Calcula_GraudeICP();
			}
		});
		btnGrauDeImobilizaes.setBounds(336, 352, 290, 23);
		contentPane.add(btnGrauDeImobilizaes);
		
		JLabel foto = new JLabel("");
		foto.setBounds(-15, -32, 675, 461);
		ImageIcon imagem = new ImageIcon(getClass().getResource("fundo.jpg"));
		Image imag = imagem.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT);
		contentPane.setLayout(null);
		foto.setIcon(new ImageIcon(imag));
		contentPane.add(foto);
	}

}