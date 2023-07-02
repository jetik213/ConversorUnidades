package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseListener;
import java.net.URI;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class DialogoAcerca extends JInternalFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTienda;
	private JButton btnCerrar;
	private JLabel lblDesarrollado;
	private JLabel lblAnio;
	private JLabel lblLimaPeru;
	private JLabel lblAutor;
	private JLabel lblMarco;
	private JLabel lblFondo;
	private JLabel lblNombre;
	private JLabel lblGithub;
	private JLabel lblGitEnlace;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogoAcerca dialog = new DialogoAcerca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoAcerca() {
		setFrameIcon(new ImageIcon(DialogoAcerca.class.getResource("/imagenes/icono-acerca.png")));
		setClosable(true);
		setResizable(false);
		setTitle("Acerca de la Tienda");
		setBounds(100, 100, 440, 421);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.WHITE);
		contentPanel.setBackground(new Color(70, 130, 180));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblTienda = new JLabel("CONVERSOR DE UNIDADES");
		lblTienda.setForeground(Color.DARK_GRAY);
		lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienda.setFont(new Font("Consolas", Font.BOLD, 22));
		lblTienda.setBounds(70, 26, 300, 23);
		contentPanel.add(lblTienda);
		
		lblNombre = new JLabel("\"LA CUISINE TEC\"");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Consolas", Font.BOLD, 22));
		lblNombre.setBounds(70, 53, 300, 23);
		contentPanel.add(lblNombre);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(Color.DARK_GRAY);
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnCerrar.setIcon(new ImageIcon(DialogoAcerca.class.getResource("/imagenes/icono-cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(155, 330, 130, 40);
		contentPanel.add(btnCerrar);

		lblDesarrollado = new JLabel("Desarrollado por:");
		lblDesarrollado.setForeground(Color.DARK_GRAY);
		lblDesarrollado.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesarrollado.setFont(new Font("Consolas", Font.BOLD, 16));
		lblDesarrollado.setBounds(70, 93, 300, 23);
		contentPanel.add(lblDesarrollado);

		lblAnio = new JLabel("2023");
		lblAnio.setForeground(Color.DARK_GRAY);
		lblAnio.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnio.setFont(new Font("Consolas", Font.BOLD, 14));
		lblAnio.setBounds(70, 256, 300, 15);
		contentPanel.add(lblAnio);

		lblLimaPeru = new JLabel("Lima, Per\u00FA");
		lblLimaPeru.setForeground(Color.DARK_GRAY);
		lblLimaPeru.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimaPeru.setFont(new Font("Consolas", Font.BOLD, 14));
		lblLimaPeru.setBounds(70, 278, 300, 15);
		contentPanel.add(lblLimaPeru);
		
		lblAutor = new JLabel("Jeffrey Tineo Kam");
		lblAutor.setForeground(Color.DARK_GRAY);
		lblAutor.setFont(new Font("Consolas", Font.BOLD, 14));
		lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor.setBounds(70, 123, 300, 30);
		contentPanel.add(lblAutor);
		
		lblGithub = new JLabel("Proyecto en GITHUB:");
		lblGithub.setHorizontalAlignment(SwingConstants.CENTER);
		lblGithub.setForeground(Color.DARK_GRAY);
		lblGithub.setFont(new Font("Consolas", Font.BOLD, 16));
		lblGithub.setBounds(70, 176, 300, 23);
		contentPanel.add(lblGithub);
		
		lblGitEnlace = new JLabel("https://github/jetik");
		lblGitEnlace.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGitEnlace.addMouseListener(this);
		lblGitEnlace.setHorizontalAlignment(SwingConstants.CENTER);
		lblGitEnlace.setForeground(Color.DARK_GRAY);
		lblGitEnlace.setFont(new Font("Consolas", Font.BOLD, 14));
		lblGitEnlace.setBounds(70, 206, 300, 30);
		contentPanel.add(lblGitEnlace);
		
		lblMarco = new JLabel("");
		lblMarco.setIcon(new ImageIcon(DialogoAcerca.class.getResource("/imagenes/fondo_marco.png")));
		lblMarco.setBackground(new Color(211, 211, 211));
		lblMarco.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		lblMarco.setBounds(70, 10, 300, 300);
		contentPanel.add(lblMarco);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(DialogoAcerca.class.getResource("/imagenes/fodo_acerca.gif")));
		lblFondo.setBounds(0, 0, 428, 392);
		contentPanel.add(lblFondo);
		

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	//Boton Cerrar
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblGitEnlace) {
			mouseClickedLblGitEnlace(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedLblGitEnlace(MouseEvent e) {
		try {
			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				if (desktop.isSupported(Desktop.Action.BROWSE)) {
					desktop.browse(new URI("https://github.com/jetik213"));
				}
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}