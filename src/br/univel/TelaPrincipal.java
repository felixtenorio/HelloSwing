package br.univel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaPrincipal extends JFrame {

	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				TelaPrincipal tp = new TelaPrincipal();// inst�ncia.
				tp.setSize(800, 600); // tamanho da tela.
				tp.setLocationRelativeTo(null);// centraliza no meio tela.
				tp.setVisible(true); // mostra a tela.
			}
		});

	}

	public TelaPrincipal() {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout()); // Objeto que gerencia os componentes
											// no painel.
		JScrollPane jsc = new JScrollPane(); // Panel de Rolagem(barra de
												// rolagem).
		table = new JTable();
		jsc.setViewportView(table); // Coloca a tabela dentro do scrollpane.
		jp.add(jsc, BorderLayout.CENTER); // scrollpane no centro do panel.

		JButton button = new JButton("Carregar");
		jp.add(button, BorderLayout.NORTH);
		JButton button1 = new JButton("Imprimir");
		jp.add(button1, BorderLayout.SOUTH);

		setContentPane(jp); 

		button.addActionListener(new ActionListener() { // Classe an�nima

			@Override
			public void actionPerformed(ActionEvent e) {
				carregar();
			}
		});

	}

	protected void carregar() {

		DaoPessoa dao = new DaoPessoa();
		List<Pessoa> lista = dao.getPessoas();// conjunto das duas linhas busca
												// os dados no banco.

		MeuModelo meuModelo = new MeuModelo(lista);

		table.setModel(meuModelo);

	}

}
