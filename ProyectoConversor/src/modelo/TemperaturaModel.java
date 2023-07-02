package modelo;

public class TemperaturaModel extends CantidadModel{

	double celsius;
	double kelvin;
	double fahrenheit;
	
	public TemperaturaModel() {
		super();
	}
	
	public double getCelsius() {
		return celsius;
	}
	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}
	public double getKelvin() {
		return kelvin;
	}
	public void setKelvin(double kelvin) {
		this.kelvin = kelvin;
	}
	public double getFahrenheit() {
		return fahrenheit;
	}
	public void setFahrenheit(double fahrenheit) {
		this.fahrenheit = fahrenheit;
	}
	
	
}
