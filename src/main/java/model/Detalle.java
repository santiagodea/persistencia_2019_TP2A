package model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity(name="Detalle")
@Table(name="detalle")
public class Detalle {

	// atributos
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO, generator="nativoDeBaseDeDatos")
		@GenericGenerator(name="nativoDeBaseDeDatos", strategy="native")
		private Integer id;
		
		@ManyToOne
		@JoinColumn(name="factura_id", foreignKey=@ForeignKey(name="factura_detalle_id_fk"))
		private Factura factura;
		
		@Transient //ONETOONE BIDIRECCIONAL
		private Producto producto;
		
		
		@Type(type="integer")
		private Integer cantidad;
		
		@Transient //ONETOONE BIDIRECCIONAL
		private Precio precioDeVenta;
		
		// constructores
		public Detalle() {
			super();
		}

		public Detalle(Factura factura, Producto producto, Integer cantidad){
			this.factura = factura;
			this.producto = producto;
			this.cantidad = cantidad;
			this.precioDeVenta = producto.getPrecio();
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Factura getFactura() {
			return factura;
		}

		public void setFactura(Factura factura) {
			this.factura = factura;
		}

		public Producto getProducto() {
			return producto;
		}

		public void setProducto(Producto producto) {
			this.producto = producto;
		}

		public Integer getCantidad() {
			return cantidad;
		}

		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}

		public Precio getPrecioDeVenta() {
			return precioDeVenta;
		}

		public void setPrecio(Precio precio) {
			this.precioDeVenta = precio;
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
			if (!(obj instanceof Detalle))
				return false;
			Detalle other = (Detalle) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		
}
