

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import controlador.*;
import modelo.*;
import vista.*;


public class Convertidor extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6079186685671202215L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnInicio;
	private JMenu mnConversor;
	private JMenu mnAcerca;
	private JMenuItem mntmSalir;
	private JMenuItem mntmTemperatura;
	private JMenuItem mntmMasa;
	private JMenuItem mntmVolumen;
	private JMenuItem mntmInfoDesarrollador;
	private JDesktopPane desktopPane;
	private JMenu mnDivisas;
	private JMenuItem mntmMonedas;
	private JMenuItem mntmOtros;


	// =================================================
	//                 MAIN PRINCIPAL
	// =================================================
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Convertidor frame = new Convertidor();
					
					//maximizamos el form principal
					frame.setExtendedState(MAXIMIZED_BOTH);
					//centramos el form principal					
					frame.setLocationRelativeTo(null);
					
					//hacemos el formulario visible
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// =================================================
	//                   CONSTRUCTOR
	// =================================================
	public Convertidor() {
		setForeground(Color.DARK_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Convertidor.class.getResource("/imagenes/icono-principal.png")));
		setBackground(Color.WHITE);
		setFont(new Font("Consolas", Font.BOLD, 16));
		setTitle("CONVERSOR DE UNIDADES \"LA CUISINE TEC\"");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 400);
		
		menuBar = new JMenuBar();
		menuBar.setBorder(new LineBorder(Color.WHITE, 2));
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		mnInicio = new JMenu("Inicio");
		mnInicio.setBorder(new LineBorder(Color.WHITE, 2));
		mnInicio.setForeground(Color.WHITE);
		mnInicio.setIcon(new ImageIcon(Convertidor.class.getResource("/imagenes/icono-inicio.png")));
		menuBar.add(mnInicio);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setBorder(new LineBorder(new Color(255, 255, 255)));
		mntmSalir.setForeground(Color.WHITE);
		mntmSalir.setBackground(Color.DARK_GRAY);
		mntmSalir.setIcon(new ImageIcon(Convertidor.class.getResource("/imagenes/icono-salir.png")));
		mntmSalir.addActionListener(this);
		mnInicio.add(mntmSalir);
		
		mnConversor = new JMenu("Conversor");
		mnConversor.setForeground(Color.WHITE);
		mnConversor.setBorder(new LineBorder(Color.WHITE, 2));
		mnConversor.setIcon(new ImageIcon(Convertidor.class.getResource("/imagenes/icono-conversor.png")));
		menuBar.add(mnConversor);
		
		mntmTemperatura = new JMenuItem("Temperatura");
		mntmTemperatura.setForeground(Color.WHITE);
		mntmTemperatura.setBorder(new LineBorder(new Color(255, 255, 255)));
		mntmTemperatura.setBackground(Color.DARK_GRAY);
		mntmTemperatura.setIcon(new ImageIcon(Convertidor.class.getResource("/imagenes/icono-temperatura.png")));
		mntmTemperatura.addActionListener(this);
		mnConversor.add(mntmTemperatura);
		
		mntmMasa = new JMenuItem("Masa");
		mntmMasa.setBackground(Color.DARK_GRAY);
		mntmMasa.setBorder(new LineBorder(new Color(255, 255, 255)));
		mntmMasa.setIcon(new ImageIcon(Convertidor.class.getResource("/imagenes/icono-masa.png")));
		mntmMasa.setForeground(Color.WHITE);
		mntmMasa.addActionListener(this);
		mnConversor.add(mntmMasa);
		
		mntmVolumen = new JMenuItem("Volumen");
		mntmVolumen.setForeground(Color.WHITE);
		mntmVolumen.setBorder(new LineBorder(new Color(255, 255, 255)));
		mntmVolumen.setBackground(Color.DARK_GRAY);
		mntmVolumen.setIcon(new ImageIcon(Convertidor.class.getResource("/imagenes/icono-volumen.png")));
		mntmVolumen.addActionListener(this);
		mnConversor.add(mntmVolumen);
		
		mntmOtros = new JMenuItem("Otros");
		mntmOtros.setIcon(new ImageIcon(Convertidor.class.getResource("/imagenes/icono-otros.png")));
		mntmOtros.setForeground(Color.WHITE);
		mntmOtros.setBorder(new LineBorder(new Color(255, 255, 255)));
		mntmOtros.setBackground(Color.DARK_GRAY);
		mntmOtros.addActionListener(this);
		mnConversor.add(mntmOtros);
		
		mnDivisas = new JMenu("Divisas");
		mnDivisas.setIcon(new ImageIcon(Convertidor.class.getResource("/imagenes/icono-venta.png")));
		mnDivisas.setForeground(Color.WHITE);
		mnDivisas.setBorder(new LineBorder(Color.WHITE, 2));
		menuBar.add(mnDivisas);
		
		mntmMonedas = new JMenuItem("Monedas");
		mntmMonedas.setBorder(new LineBorder(Color.WHITE));
		mntmMonedas.setBackground(Color.DARK_GRAY);
		mntmMonedas.setForeground(Color.WHITE);
		mntmMonedas.setIcon(new ImageIcon(Convertidor.class.getResource("/imagenes/icono-monedas.png")));
		mntmMonedas.addActionListener(this);
		mnDivisas.add(mntmMonedas);
		
		mnAcerca = new JMenu("Acerca");
		mnAcerca.setForeground(Color.WHITE);
		mnAcerca.setBorder(new LineBorder(Color.WHITE, 2));
		mnAcerca.setIcon(new ImageIcon(Convertidor.class.getResource("/imagenes/icono-ayuda.png")));
		menuBar.add(mnAcerca);
		
		mntmInfoDesarrollador = new JMenuItem("Info. Desarrollador");
		mntmInfoDesarrollador.setIcon(new ImageIcon(Convertidor.class.getResource("/imagenes/icono-acerca.png")));
		mntmInfoDesarrollador.setForeground(Color.WHITE);
		mntmInfoDesarrollador.setBackground(Color.DARK_GRAY);
		mntmInfoDesarrollador.setBorder(new LineBorder(Color.WHITE));
		mntmInfoDesarrollador.addActionListener(this);
		mnAcerca.add(mntmInfoDesarrollador);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		
		// =================================================
		//                 IMAGEN DE FONDO
		// =================================================		
		//Modificamos el desktopPane para incorporar imagen de fondo
		//Unicamente la usamos para poner la imagen, en la ruta que INDICADA		
		desktopPane = new JDesktopPane();
		try {
			desktopPane = new JDesktopPane(){
			 /**
				 * 
				 */
				private static final long serialVersionUID = -2156751220785708585L;
			Image img = javax.imageio.ImageIO.read(
				  	  new java.net.URL(getClass().getResource("/imagenes/fondo_cocina.jpg"), "fondo_cocina.jpg"));
					  public void paintComponent(Graphics g){
								  super.paintComponent(g);
								  if(img != null) g.drawImage(img, 0,0,this.getWidth(),this.getHeight(),this);
								  else g.drawString("Image not found", 100,100);
							 }
					  };
			} catch (IOException e) { e.printStackTrace();} 		
		
		contentPane.add(desktopPane, BorderLayout.CENTER);
		}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == mntmTemperatura) {
			actionPerformedMntmTemperatura(e);
		}
		if (e.getSource() == mntmMasa) {
			actionPerformedMntmMasa(e);
		}
		if (e.getSource() == mntmVolumen) {
			actionPerformedMntmVolumen(e);
		}
		if (e.getSource() == mntmOtros) {
			actionPerformedMntmOtros(e);
		}
		if (e.getSource() == mntmMonedas) {
			actionPerformedMntmMonedas(e);
		}
		if (e.getSource() == mntmInfoDesarrollador) {
			actionPerformedMntmAcercaDeTienda(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	

	// =================================================
	//                   MENU INICIO
	// =================================================
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	
		
	// =================================================
	//                MENU CONVERSOR
	// =================================================	
	protected void actionPerformedMntmTemperatura(ActionEvent e) {
		FrmTemperatura frm = new FrmTemperatura();
		desktopPane.add(frm);	// agrega el formulario frm dentro de dektopPane
		//Dimensionar el frm para que se muestre en el centro del desktopPane
		Dimension desktopSize = desktopPane.getSize(); //Hacer click en el error e importar Dimension
		Dimension FrameSize = frm.getSize();
		TemperaturaModel modelo = new TemperaturaModel();
		TemperaturaController controller = new TemperaturaController(frm, modelo);
		frm.setController(controller);
		frm.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);		
		frm.setVisible(true);	
	}
	
	 
	protected void actionPerformedMntmMasa(ActionEvent e) {
		FrmMasa frm = new FrmMasa();
		desktopPane.add(frm);	// agrega el formulario frm dentro de dektopPane
		//Dimensionar el frm para que se muestre en el centro del desktopPane
		Dimension desktopSize = desktopPane.getSize(); //Hacer click en el error e importar Dimension
		Dimension FrameSize = frm.getSize();
		MasaModel modelo = new MasaModel();
		MasaController controller = new MasaController(frm, modelo);
		frm.setController(controller);
		frm.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);		
		frm.setVisible(true);
	}
	
	
	protected void actionPerformedMntmVolumen(ActionEvent e) {
		FrmVolumen frm = new FrmVolumen();
		desktopPane.add(frm);	// agrega el formulario frm dentro de dektopPane
		//Dimensionar el frm para que se muestre en el centro del desktopPane
		Dimension desktopSize = desktopPane.getSize(); //Hacer click en el error e importar Dimension
		Dimension FrameSize = frm.getSize();
		VolumenModel modelo = new VolumenModel();
		VolumenController controller = new VolumenController(frm, modelo);
		frm.setController(controller);
		frm.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);		
		frm.setVisible(true);
	}
	
	protected void actionPerformedMntmOtros(ActionEvent e) {
		FrmOtros frm = new FrmOtros();
		desktopPane.add(frm);	// agrega el formulario frm dentro de dektopPane
		//Dimensionar el frm para que se muestre en el centro del desktopPane
		Dimension desktopSize = desktopPane.getSize(); //Hacer click en el error e importar Dimension
		Dimension FrameSize = frm.getSize();
		OtrosModel modelo = new OtrosModel();
		OtrosController controller = new OtrosController(frm, modelo);
		frm.setController(controller);
		frm.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);		
		frm.setVisible(true);
	}

	
	// =================================================
	//                MENU DIVISAS
	// =================================================	
	
	protected void actionPerformedMntmMonedas(ActionEvent e) {
		FrmMonedas frm = new FrmMonedas();
		desktopPane.add(frm);	// agrega el formulario frm dentro de dektopPane
		//Dimensionar el frm para que se muestre en el centro del desktopPane
		Dimension desktopSize = desktopPane.getSize(); //Hacer click en el error e importar Dimension
		Dimension FrameSize = frm.getSize();
		MonedasModel modelo = new MonedasModel();
		MonedasController controller = new MonedasController(frm, modelo);
		frm.setController(controller);
		frm.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);		
		frm.setVisible(true);
	}
	
	
	// =================================================
	//                   MENU AYUDA
	// =================================================	
	protected void actionPerformedMntmAcercaDeTienda(ActionEvent e) {
		DialogoAcerca frm = new DialogoAcerca();
		desktopPane.add(frm);	// agrega el formulario frm dentro de dektopPane
		//Dimensionar el frm para que se muestre en el centro del desktopPane
		Dimension desktopSize = desktopPane.getSize(); //Hacer click en el error e importar Dimension
		Dimension FrameSize = frm.getSize();
		frm.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
		frm.setVisible(true);
	}	
}