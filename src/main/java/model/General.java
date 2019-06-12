package model;

import javax.persistence.Entity;

import org.hibernate.annotations.Type;

@Entity(name="General")
public class General extends Producto {

	
	@Type(type = "integer")
	private int peso;
	
	public General(){
		super();
	}
	
	public General(String codigo, String descripcion, Proveedor proveedor){
		super(codigo, descripcion, proveedor);
	}
	
	public General(String codigo, String descripcion, Proveedor proveedor, int peso){
		super(codigo, descripcion, proveedor);
		this.peso = peso;
	}
	
	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public Double getPrecioFinal() {
		if (this.getPeso() >= 2 && this.getPeso() < 4){
			return this.getPrecio().getMonto() * 1.04;
		}
		else if (this.getPeso() >= 4 && this.getPeso() < 7){
			return this.getPrecio().getMonto() * 1.07;
		}
		else if (this.getPeso() > 7){
			return (this.getPrecio().getMonto() * 1.12);
		}
		else {
			return this.getPrecio().getMonto();
			}
		
	}
}
