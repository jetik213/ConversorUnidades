package controlador;

import vista.FrmMasa;
import modelo.MasaModel;

public class MasaController {
	
	private FrmMasa vista;
	private MasaModel modelo;
	
	private String unidadInicio;
	private String unidadFin;
	
    public MasaController(FrmMasa vista, MasaModel modelo) {
        this.vista = vista;
        this.modelo = modelo;  
    }
    
    public void cerrar() {
        vista.dispose();
    }
    
    public void borrar() {
        vista.getTxtCantidad().setText("");
        vista.getTxtS().setText("");
        vista.getCboUnidadInicio().setSelectedIndex(0);
        vista.getCboUnidadFin().setSelectedIndex(1);
        vista.getTxtCantidad().requestFocus();
    }
    
    // Metodo para redondear
    private double redondear(double num) {
	    return Math.round(num*100.0)/100.0;
    }
    
    // Metodo para imprimir
 	void imprimir(String cad) {
 		vista.getTxtS().append(cad + "\n");
 	}

    public void mostrarResultados(String unidadInicio, String unidadFin, double cantidadInicial, double cantidadFinal) {
    	vista.getTxtS().setText("");
		
		imprimir("\n CONVERSIÓN REALIZADA:\n");
		imprimir(" "+cantidadInicial+" "+unidadInicio);
		imprimir(" ES IGUAL A :");
		imprimir(" "+cantidadFinal+" "+unidadFin);
    }
        
    private void convertirKilogramos(double kilogramos) {
    	modelo.setGramos(kilogramos * 1000);
    	modelo.setToneladas(kilogramos / 1000);
    	modelo.setLibras(kilogramos * 2.2046);
    	modelo.setOnzas(kilogramos * 35.274);
    }
    
    private double conversor (double cantidad) {
    	
    	double fin = 0;
    	
		switch (unidadInicio) {
		case "Kilogramos (Kg)":
			modelo.setKilogramos(cantidad);
			break;
		case "Gramos (g)":
			modelo.setKilogramos(cantidad / 1000);
			break;
		case "Toneladas (t)":
			modelo.setKilogramos(cantidad * 1000);
			break;
		case "Libras (lb)":
			modelo.setKilogramos(cantidad / 2.20462);
			break;
		case "Onzas (Oz)":
			modelo.setKilogramos(cantidad / 35.274);
			break;
		default:
			break;
		}		
		convertirKilogramos(modelo.getKilogramos());
		
		switch (unidadFin) {
		case "Kilogramos (Kg)":
			fin = modelo.getKilogramos();
			break;
		case "Gramos (g)":
			fin = modelo.getGramos();
			break;
		case "Toneladas (t)":
			fin = modelo.getToneladas();
			break;
		case "Libras (lb)":
			fin = modelo.getLibras();
			break;
		case "Onzas (Oz)":
			fin = modelo.getOnzas();
			break;
		default:
			break;
		}
		return fin;
    }
        
    public void convertir() {    	
    	try {
			modelo.setCantidadInicial(redondear(vista.getCantidad()));
	    	unidadInicio = (String) vista.getCboUnidadInicio().getSelectedItem();
	    	unidadFin = (String) vista.getCboUnidadFin().getSelectedItem();
	    	double cantidadInicial = modelo.getCantidadInicial();	    	
	    	double cantidadFinal = redondear(conversor(cantidadInicial));
			
			mostrarResultados(unidadInicio, unidadFin, cantidadInicial, cantidadFinal);
			
		} catch (Exception e) {
			e.printStackTrace();
			vista.getTxtS().setText(" ERROR: ¡INGRESA UNA CANTIDAD VÁLIDA!");
		}
    	
    }

}
