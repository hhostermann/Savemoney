import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Calcular extends JFrame {

	private JPanel contentPane;
	private JTextField textAtivoDisponvel;
	private JTextField textRealizLp;
	private JTextField textAtivoNoCirculante;
	private JTextField textDisponvel;
	private JTextField textEstoquesOciosos;
	private JTextField textAtivoCirculante;
	private JTextField textPassvelExigvel;
	private JTextField textDividas;
	private JTextField textAtivoTotal;
	private JTextField textOutras;
	private JTextField textClientes;
	private JTextField textPatrimnioLquido;
	private JTextField textPassivoCirculante;
	private JTextField textAtivosDeRpida;
	private JTextField textPelp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calcular frame = new Calcular();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void Calcula_LiquidezImediata(){
				
		textRealizLp.setEnabled(false);
		textAtivoNoCirculante.setEnabled(false);
		textDisponvel.setEnabled(false);
		textEstoquesOciosos.setEnabled(false);
		textAtivoCirculante.setEnabled(false);
		textPassvelExigvel.setEnabled(false);
		textDividas.setEnabled(false);
		textAtivoTotal.setEnabled(false);
		textOutras.setEnabled(false);
		textClientes.setEnabled(false);
		textPatrimnioLquido.setEnabled(false);
		textAtivosDeRpida.setEnabled(false);
		textPelp.setEnabled(false);

		textAtivoDisponvel.requestFocus(); 
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ativodisponvel = textAtivoDisponvel.getText().trim();
				float ad = Float.parseFloat(ativodisponvel);
				String passivocirculante = textPassivoCirculante.getText().trim();
				float pc = Float.parseFloat(passivocirculante);
				
				float resultado = ad / pc;
				
				JOptionPane.showMessageDialog(null,"A Liquidez Imediata é de: R$ " + resultado);
				
				textPassivoCirculante.setText(""); 
				textAtivoDisponvel.setText(""); 
				
			}
		});
		btnCalcular.setBounds(328, 378, 89, 23);
		contentPane.add(btnCalcular);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Escolha escolha = new Escolha();
				dispose(); // fecha a primeira tela
				escolha.setVisible(true); // chama a segunda tela
			}
		});
		btnVoltar.setBounds(466, 378, 89, 23);
		contentPane.add(btnVoltar);
		
		}
	
	public void Calcula_LiquidezSeca(){
		
		textAtivoDisponvel.setEnabled(false);
		textRealizLp.setEnabled(false);
		textAtivoNoCirculante.setEnabled(false);
		textEstoquesOciosos.setEnabled(false);
		textAtivoCirculante.setEnabled(false);
		textPassvelExigvel.setEnabled(false);
		textDividas.setEnabled(false);
		textAtivoTotal.setEnabled(false);
		textPatrimnioLquido.setEnabled(false);
		textPelp.setEnabled(false);

		textDisponvel.requestFocus(); 
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String disponvel = textDisponvel.getText().trim();
				float d = Float.parseFloat(disponvel);
				String outras = textOutras.getText().trim();
				float o = Float.parseFloat(outras);
				String clientes = textClientes.getText().trim();
				float c = Float.parseFloat(clientes);
				String passivocirculante = textPassivoCirculante.getText().trim();
				float pc = Float.parseFloat(passivocirculante);
				String ativosderapida = textAtivosDeRpida.getText().trim();
				float adr = Float.parseFloat(ativosderapida);
				
				float resultado = (d + c + o + adr) / pc;
				
				JOptionPane.showMessageDialog(null,"A Liquidez Seca é de: R$ " + resultado);
				
				textDisponvel.setText("");
				textOutras.setText("");
				textClientes.setText("");
				textPassivoCirculante.setText("");
				textAtivosDeRpida.setText("");
			}
		});
		btnCalcular.setBounds(328, 378, 89, 23);
		contentPane.add(btnCalcular);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Escolha escolha = new Escolha();
				dispose(); // fecha a primeira tela
				escolha.setVisible(true); // chama a segunda tela
			}
		});
		btnVoltar.setBounds(466, 378, 89, 23);
		contentPane.add(btnVoltar);
		
	}
	
	public void Calcula_LiquidezCorrenteVC(){
		
		textAtivoDisponvel.setEnabled(false);
		textRealizLp.setEnabled(false);
		textAtivoNoCirculante.setEnabled(false);
		textDisponvel.setEnabled(false);
		textEstoquesOciosos.setEnabled(false);
		textPassvelExigvel.setEnabled(false);
		textDividas.setEnabled(false);
		textAtivoTotal.setEnabled(false);
		textOutras.setEnabled(false);
		textClientes.setEnabled(false);
		textPatrimnioLquido.setEnabled(false);
		textAtivosDeRpida.setEnabled(false);
		textPelp.setEnabled(false);

		textAtivoCirculante.requestFocus(); 
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ativocirculante = textAtivoCirculante.getText().trim();
				float ac = Float.parseFloat(ativocirculante);
				String passivocirculante = textPassivoCirculante.getText().trim();
				float pc = Float.parseFloat(passivocirculante);
				
				float resultado = ac / pc;
				
				JOptionPane.showMessageDialog(null,"A Liquidez Corrente - Visão Contábil é de: R$ " + resultado);
				
				textAtivoCirculante.setText("");
				textPassivoCirculante.setText("");
			}
		});
		btnCalcular.setBounds(328, 378, 89, 23);
		contentPane.add(btnCalcular);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Escolha escolha = new Escolha();
				dispose(); // fecha a primeira tela
				escolha.setVisible(true); // chama a segunda tela
			}
		});
		btnVoltar.setBounds(466, 378, 89, 23);
		contentPane.add(btnVoltar);
		
	}
	
	public void Calcula_LiquidezCorrenteVG(){
		
	textAtivoDisponvel.setEnabled(false);
	textRealizLp.setEnabled(false);
	textAtivoNoCirculante.setEnabled(false);
	textDisponvel.setEnabled(false);
	textPassvelExigvel.setEnabled(false);
	textDividas.setEnabled(false);
	textAtivoTotal.setEnabled(false);
	textOutras.setEnabled(false);
	textClientes.setEnabled(false);
	textPatrimnioLquido.setEnabled(false);
	textAtivosDeRpida.setEnabled(false);
	textPelp.setEnabled(false);

	textAtivoCirculante.requestFocus(); 
	
	JButton btnCalcular = new JButton("Calcular");
	btnCalcular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String estoquesociosos =	textEstoquesOciosos.getText().trim();
			float eo = Float.parseFloat(estoquesociosos);
			String ativocirculante = textAtivoCirculante.getText().trim();
			float ac = Float.parseFloat(ativocirculante);
			String passivocirculante = textPassivoCirculante.getText().trim();
			float pc = Float.parseFloat(passivocirculante);
			
			float resultado = (ac - eo) / pc;
			
			JOptionPane.showMessageDialog(null,"A Liquidez Corrente - Visão Gerencial é de: R$ " + resultado);
			
			textEstoquesOciosos.setText("");
			textAtivoCirculante.setText("");
			textPassivoCirculante.setText("");
		}
	});
	btnCalcular.setBounds(328, 378, 89, 23);
	contentPane.add(btnCalcular);

	JButton btnVoltar = new JButton("Voltar");
	btnVoltar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Escolha escolha = new Escolha();
			dispose(); // fecha a primeira tela
			escolha.setVisible(true); // chama a segunda tela
		}
	});
	btnVoltar.setBounds(466, 378, 89, 23);
	contentPane.add(btnVoltar);
	
	}
	
	public void Calcula_LiquidezTotal(){
		
	textAtivoDisponvel.setEnabled(false);
	textAtivoNoCirculante.setEnabled(false);
	textDisponvel.setEnabled(false);
	textEstoquesOciosos.setEnabled(false);
	textPassvelExigvel.setEnabled(false);
	textDividas.setEnabled(false);
	textAtivoTotal.setEnabled(false);
	textOutras.setEnabled(false);
	textClientes.setEnabled(false);
	textPatrimnioLquido.setEnabled(false);
	textAtivosDeRpida.setEnabled(false);
	
	textAtivoCirculante.requestFocus(); 
	
	JButton btnCalcular = new JButton("Calcular");
	btnCalcular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String realizlp =	textRealizLp.getText().trim();
			float rlp = Float.parseFloat(realizlp);
			String atcirculante =	textAtivoCirculante.getText().trim();
			float atc = Float.parseFloat(atcirculante);
			String passivocirculante = textPassivoCirculante.getText().trim();
			float pc = Float.parseFloat(passivocirculante);
			String pelp = textPelp.getText().trim();
			float p = Float.parseFloat(pelp);
			
			float resultado = (atc + rlp) / (pc + p);
			
			JOptionPane.showMessageDialog(null,"A Liquidez Total é de: R$ " + resultado);
			
			textRealizLp.setText("");
			textAtivoCirculante.setText("");
			textPassivoCirculante.setText("");
			textPelp.setText("");
		}
	});
	btnCalcular.setBounds(328, 378, 89, 23);
	contentPane.add(btnCalcular);

	JButton btnVoltar = new JButton("Voltar");
	btnVoltar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Escolha escolha = new Escolha();
			dispose(); // fecha a primeira tela
			escolha.setVisible(true); // chama a segunda tela
		}
	});
	btnVoltar.setBounds(466, 378, 89, 23);
	contentPane.add(btnVoltar);
	
}

	public void Calcula_SolvenciaGeral(){
	
	textAtivoDisponvel.setEnabled(false);
	textRealizLp.setEnabled(false);
	textAtivoNoCirculante.setEnabled(false);
	textDisponvel.setEnabled(false);
	textEstoquesOciosos.setEnabled(false);
	textAtivoCirculante.setEnabled(false);
	textDividas.setEnabled(false);
	textOutras.setEnabled(false);
	textClientes.setEnabled(false);
	textPatrimnioLquido.setEnabled(false);
	textPassivoCirculante.setEnabled(false);
	textAtivosDeRpida.setEnabled(false);
	textPelp.setEnabled(false);

	textAtivoTotal.requestFocus(); 
	
	JButton btnCalcular = new JButton("Calcular");
	btnCalcular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String passvelexigvel = textPassvelExigvel.getText().trim();
			float pe = Float.parseFloat(passvelexigvel);
			String ativototal = textAtivoTotal.getText().trim();
			float at = Float.parseFloat(ativototal);
			
			float resultado = at / pe;
			
			JOptionPane.showMessageDialog(null,"A Solvência Geral é de: R$ " + resultado);
			
			textPassvelExigvel.setText("");
			textAtivoTotal.setText("");
		}
	});
	btnCalcular.setBounds(328, 378, 89, 23);
	contentPane.add(btnCalcular);

	JButton btnVoltar = new JButton("Voltar");
	btnVoltar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Escolha escolha = new Escolha();
			dispose(); // fecha a primeira tela
			escolha.setVisible(true); // chama a segunda tela
		}
	});
	btnVoltar.setBounds(466, 378, 89, 23);
	contentPane.add(btnVoltar);
	
	}
	
	public void Calcula_GrauDeEndividamento(){
	
	
	textAtivoDisponvel.setEnabled(false);
	textRealizLp.setEnabled(false);
	textAtivoNoCirculante.setEnabled(false);
	textDisponvel.setEnabled(false);
	textEstoquesOciosos.setEnabled(false);
	textAtivoCirculante.setEnabled(false);
	textDividas.setEnabled(false);
	textOutras.setEnabled(false);
	textClientes.setEnabled(false);
	textPatrimnioLquido.setEnabled(false);
	textPassivoCirculante.setEnabled(false);
	textAtivosDeRpida.setEnabled(false);
	textPelp.setEnabled(false);

	textAtivoTotal.requestFocus(); 
	
	JButton btnCalcular = new JButton("Calcular");
	btnCalcular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String passvelexigvel = textPassvelExigvel.getText().trim();
			float pe = Float.parseFloat(passvelexigvel);
			String ativototal = textAtivoTotal.getText().trim();
			float at = Float.parseFloat(ativototal);
			
			float resultado = pe / at;
			
			JOptionPane.showMessageDialog(null,"O Grau de Endividamento é de: R$ " + resultado);
			
			textPassvelExigvel.setText("");
			textAtivoTotal.setText("");
		}
	});
	btnCalcular.setBounds(328, 378, 89, 23);
	contentPane.add(btnCalcular);

	JButton btnVoltar = new JButton("Voltar");
	btnVoltar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Escolha escolha = new Escolha();
			dispose(); // fecha a primeira tela
			escolha.setVisible(true); // chama a segunda tela
		}
	});
	btnVoltar.setBounds(466, 378, 89, 23);
	contentPane.add(btnVoltar);
	
	
}
	
	public void Calcula_ComposicaoDeEndividamento(){
	
	textAtivoDisponvel.setEnabled(false);
	textRealizLp.setEnabled(false);
	textAtivoNoCirculante.setEnabled(false);
	textDisponvel.setEnabled(false);
	textEstoquesOciosos.setEnabled(false);
	textAtivoCirculante.setEnabled(false);
	textPassvelExigvel.setEnabled(false);
	textAtivoTotal.setEnabled(false);
	textOutras.setEnabled(false);
	textClientes.setEnabled(false);
	textPatrimnioLquido.setEnabled(false);
	textAtivosDeRpida.setEnabled(false);
	textPelp.setEnabled(false);

	textDividas.requestFocus();
	
	JButton btnCalcular = new JButton("Calcular");
	btnCalcular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String dividas = textDividas.getText().trim();
			float di = Float.parseFloat(dividas);
			String passivocirculante = textPassivoCirculante.getText().trim();
			float pc = Float.parseFloat(passivocirculante);
			
			float resultado = pc / di;
			
			JOptionPane.showMessageDialog(null,"A Composição de Endividamento é de: R$ " + resultado);
			
			textDividas.setText("");
			textPassivoCirculante.setText("");
			
		}
	});
	btnCalcular.setBounds(328, 378, 89, 23);
	contentPane.add(btnCalcular);

	JButton btnVoltar = new JButton("Voltar");
	btnVoltar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Escolha escolha = new Escolha();
			dispose(); // fecha a primeira tela
			escolha.setVisible(true); // chama a segunda tela
		}
	});
	btnVoltar.setBounds(466, 378, 89, 23);
	contentPane.add(btnVoltar);
		
	}

	public void Calcula_GrauGarantiaCT(){
	
	
	textAtivoDisponvel.setEnabled(false);
	textRealizLp.setEnabled(false);
	textAtivoNoCirculante.setEnabled(false);
	textDisponvel.setEnabled(false);
	textEstoquesOciosos.setEnabled(false);
	textAtivoCirculante.setEnabled(false);
	textDividas.setEnabled(false);
	textAtivoTotal.setEnabled(false);
	textOutras.setEnabled(false);
	textClientes.setEnabled(false);
	textPassivoCirculante.setEnabled(false);
	textAtivosDeRpida.setEnabled(false);
	textPelp.setEnabled(false);

	textPassvelExigvel.requestFocus(); 
	
	JButton btnCalcular = new JButton("Calcular");
	btnCalcular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String passvelexigvel = textPassvelExigvel.getText().trim();
			float pe = Float.parseFloat(passvelexigvel);
			String patrimniolquido = textPatrimnioLquido.getText().trim();
			float pl = Float.parseFloat(patrimniolquido);
			
			float resultado = pl / pe;
			
			JOptionPane.showMessageDialog(null,"O Grau de Garantia de Capitais de Terceiros é de: R$ " + resultado);
			
			textPassvelExigvel.setText("");
			textPatrimnioLquido.setText("");
		}
	});
	btnCalcular.setBounds(328, 378, 89, 23);
	contentPane.add(btnCalcular);

	JButton btnVoltar = new JButton("Voltar");
	btnVoltar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Escolha escolha = new Escolha();
			dispose(); // fecha a primeira tela
			escolha.setVisible(true); // chama a segunda tela
		}
	});
	btnVoltar.setBounds(466, 378, 89, 23);
	contentPane.add(btnVoltar);
	}
	
	public void Calcula_GraudeICP(){
		
		textAtivoDisponvel.setEnabled(false);
		textDisponvel.setEnabled(false);
		textEstoquesOciosos.setEnabled(false);
		textAtivoCirculante.setEnabled(false);
		textPassvelExigvel.setEnabled(false);
		textDividas.setEnabled(false);
		textAtivoTotal.setEnabled(false);
		textOutras.setEnabled(false);
		textClientes.setEnabled(false);
		textPassivoCirculante.setEnabled(false);
		textAtivosDeRpida.setEnabled(false);
		textPelp.setEnabled(false);
		
		textAtivoNoCirculante.requestFocus(); 
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String realizlp =	textRealizLp.getText().trim();
				float rlp = Float.parseFloat(realizlp);
				String ativonocirculante =	textAtivoNoCirculante.getText().trim();
				float anc = Float.parseFloat(ativonocirculante);
				String patrimniolquido = textPatrimnioLquido.getText().trim();
				float pl = Float.parseFloat(patrimniolquido);
				
				float resultado = pl / (anc - rlp);
				
				JOptionPane.showMessageDialog(null,"O Grau de Imobilizações de Capitais Próprios é de: R$ " + resultado);
				
				textRealizLp.setText("");
				textAtivoNoCirculante.setText("");
				textPatrimnioLquido.setText("");
			}
		});
		btnCalcular.setBounds(328, 378, 89, 23);
		contentPane.add(btnCalcular);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Escolha escolha = new Escolha();
				dispose(); // fecha a primeira tela
				escolha.setVisible(true); // chama a segunda tela
			}
		});
		btnVoltar.setBounds(466, 378, 89, 23);
		contentPane.add(btnVoltar);
		
		}

	
