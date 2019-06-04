package model;

import java.io.Console;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Precio")
@Table(name = "precio")
public class Precio {
	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "nativoDeBaseDeDatos")
	@GenericGenerator(name = "nativoDeBaseDeDatos", strategy = "native")
	private Integer id;

	@Column(nullable = false, unique = true)
	//@Type(type = "double")
	private Double monto;

		
	// @Type(type="date")
	private LocalDate fechaAlta;
	
	// @Type(type="date")
	private LocalDate fechaBaja;

	@OneToOne
	@JoinColumn(name = "producto_id", foreignKey=@ForeignKey(name="precio_id_fk"))
	private Producto producto;

	public Precio() {
		super();
	}

	public Precio(Double monto, Producto producto) {
		this.monto = monto;
		this.fechaAlta = LocalDate.now();
		this.producto = producto;
		this.fechaBaja = null; // SI UN PRECIO TIENE CARGADA SU FECHA DE BAJA SIGNIFICA QUE NO ESTA VIGENTE... (HISTORICO)
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public LocalDate getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Precio))
			return false;
		Precio other = (Precio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void darDeBajarPrecio(){
		this.fechaBaja = LocalDate.now();
	}
}
