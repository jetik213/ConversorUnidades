package modelo;

public class MonedasModel extends CantidadModel{
	
	double soles;
	double dolares;
	double euros;
	double librasEsterlinas;
	double yenes;
	double wons;
	
	public MonedasModel() {
		super();
	}

	public double getSoles() {
		return soles;
	}

	public void setSoles(double soles) {
		this.soles = soles;
	}

	public double getDolares() {
		return dolares;
	}

	public void setDolares(double dolares) {
		this.dolares = dolares;
	}

	public double getEuros() {
		return euros;
	}

	public void setEuros(double euros) {
		this.euros = euros;
	}

	public double getLibrasEsterlinas() {
		return librasEsterlinas;
	}

	public void setLibrasEsterlinas(double librasEsterlinas) {
		this.librasEsterlinas = librasEsterlinas;
	}

	public double getYenes() {
		return yenes;
	}

	public void setYenes(double yenes) {
		this.yenes = yenes;
	}

	public double getWons() {
		return wons;
	}

	public void setWons(double wons) {
		this.wons = wons;
	}

}
