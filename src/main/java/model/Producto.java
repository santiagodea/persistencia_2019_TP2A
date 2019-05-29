package model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity(name="Producto")
@Table(name="producto")
public class Producto {
	//ATRIBUTOS
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO, generator="nativoDeBaseDeDatos")
		@GenericGenerator(name="nativoDeBaseDeDatos", strategy="native")
		private Integer id;
		
		@Column(length=255, nullable=false)
		@Type(type="string")
		private String codigo;
		
		@Column(length=255, nullable=false)
		@Type(type="string")
		private String descripcion;
		
		@Transient
		private Precio precio;
		
		//@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
		@Transient
		private List<Proveedor> provedores;

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
			return provedores;
		}

		public void setProvedores(List<Proveedor> provedores) {
			this.provedores = provedores;
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
		
		
}
