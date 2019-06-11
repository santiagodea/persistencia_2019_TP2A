package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name = "Producto")
@Table(name = "producto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Producto {
	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "nativoDeBaseDeDatos")
	@GenericGenerator(name = "nativoDeBaseDeDatos", strategy = "native")
	private Integer id;

	@Column(length = 255, nullable = false)
	@Type(type = "string")
	private String codigo;

	@Column(length = 255, nullable = false)
	@Type(type = "string")
	private String descripcion;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "precio_id", foreignKey = @ForeignKey(name = "fk_producto_precio_id"))
	private Precio precio;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Proveedor> proveedores;

	public Producto() {
		super();
	}

	public Producto(String codigo, String descripcion, Proveedor proveedor, Double monto) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = new Precio(monto, this);
		this.proveedores = new ArrayList<Proveedor>();
		this.addProveedor(proveedor);
	}

	public Producto(String codigo, String descripcion, Proveedor proveedor) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = null;
		this.proveedores = new ArrayList<Proveedor>();
		this.addProveedor(proveedor);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Precio getPrecio() {
		return precio;
	}

	public void setPrecio(Precio precio) {
		this.precio = precio;
	}

	public List<Proveedor> getProvedores() {
		return proveedores;
	}

	public void setProvedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public void addProveedor(Proveedor proveedor) {
		this.proveedores.add(proveedor);
		proveedor.agregarProducto(this);
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
		if (!(obj instanceof Producto))
			return false;
		Producto other = (Producto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void actualizarPrecio(double monto) {
		Precio nuevoPrecio = new Precio(monto, this);
		this.setPrecio(nuevoPrecio);
	}
	
	public abstract Double getPrecioFinal();
	
}
