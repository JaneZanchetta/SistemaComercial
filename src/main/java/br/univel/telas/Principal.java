package br.univel.telas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Event;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;

import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Jane
 *
 */
public class Principal extends JFrame {

	private JPanel contentPane;
	private BlockPanel glass;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {

		blockLogin();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Arial Black", Font.BOLD, 12));
		setJMenuBar(menuBar);

		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cadCliente();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		});
		mnCadastros.add(mntmCliente);

		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadProduto();
				} catch (Exception f){
					f.printStackTrace();
				}
			}
		});
		mnCadastros.add(mntmProduto);

		JMenuItem mntmUsurio = new JMenuItem("Usu\u00E1rio");
		mnCadastros.add(mntmUsurio);

		JMenuItem mntmBloquear = new JMenuItem("Bloquear");
		mntmBloquear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				block();
			}
		});
		mnCadastros.add(mntmBloquear);

		JMenu mnVendas = new JMenu("Vendas");
		menuBar.add(mnVendas);

		JMenuItem mntmVenda = new JMenuItem("Venda");
		mnVendas.add(mntmVenda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	/**
	 * @Author
	 */
	protected void cadProduto() {
		TelaProduto telaProduto = new TelaProduto();
		ActionListener action = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaProduto);

			}

		};
		telaProduto.setCloseAction(action);
		System.out.println( " vai fazer o tabbedPane");
		tabbedPane.addTab("Cadastro", telaProduto);
		System.out.println( " PASSOU do tabbedPane");
		
	}

	/**
	 * @Author Jane Z. 01/11/2015 10:29:53
	 */
	private void blockLogin() {
		Runnable acaoOk = () -> {
			glass.setVisible(false);
			glass = new BlockPanel();
		};
		TelaLogin telaLogin = new TelaLogin(acaoOk);
		glass = new BlockPanel(telaLogin);
		setGlassPane(glass);
		glass.setVisible(true);

	}

	/**
	 * @Author Jane Z. 01/11/2015 10:25:04
	 */
	protected void block() {
		setGlassPane(glass);
		glass.setVisible(true);
		new Thread(new Runnable() {

			public void run() {
				for (int i = 0; i < 5; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				glass.setVisible(false);
			}
		}).start();

	}

	protected void cadCliente() {
		TelaCliente telaCliente = new TelaCliente();
//		JPanel telaCliente = new JPanel();
		System.out.println(telaCliente);
		ActionListener action = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCliente);

			}

		};
//		telaCliente.setCloseAction(action);
		System.out.println( " vai fazer o tabbedPane");
		tabbedPane.addTab("Cadastro de Clientes", telaCliente);
		System.out.println( " PASSOU do tabbedPane");

	}

}
