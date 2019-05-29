package model;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity(name="Precio")
@Table(name="precio")
public class Precio {
	//ATRIBUTOS
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO, generator="nativoDeBaseDeDatos")
		@GenericGenerator(name="nativoDeBaseDeDatos", strategy="native")
		private Integer id;
		
		@Column(nullable=false, unique=true)
		@Type(type="decimal")
		private BigDecimal monto;
		
		@Column(nullable=false)
		//@Type(type="date")
		private LocalDate fecha;
		
		@Transient
		private Producto producto;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public BigDecimal getMonto() {
			return monto;
		}

		public void setMonto(BigDecimal monto) {
			this.monto = monto;
		}

		public LocalDate getFecha() {
			return fecha;
		}

		public void setFecha(LocalDate fecha) {
			this.fecha = fecha;
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
		

	
}