public Calcular() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtivoDisponvel = new JLabel("Ativo Dispon\u00EDvel:");
		lblAtivoDisponvel.setBounds(22, 30, 123, 14);
		contentPane.add(lblAtivoDisponvel);
		
		JLabel lblPassivoCirculante = new JLabel("Passivo Circulante:");
		lblPassivoCirculante.setBounds(301, 74, 191, 14);
		contentPane.add(lblPassivoCirculante);
		
		JLabel lblDisponvel = new JLabel("Dispon\u00EDvel:");
		lblDisponvel.setBounds(22, 206, 191, 14);
		contentPane.add(lblDisponvel);
		
		JLabel lblClientes = new JLabel("Clientes:");
		lblClientes.setBounds(301, 162, 191, 14);
		contentPane.add(lblClientes);
		
		JLabel lblOutras = new JLabel("Outras:");
		lblOutras.setBounds(301, 206, 191, 14);
		contentPane.add(lblOutras);
		
		JLabel lblAtivosDeRpida = new JLabel("Ativos de R\u00E1pida Conversibilidade:");
		lblAtivosDeRpida.setBounds(301, 30, 202, 14);
		contentPane.add(lblAtivosDeRpida);
		
		JLabel lblAtivoCirculante = new JLabel("Ativo Circulante:");
		lblAtivoCirculante.setBounds(22, 294, 191, 14);
		contentPane.add(lblAtivoCirculante);
		
		JLabel lblEstoquesOciosos = new JLabel("Estoques Ociosos:");
		lblEstoquesOciosos.setBounds(22, 250, 191, 14);
		contentPane.add(lblEstoquesOciosos);
		
		JLabel lblRealizLp = new JLabel("Realiz. LP:");
		lblRealizLp.setBounds(22, 74, 82, 14);
		contentPane.add(lblRealizLp);
		
		JLabel lblPelp = new JLabel("PELP:");
		lblPelp.setBounds(301, 250, 191, 14);
		contentPane.add(lblPelp);
		
		JLabel lblAtivoTotal = new JLabel("Ativo Total:");
		lblAtivoTotal.setBounds(22, 118, 191, 14);
		contentPane.add(lblAtivoTotal);
		
		JLabel lblPassvelExigvel = new JLabel("Pass\u00EDvel Exig\u00EDvel:");
		lblPassvelExigvel.setBounds(22, 338, 130, 14);
		contentPane.add(lblPassvelExigvel);
		
		JLabel lblDividas = new JLabel("Dividas:");
		lblDividas.setBounds(22, 382, 123, 14);
		contentPane.add(lblDividas);
		
		JLabel lblPatrimnioLquido = new JLabel("Patrim\u00F4nio L\u00EDquido:");
		lblPatrimnioLquido.setBounds(301, 118, 191, 14);
		contentPane.add(lblPatrimnioLquido);
		
		JLabel lblAtivoNoCirculante = new JLabel("Ativo N\u00E3o Circulante:");
		lblAtivoNoCirculante.setBounds(22, 162, 136, 14);
		contentPane.add(lblAtivoNoCirculante);
		
		textAtivoDisponvel = new JTextField();
		textAtivoDisponvel.setBounds(139, 27, 136, 20);
		contentPane.add(textAtivoDisponvel);
		textAtivoDisponvel.setColumns(10);
		
		textRealizLp = new JTextField();
		textRealizLp.setColumns(10);
		textRealizLp.setBounds(119, 71, 156, 20);
		contentPane.add(textRealizLp);
		
		textAtivoNoCirculante = new JTextField();
		textAtivoNoCirculante.setColumns(10);
		textAtivoNoCirculante.setBounds(159, 159, 116, 20);
		contentPane.add(textAtivoNoCirculante);
		
		textDisponvel = new JTextField();
		textDisponvel.setColumns(10);
		textDisponvel.setBounds(113, 203, 162, 20);
		contentPane.add(textDisponvel);
		
		textEstoquesOciosos = new JTextField();
		textEstoquesOciosos.setColumns(10);
		textEstoquesOciosos.setBounds(139, 247, 136, 20);
		contentPane.add(textEstoquesOciosos);
		
		textAtivoCirculante = new JTextField();
		textAtivoCirculante.setColumns(10);
		textAtivoCirculante.setBounds(139, 291, 136, 20);
		contentPane.add(textAtivoCirculante);
		
		textPassvelExigvel = new JTextField();
		textPassvelExigvel.setColumns(10);
		textPassvelExigvel.setBounds(139, 335, 136, 20);
		contentPane.add(textPassvelExigvel);
		
		textDividas = new JTextField();
		textDividas.setColumns(10);
		textDividas.setBounds(91, 379, 184, 20);
		contentPane.add(textDividas);
		
		textAtivoTotal = new JTextField();
		textAtivoTotal.setColumns(10);
		textAtivoTotal.setBounds(119, 115, 156, 20);
		contentPane.add(textAtivoTotal);
		
		textPelp = new JTextField();
		textPelp.setColumns(10);
		textPelp.setBounds(375, 247, 254, 20);
		contentPane.add(textPelp);
		
		textOutras = new JTextField();
		textOutras.setColumns(10);
		textOutras.setBounds(390, 203, 239, 20);
		contentPane.add(textOutras);
		
		textClientes = new JTextField();
		textClientes.setColumns(10);
		textClientes.setBounds(390, 159, 239, 20);
		contentPane.add(textClientes);
		
		textPatrimnioLquido = new JTextField();
		textPatrimnioLquido.setColumns(10);
		textPatrimnioLquido.setBounds(445, 115, 184, 20);
		contentPane.add(textPatrimnioLquido);
		
		textPassivoCirculante = new JTextField();
		textPassivoCirculante.setColumns(10);
		textPassivoCirculante.setBounds(445, 71, 184, 20);
		contentPane.add(textPassivoCirculante);
		
		textAtivosDeRpida = new JTextField();
		textAtivosDeRpida.setColumns(10);
		textAtivosDeRpida.setBounds(513, 27, 116, 20);
		contentPane.add(textAtivosDeRpida);
		
	
	}
	
}


