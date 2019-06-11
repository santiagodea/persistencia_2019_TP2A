package model;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity(name="Congelado")
public class Congelado extends Alimento {

	public Congelado(){
		super();
	}
	
	public Congelado(String codigo, String descripcion, Proveedor proveedor, LocalDate fechaIngreso){
		super(codigo, descripcion, proveedor, fechaIngreso);
	}

	@Override
	public Double getPrecioFinal() {
		return (this.getPrecio().getMonto() * 1.08);
	}

}
