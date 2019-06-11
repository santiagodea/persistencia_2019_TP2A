package model;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity(name="Gondola")
public class Gondola extends Alimento {

	private Double volumen;
	
	public Gondola(){
		super();
	}
	
	
	public Gondola(String codigo, String descripcion, Proveedor proveedor, Double volumen, LocalDate fechaIngreso){
		super(codigo, descripcion, proveedor, fechaIngreso);
		this.volumen = volumen;
	}


	public Double getVolumen() {
		return volumen;
	}


	public void setVolumen(Double volumen) {
		this.volumen = volumen;
	}


	@Override
	public Double getPrecioFinal() {
		if (this.getVolumen() > 400){
			return (this.getPrecio().getMonto() * 1.03);
		}
		else{ return this.getPrecio().getMonto();}
	}
	
}

