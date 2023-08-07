import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PageBuscar extends Page {
	private JTextField buscarField;

	public PageBuscar(GUI gui, Trie trie) {
		super(gui, trie);
		contenido();
	}

	public void contenido() {
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setBounds(10, 22, 100, 14);
		add(lblBuscar);

		buscarField = new JTextField();
		buscarField.setBounds(61, 19, 247, 20);
		add(buscarField);
		buscarField.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTrie(gui.getTextArea().getText());

				if (gui.getTextArea().getText().isEmpty()) {
					mensajeError("Ingrese un texto");
				} else if (buscarField.getText().equals("")) {
					mensajeError("Ingrese una palabra a buscar");
				} else {
					String palabraBuscar = buscarField.getText().trim();
					if (trie.search(palabraBuscar)) {
						mensaje("La palabra buscada se encuentra en el texto");
					} else {
						mensaje("La palabra buscada no se encuentra en el texto");
					}
				}
			}
		});
		btnBuscar.setBounds(10, 100, 89, 23);
		add(btnBuscar);
	}
}
