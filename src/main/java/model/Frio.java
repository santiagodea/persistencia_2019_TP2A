package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;

import org.hibernate.annotations.Type;

@Entity(name="Frio")
public class Frio extends Alimento {

	@Type(type = "integer")
	private int temperaturaMinima;
	
	@Type(type = "integer")
	private int temperaturaMaxima;
	
	public Frio(){
		super();
	}
	
	public Frio(String codigo, String descripcion, Proveedor proveedor,int temperaturaMinima, int temperaturaMaxima, LocalDate fechaIngreso){
		super(codigo, descripcion, proveedor, fechaIngreso);
		this.temperaturaMaxima = temperaturaMaxima;
		this.temperaturaMinima = temperaturaMinima;
	}

	public int getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public void setTemperaturaMinima(int temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}

	public int getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(int temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}

	@Override
	public Double getPrecioFinal() {
		if ((LocalDate.now().minus(5, ChronoUnit.DAYS).isAfter(getFechaDeIngreso()))){
			return ((this.getPrecio().getMonto() * 1.05) * 0.50);
		}
		else{return (this.getPrecio().getMonto() * 1.05);}
	}


}
