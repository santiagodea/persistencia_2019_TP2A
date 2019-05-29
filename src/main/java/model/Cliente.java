package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity(name="Cliente")
@Table(name="cliente")
public class Cliente {
	// atributos
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="nativoDeBaseDeDatos")
	@GenericGenerator(name="nativoDeBaseDeDatos", strategy="native")
	private Integer id;
	
	@Column(length=255, nullable=false, unique=true)
	@Type(type="string")
	private String codigo;
	
	@Column(length=255, nullable=false)
	@Type(type="string")
	private String apellido;
	
	@Column(length=255, nullable=false)
	@Type(type="string")
	private String nombre;
	
	@OneToOne(mappedBy="cliente", cascade=CascadeType.ALL)
	private Cuenta cuenta;
	
	@OneToMany(mappedBy = "cliente", orphanRemoval=true, fetch=FetchType.EAGER)
	private List<Factura> facturas;

		// constructores
	public Cliente() {
		super();
	}

	public Cliente(String codigo, String apellido, String nombre, String nroCuenta) {
		this();
		this.codigo = codigo;
		this.apellido = apellido;
		this.nombre = nombre;
		this.cuenta = new Cuenta(nroCuenta, this);
		this.facturas = new ArrayList<>();
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
	// metodos obligatorios

		

//metodos de la clase
public void agregarFactura(Factura factura) {
	this.facturas.add(factura);
	factura.setCliente(this); //AGREGAR EN LA FACTURA EL CLIENTE;
}



}
