import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class Empresarial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empresarial frame = new Empresarial();
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
	public Empresarial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 470);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmCalculos = new JMenuItem("\u00CDndices financeiros");
		mntmCalculos.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							EscolherCalculo escolhercalculo = new EscolherCalculo();
				dispose(); // fecha a primeira tela
				escolhercalculo.setVisible(true); // chama a segunda tela
			}
		});
		menuBar.add(mntmCalculos);
		
		JMenuItem mntmKanitz = new JMenuItem("Modelo de Kanitz");
		mntmKanitz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModeloKanitz kanitz = new ModeloKanitz();
				dispose(); // fecha a primeira tela
				kanitz.setVisible(true); // chama a segunda tela
				
				}
		});
		menuBar.add(mntmKanitz);
		
		JMenuItem mntmEva = new JMenuItem("EVA");
		mntmEva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eva eva = new Eva();
				dispose(); // fecha a primeira tela
				eva.setVisible(true); // chama a segunda tela
			}
		});
		menuBar.add(mntmEva);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel foto = new JLabel("");
		foto.setBounds(-15, -32, 675, 461);
		ImageIcon imagem = new ImageIcon(getClass().getResource("empresarial.jpg"));
		Image imag = imagem.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT);
		contentPane.setLayout(null);
		foto.setIcon(new ImageIcon(imag));
		contentPane.add(foto);
		
	}
}
