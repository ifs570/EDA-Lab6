import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

public class PageIrA extends Page {
	
	private JTextField irAField;

	public PageIrA(GUI gui, Trie trie) {
		super(gui, trie);
		contenido();
	}

	public void contenido() {
		JLabel lblIrA = new JLabel("Ir a:");
		lblIrA.setBounds(20, 25, 46, 14);
		add(lblIrA);

		irAField = new JTextField();
		irAField.setBounds(53, 22, 158, 20);
		add(irAField);
		irAField.setColumns(10);

		JButton btnIrA = new JButton("Ir a");
		btnIrA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palabraBuscada = irAField.getText();
				String texto = gui.getTextArea().getText();

				if (!trie.search(palabraBuscada)) {
					mensajeError("Palabra no encontrada");
					return;
				}

				int posicion = texto.indexOf(palabraBuscada);
				if (posicion >= 0) {
					DefaultCaret caret = (DefaultCaret) gui.getTextArea().getCaret();

					caret.setDot(posicion);

					gui.getTextArea().requestFocusInWindow();
				}

			}
		});
		btnIrA.setBounds(10, 100, 89, 23);
		add(btnIrA);
	}
}
