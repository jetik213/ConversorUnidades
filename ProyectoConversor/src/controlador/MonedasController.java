package controlador;

import vista.FrmMonedas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import modelo.MonedasModel;

public class MonedasController {
	
	private FrmMonedas vista;
	private MonedasModel modelo;
	
	private String unidadInicio;
	private String unidadFin;
	
	String fecha="";
	double tipoCambio=0;
	
    public MonedasController(FrmMonedas vista, MonedasModel modelo) {
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

    public void mostrarResultados(String unidadInicio, String unidadFin, double cantidadInicial, double cantidadFinal, double tipoCamb, String dia) {
    	vista.getTxtS().setText("");
		
		imprimir("\n CONVERSIÓN REALIZADA:\n");
		imprimir(" Tipo de Cambio: "+tipoCamb);
		imprimir(" Actualizado al día: "+dia+"\n");
		imprimir(" "+cantidadInicial+" "+unidadInicio);
		imprimir(" ES IGUAL A :");
		imprimir(" "+cantidadFinal+" "+unidadFin);
    }
    
    private String sacarCodigo (String unidad) {

    	switch (unidad) {
			case "Soles (S/)":
				return "PEN";
			case "Dólares ($)":
				return "USD";
			case "Euros (Є)":
				return "EUR";
			case "Libras Esterlinas (£)":
				return "GBP";
			case "Yenes (¥)":
				return "JPY";
			case "Wons (₩)":
				return "KRW";
			default:
				return "";
		}

    }
    
    private double conversor (double cantidad) {
    	
    	double fin = 0;
    	
    	try {
            String apiEndpoint = "https://api.getgeoapi.com/v2/currency/convert";
            String apiKey = "7742feef95c8b1c8797af72182efa073461f3016";
            String fromCurrency = sacarCodigo(unidadInicio);
            String toCurrency = sacarCodigo(unidadFin);;
            double amount = cantidad;
            String format = "json";

            // Construir la URL de la solicitud
            String urlString = apiEndpoint + "?api_key=" + apiKey + "&from=" + fromCurrency +
                    "&to=" + toCurrency + "&amount=" + amount + "&format=" + format;
            URL url = new URL(urlString);

            // Establecer la conexión
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Leer la respuesta
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Analizar la respuesta JSON
            JSONObject jsonResponse = new JSONObject(response.toString());
            
            // Obtener el valor de "updated_date"
            fecha = jsonResponse.getString("updated_date");

            // Obtener el valor de "rate"
            tipoCambio = jsonResponse.getJSONObject("rates").getJSONObject(toCurrency).getDouble("rate");

            // Obtener el valor de "rate_for_amount"
            fin = jsonResponse.getJSONObject("rates").getJSONObject(toCurrency)
                    .getDouble("rate_for_amount");

            // Imprimir el resultado
            System.out.println("El valor de rate_for_amount es: " + fin);
    	} catch (Exception e) {
            e.printStackTrace();
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
			
			mostrarResultados(unidadInicio, unidadFin, cantidadInicial, cantidadFinal, tipoCambio, fecha);
			
		} catch (Exception e) {
			e.printStackTrace();
			vista.getTxtS().setText(" ERROR: ¡INGRESA UNA CANTIDAD VÁLIDA!");
		}
    	
    }

}
