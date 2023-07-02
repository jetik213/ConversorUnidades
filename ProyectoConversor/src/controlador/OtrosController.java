package controlador;

import vista.FrmOtros;
import modelo.OtrosModel;

public class OtrosController {
	
	private FrmOtros vista;
	private OtrosModel modelo;
	
	private String unidadInicio;
	private String unidadFin;
	
    public OtrosController(FrmOtros vista, OtrosModel modelo) {
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
    
    // Metodo para imprimir
 	void imprimir(String cad) {
 		vista.getTxtS().append(cad + "\n");
 	}

    public void mostrarResultados(String unidadInicio, String mensajeFin, int cantidadInicial) {
    	vista.getTxtS().setText("");
		
		imprimir("\n CONVERSIÓN REALIZADA:\n");
		imprimir(" "+cantidadInicial+" "+unidadInicio);
		imprimir(" ES IGUAL A :");
		imprimir(" "+mensajeFin);
    }
    
    private String convertirCucharasCucharitas (int cantidad) {
    	
    	String fin = "";
    	
		switch (unidadInicio) {
			case "Cucharadas":			
				modelo.setCucharaditas(cantidad * 3);
				fin = modelo.getCucharaditas() + " Cucharaditas";
				break;
			case "Cucharaditas":
				modelo.setCucharaditas(cantidad);
				fin = modelo.getCucharaditas() + " Cucharadita(s)";
				break;
			case "Tazas":
				modelo.setCucharadas(cantidad * 10);
				modelo.setCucharaditas(cantidad * 30);
				fin = modelo.getCucharadas() + " Cucharadas o " + modelo.getCucharaditas() + " Cucharaditas";
				break;
			case "Tacitas":
				modelo.setCucharaditas(cantidad * 20);
				int cucharas = modelo.getCucharaditas() / 3;
				int cucharitas = modelo.getCucharaditas() % 3;
				if (cucharitas == 0)
					fin = cucharas + " Cucharada(s)";
				else 
					fin = cucharas + " Cucharada(s) y " + cucharitas + " Cucharadita(s)";			
				break;
			case "Pintas":
				modelo.setCucharadas(cantidad * 20);
				modelo.setCucharaditas(cantidad * 60);
				fin = modelo.getCucharadas() + " Cucharadas o " + modelo.getCucharaditas() + " Cucharaditas";
				break;
			default:
				break;
		}
		
		return fin;
    }
    
    private String convertirTazasTacitas (int cantidad) {
    	
    	String fin = "";
    	int entero = 0;
    	int fraccion = 0;
    	
		switch (unidadInicio) {
			case "Cucharadas":
				if(cantidad<10) {
					entero = cantidad;
					fin = entero+"/10 parte(s) de Taza";
				}				
				else {
					entero = cantidad / 10;
					fraccion = cantidad % 10;
					if (fraccion == 0)
						fin = entero+" Taza(s)";
					else
						fin = entero+" Taza(s) "+fraccion+"/10 parte(s) de Taza";
				}
				break;
			case "Cucharaditas":
				if(cantidad<20) {
					entero = cantidad;
					fin = entero+"/20 parte(s) de Tacita";
				}				
				else {
					entero = cantidad / 20;
					fraccion = cantidad % 20;
					if (fraccion == 0)
						fin = entero+" Tacita(s)";
					else
						fin = entero+" Tacita(s) "+fraccion+"/20 parte(s) de Tacita";
				}
				break;
			case "Tazas":
				if(cantidad<2) {
					fin = "1 Tacita y media";
				}				
				else {
					entero = (cantidad *3) / 2;
					fraccion = (cantidad *3) % 2;
					if (fraccion == 0)
						fin = entero+" Tacitas";
					else
						fin = entero+" Tacitas y media";
				}
				break;
			case "Tacitas":
				if(cantidad<3) {
					fin = cantidad + "/3 parte(s) de Taza";
				}				
				else {
					entero = (cantidad *2) / 3;
					fraccion = (cantidad *2) % 3;
					if (fraccion == 0)
						fin = entero+" Tazas";
					else
						fin = entero+" Tazas y "+fraccion+"/3 parte(s) de Taza";
				}
				break;
			case "Pintas":
				modelo.setTazas(cantidad * 2);
				fin = modelo.getTazas() + " Tazas";
				break;
			default:
				break;
			}
		
		return fin;
    }
    
    private String convertirMililitros (int cantidad) {
    	
    	String fin = "";
    	
		switch (unidadInicio) {
			case "Cucharadas":
				modelo.setMililitros(cantidad*15);
				fin = modelo.getMililitros() + " Mililitros";
				break;
			case "Cucharaditas":
				modelo.setMililitros(cantidad*5);
				fin = modelo.getMililitros() + " Mililitros";
				break;
			case "Tazas":
				modelo.setMililitros(cantidad*150);
				fin = modelo.getMililitros() + " Mililitros";
				break;
			case "Tacitas":
				modelo.setMililitros(cantidad*100);
				fin = modelo.getMililitros() + " Mililitros";			
				break;
			case "Pintas":
				modelo.setMililitros(cantidad*568);
				fin = modelo.getMililitros() + " Mililitros";
				break;
			default:
				break;
		}
		
		return fin;
    }
        
    public void convertir() {    	
    	try {
			modelo.setCantidadInicial(vista.getCantidad());
	    	unidadInicio = (String) vista.getCboUnidadInicio().getSelectedItem();
	    	unidadFin = (String) vista.getCboUnidadFin().getSelectedItem();	    	
	    	int cantidadInicial = (int) modelo.getCantidadInicial();
	    	
	    	String msjFin="";
	    	
	    	if (cantidadInicial == 0) {
	    		vista.getTxtS().setText(" ¡INGRESA UN NÚMERO MAYOR A CERO!");
			} else {
				switch (unidadFin) {
				case "Cucharas y Cucharitas":
					msjFin = convertirCucharasCucharitas(cantidadInicial);
					break;
				case "Tazas y Tacitas":
					msjFin = convertirTazasTacitas(cantidadInicial);
					break;
				case "Mililitros":
					msjFin = convertirMililitros(cantidadInicial);
					break;
				default:
					break;
				}
				mostrarResultados(unidadInicio, msjFin, cantidadInicial);
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
			vista.getTxtS().setText(" ERROR: ¡INGRESA UNA CANTIDAD VÁLIDA!");
		}
    	
    }

}
