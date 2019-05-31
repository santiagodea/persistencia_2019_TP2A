package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity(name="Factura")
@Table(name="factura")
public class Factura {

	// atributos
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO, generator="nativoDeBaseDeDatos")
		@GenericGenerator(name="nativoDeBaseDeDatos", strategy="native")
		private Integer id;
		
		@ManyToOne 
		@JoinColumn(foreignKey=@ForeignKey(name="cliente_id_fk"))
		private Cliente cliente;
			
		@Column(nullable=false)
		//@Type(type="date")
		private LocalDate fecha;
		
		
		@Column(nullable=false, unique=true)
		@Type(type="integer")
		private Integer numero;

		
		@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	    @JoinColumn(name = "factura_id")
		private List<Detalle> detalles;
		
		public Factura() {
			super();
		}

		public Factura(Cliente cliente, LocalDate fecha2, Integer numero) {
			this();
			this.cliente = cliente;
			this.fecha = fecha2;
			this.numero = numero;
			this.detalles = new ArrayList<>();
			cliente.agregarFactura(this);
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
			if (!(obj instanceof Factura))
				return false;
			Factura other = (Factura) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public LocalDate getFecha() {
			return fecha;
		}

		public void setFecha(LocalDate fecha) {
			this.fecha = fecha;
		}

		public Integer getNumero() {
			return numero;
		}

		public void setNumero(Integer numero) {
			this.numero = numero;
		}

		public List<Detalle> getDetalles() {
			return detalles;
		}

		public void setDetalles(List<Detalle> detalles) {
			this.detalles = detalles;
		}
		
		public void agregarDetalle(Detalle unDetalle) {
			this.detalles.add(unDetalle);
			//unDetalle.setFactura(this); 
		}
		

}
