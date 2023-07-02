package controlador;

import vista.FrmTemperatura;
import modelo.TemperaturaModel;

public class TemperaturaController {
	
	private FrmTemperatura vista;
	private TemperaturaModel modelo;
	
	private String unidadInicio;
	private String unidadFin;
	
    public TemperaturaController(FrmTemperatura vista, TemperaturaModel modelo) {
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
		imprimir(" "+modelo.getCantidadInicial()+" "+unidadInicio);
		imprimir(" ES IGUAL A :");
		imprimir(" "+cantidadFinal+" "+unidadFin);
    }
    
    private void convertircelsius(double celsius) {
    	modelo.setKelvin(celsius + 273.15);
    	modelo.setFahrenheit((celsius * 9 / 5) + 32);
    }
    
    private double conversor (double cantidad) {
    	double fin = 0;
    	
		switch (unidadInicio) {
		case "Celsius (C)":
			modelo.setCelsius(cantidad);
			break;
		case "Kelvin (K)":
			modelo.setCelsius(cantidad / 1000);
			break;
		case "Fahrenheit (F)":
			modelo.setCelsius(cantidad * 1000);
			break;
		default:
			break;
		}		
		convertircelsius(modelo.getCelsius());
		
		switch (unidadFin) {
		case "Celsius (C)":
			fin = modelo.getCelsius();
			break;
		case "Kelvin (K)":
			fin = modelo.getKelvin();
			break;
		case "Fahrenheit (F)":
			fin = modelo.getFahrenheit();
			break;
		default:
			break;
		}
		return fin;
    }    
    
    public void convertir() {    	
    	try {
    		
			modelo.setCantidadInicial((redondear(vista.getCantidad())));
	    	unidadInicio = (String) vista.getCboUnidadInicio().getSelectedItem();
	    	unidadFin = (String) vista.getCboUnidadFin().getSelectedItem();
	    	double cantidadInicial = modelo.getCantidadInicial();	    	
	    	double cantidadFinal = redondear(conversor(cantidadInicial));
			
			mostrarResultados("Grados "+unidadInicio, "Grados "+unidadFin, cantidadInicial, cantidadFinal);
			
		} catch (Exception e) {
			e.printStackTrace();
			vista.getTxtS().setText(" ERROR: ¡INGRESA UNA CANTIDAD VÁLIDA!");
		}
    	
    }

}
