package modelo;

public class VolumenModel extends CantidadModel{

	double litros;
	double mililitros;
	double galones;
	double piesCubico;
	double onzasLiquida;
	
	public VolumenModel() {
		super();
	}

	public double getLitros() {
		return litros;
	}

	public void setLitros(double litros) {
		this.litros = litros;
	}

	public double getMililitros() {
		return mililitros;
	}

	public void setMililitros(double mililitros) {
		this.mililitros = mililitros;
	}

	public double getGalones() {
		return galones;
	}

	public void setGalones(double galones) {
		this.galones = galones;
	}

	public double getPiesCubico() {
		return piesCubico;
	}

	public void setPiesCubico(double piesCubico) {
		this.piesCubico = piesCubico;
	}

	public double getOnzasLiquida() {
		return onzasLiquida;
	}

	public void setOnzasLiquida(double onzasLiquida) {
		this.onzasLiquida = onzasLiquida;
	}

}
