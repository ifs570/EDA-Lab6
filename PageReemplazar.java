import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PageReemplazar extends Page {

	private JTextField buscarField;
	private JTextField reemplazarField;
	private JButton btnReemplazar;

	public PageReemplazar(GUI gui, Trie trie) {
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

		JLabel lblReemplazar = new JLabel("Reemplazar con:");
		lblReemplazar.setBounds(10, 60, 100, 14);
		add(lblReemplazar);

		reemplazarField = new JTextField();
		reemplazarField.setBounds(115, 57, 193, 20);
		add(reemplazarField);
		reemplazarField.setColumns(10);

		btnReemplazar = new JButton("Reemplazar");
		btnReemplazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTrie(gui.getTextArea().getText());

				if (gui.getTextArea().getText().isEmpty()) {
					mensajeError("Ingrese un texto");
				} else if (buscarField.getText().equals("")) {
					mensajeError("Ingrese una palabra a buscar");
				} else if (reemplazarField.getText().equals("")) {
					mensajeError("Ingrese una palabra a reemplazar");
				} else {
					String palabraBuscar = buscarField.getText().trim();
					String palabraReemplazar = reemplazarField.getText().trim();
					if (trie.search(palabraBuscar)) {
						trie.replace(palabraBuscar, palabraReemplazar);
						String texto = gui.getTextArea().getText().replaceAll(palabraBuscar, palabraReemplazar);
						gui.getTextArea().setText(texto);
						buscarField.setText(palabraReemplazar);
						reemplazarField.setText("");
					} else {
						mensaje("La palabra buscada no se encuentra en el texto");
					}
				}
			}
		});
		btnReemplazar.setBounds(10, 100, 120, 23);
		add(btnReemplazar);
	}

}
