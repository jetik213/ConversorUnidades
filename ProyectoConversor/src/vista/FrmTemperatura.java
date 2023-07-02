package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import controlador.TemperaturaController;


public class FrmTemperatura extends JInternalFrame implements ActionListener, KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2467396868898028237L;
	private JPanel contentPane;
	private JLabel lblDe;
	private JLabel lblA;
	private JLabel lblCantidad;
	private JComboBox<String> cboUnidadInicio;
	private JTextField txtCantidad;
	private JButton btnConvertir;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnBorrar;
	private JLabel lblBackground;
	private JComboBox<String> cboUnidadFin;	
	private TemperaturaController controller;

	
    public void setController(TemperaturaController controller) {
        this.controller = controller;
    }

	/**
	 * Create the frame.
	 */
	public FrmTemperatura() {
		setFrameIcon(new ImageIcon(FrmTemperatura.class.getResource("/imagenes/icono-temperatura.png")));
		setIconifiable(true);
		setClosable(true);
		setTitle("Conversor de Temperatura");
		setBounds(100, 100, 480, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDe = new JLabel("De:");
		lblDe.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDe.setFont(new Font("Consolas", Font.BOLD, 12));
		lblDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDe.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblDe.setForeground(Color.WHITE);
		lblDe.setBounds(20, 20, 90, 20);
		contentPane.add(lblDe);
		
		lblA = new JLabel("A:");
		lblA.setVerticalAlignment(SwingConstants.BOTTOM);
		lblA.setFont(new Font("Consolas", Font.BOLD, 12));
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblA.setForeground(Color.WHITE);
		lblA.setBounds(20, 50, 90, 20);
		contentPane.add(lblA);
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCantidad.setFont(new Font("Consolas", Font.BOLD, 12));
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setBounds(20, 80, 90, 19);
		contentPane.add(lblCantidad);
		
		cboUnidadInicio = new JComboBox<>();
		cboUnidadInicio.addActionListener(this);
		cboUnidadInicio.setForeground(Color.WHITE);
		cboUnidadInicio.setBackground(new Color(70, 130, 180));
		cboUnidadInicio.setFont(new Font("Consolas", Font.BOLD, 14));
		cboUnidadInicio.setModel(new DefaultComboBoxModel(new String[] {"Celsius (C)", "Kelvin (K)", "Fahrenheit (F)"}));
		cboUnidadInicio.setBounds(130, 20, 160, 20);
		contentPane.add(cboUnidadInicio);
		
		cboUnidadFin = new JComboBox<String>();
		cboUnidadFin.addActionListener(this);
		cboUnidadFin.setModel(new DefaultComboBoxModel(new String[] {"Celsius (C)", "Kelvin (K)", "Fahrenheit (F)"}));
		cboUnidadFin.setSelectedIndex(1);
		cboUnidadFin.setForeground(Color.WHITE);
		cboUnidadFin.setFont(new Font("Consolas", Font.BOLD, 14));
		cboUnidadFin.setBackground(new Color(70, 130, 180));
		cboUnidadFin.setBounds(130, 50, 160, 20);
		contentPane.add(cboUnidadFin);
		
		txtCantidad = new JTextField();
		txtCantidad.addKeyListener(this);
		txtCantidad.setForeground(Color.DARK_GRAY);
		txtCantidad.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtCantidad.setBounds(130, 80, 80, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnConvertir = new JButton("CONVERTIR");
		btnConvertir.addActionListener(this);
		btnConvertir.setFont(new Font("Consolas", Font.BOLD, 12));
		btnConvertir.setForeground(Color.WHITE);
		btnConvertir.setBackground(Color.DARK_GRAY);
		btnConvertir.setIcon(new ImageIcon(FrmTemperatura.class.getResource("/imagenes/icono-resetear.png")));
		btnConvertir.setBounds(80, 300, 130, 40);
		contentPane.add(btnConvertir);
		
		btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Consolas", Font.BOLD, 12));
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setBackground(Color.DARK_GRAY);
		btnCerrar.setIcon(new ImageIcon(FrmTemperatura.class.getResource("/imagenes/icono-cerrar.png")));
		btnCerrar.setBounds(318, 20, 130, 40);
		contentPane.add(btnCerrar);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(this);
		btnBorrar.setFont(new Font("Consolas", Font.BOLD, 12));
		btnBorrar.setForeground(Color.WHITE);
		btnBorrar.setBackground(Color.DARK_GRAY);
		btnBorrar.setIcon(new ImageIcon(FrmTemperatura.class.getResource("/imagenes/icono-borrar.png")));
		btnBorrar.setBounds(270, 300, 130, 40);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 110, 428, 180);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Consolas", Font.BOLD, 15));
		txtS.setForeground(Color.DARK_GRAY);
		txtS.setBackground(new Color(224, 255, 255));
		scrollPane.setViewportView(txtS);
		
		lblBackground = new JLabel("");
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackground.setIcon(new ImageIcon(FrmTemperatura.class.getResource("/imagenes/fondo_ventanas.gif")));
		lblBackground.setBounds(0, 0, 480, 480);
		contentPane.add(lblBackground);

	}
	
    // Métodos de acceso a los componentes	
    public JComboBox<String> getCboUnidadInicio() {
        return cboUnidadInicio;
    }
    
    public JComboBox<String> getCboUnidadFin() {
        return cboUnidadFin;
    }

    public JTextField getTxtCantidad() {
        return txtCantidad;
    }
    
    public JTextArea getTxtS() {
        return txtS;
    }

    public JButton getBtnConvertir() {
        return btnConvertir;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public JButton getBtnCerrar() {
        return btnCerrar;
    }


    public Double getCantidad() {
    	try {
    		return Double.parseDouble(txtCantidad.getText());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

    }

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCantidad) {
			keyTypedTxtCantidad(e);
		}
		
	}

	private void keyTypedTxtCantidad(KeyEvent e) {
		char c = e.getKeyChar();
		if (( c < '0' || c > '9') && c!='.' && c!='-')
			e.consume();	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCerrar) {
            controller.cerrar();
        } else if (e.getSource() == btnConvertir) {
            controller.convertir();
        } else if (e.getSource() == btnBorrar) {
            controller.borrar();
        }
    }
}