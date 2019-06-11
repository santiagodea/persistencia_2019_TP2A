package model;

import java.time.LocalDate;

import javax.persistence.Entity;


@Entity(name="Alimento")
public abstract class Alimento extends Producto {

	private LocalDate fechaDeIngreso;
	
	public Alimento(){
		super();
	}
	
	public Alimento(String codigo, String descripcion, Proveedor proveedor){
		super(codigo, descripcion, proveedor);
	}
	
	public Alimento(String codigo, String descripcion, Proveedor proveedor, LocalDate fechaIngreso){
		super(codigo, descripcion, proveedor);
		this.fechaDeIngreso = fechaIngreso;
	}

	public LocalDate getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	
}
