package controlador;

import vista.FrmVolumen;
import modelo.VolumenModel;

public class VolumenController {
	
	private FrmVolumen vista;
	private VolumenModel modelo;
	
	private String unidadInicio;
	private String unidadFin;
	
    public VolumenController(FrmVolumen vista, VolumenModel modelo) {
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
        
    private void convertirLitros(double litros) {
    	modelo.setMililitros(litros * 1000);
    	modelo.setGalones(litros * 0.264172);
    	modelo.setPiesCubico(litros * 0.0353147);
    	modelo.setOnzasLiquida(litros * 33.814);
    }
    
    private double conversor (double cantidad) {
    	
    	double fin = 0;
    	
		switch (unidadInicio) {
		case "Litros (l)":
			modelo.setLitros(cantidad);
			break;
		case "Mililitros (ml)":
			modelo.setLitros(cantidad / 1000);
			break;
		case "Galones (gal)":
			modelo.setLitros(cantidad * 3.78541);
			break;
		case "Pies Cúbicos (ft3)":
			modelo.setLitros(cantidad / 0.0353147);
			break;
		case "Onzas Líquidas (oz)":
			modelo.setLitros(cantidad / 33.814);
			break;
		default:
			break;
		}		
		convertirLitros(modelo.getLitros());
		
		switch (unidadFin) {
		case "Litros (l)":
			fin = modelo.getLitros();
			break;
		case "Mililitros (ml)":
			fin = modelo.getMililitros();
			break;
		case "Galones (gal)":
			fin = modelo.getGalones();
			break;
		case "Pies Cúbicos (ft3)":
			fin = modelo.getPiesCubico();
			break;
		case "Onzas Líquidas (oz)":
			fin = modelo.getOnzasLiquida();
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
