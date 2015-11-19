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
import java.awt.Dimension;
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
		setPreferredSize(new Dimension(500, 500));
		setMinimumSize(new Dimension(500, 500));

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
		mntmUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cadUsuario();
				} catch (Exception g){
					g.printStackTrace();
				}				
				
			}
		});
		mnCadastros.add(mntmUsurio);

		JMenuItem mntmBloquear = new JMenuItem("Bloquear");
		mntmBloquear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				block();
			}
		});
		mnCadastros.add(mntmBloquear);

		JMenu mnVendas = new JMenu("Movimento");
		menuBar.add(mnVendas);

		JMenuItem mntmVenda = new JMenuItem("Venda");
		mntmVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				venda();
			}
		});
		mnVendas.add(mntmVenda);
		
		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelCliente();
			}
		});
		mnRelatrios.add(mntmClientes);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mnRelatrios.add(mntmProdutos);
		
		JMenuItem mntmVendas = new JMenuItem("Vendas");
		mnRelatrios.add(mntmVendas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = 
				new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	protected void RelCliente() {
		// TODO Auto-generated method stub
		
	}

	protected void venda() {
		TelaVenda telaVenda = new TelaVenda();
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaVenda);
								
			}
		};
		telaVenda.setCloseAction(action);
		tabbedPane.addTab("Venda", telaVenda);
	}

	/**
	 * @Author
	 * 05/11/2015 23:02:18
	 */
	protected void cadUsuario() {
		TelaUsuario telaUsuario = new TelaUsuario();
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaUsuario);
				
			}
		};
			telaUsuario.setCloseAction(action);
			tabbedPane.addTab("Cadastro de Usuários", telaUsuario);
		
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
		tabbedPane.addTab("Cadastro de Produtos", telaProduto);
		
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
		ActionListener action = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCliente);

			}

		};
		telaCliente.setCloseAction(action);
		tabbedPane.addTab("Cadastro de Clientes", telaCliente);

	}

}
