import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Page extends JPanel {
	protected Trie trie;
	protected GUI gui;

	public Page(GUI gui, Trie trie) {
		this.gui = gui;
		this.trie = trie;

		setSize(410, 133);
		setLayout(null);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.ocultar();
			}
		});
		btnCancelar.setBounds(300, 100, 89, 23);
		add(btnCancelar);
	}

	public void mensajeError(String alert) {
		JOptionPane.showMessageDialog(this.gui, alert, "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
	}

	public void mensaje(String alert) {
		JOptionPane.showMessageDialog(this.gui, alert);
	}

	public void actualizarTrie(String text) {
		this.trie = new Trie(text);
	}

}
