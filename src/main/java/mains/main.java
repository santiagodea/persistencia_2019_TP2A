package mains;

import java.time.LocalDate;

import org.hibernate.Session;

import hibernate.HibernateUtil;
import model.Cliente;
import model.Detalle;
import model.Factura;
import model.Precio;
import model.Producto;
import model.Proveedor;

public class main {
	public static void main(String[] args) {
		LocalDate fecha = LocalDate.now();
		
		Cliente cliente = new Cliente("A", "Pratto", "Lucas", "AA001");
		Cliente cliente2 = new Cliente("A", "Martinez", "Pity", "AA002");
		Cliente cliente3 = new Cliente("A", "Ponzio", "Leon", "AA003");
		
		Factura factura = new Factura(cliente, fecha, 001);
		Factura factura2 = new Factura(cliente2, fecha, 002);
		Factura factura3 = new Factura(cliente3, fecha, 003);
		
		Detalle detalle1 = new Detalle();
		Detalle detalle2 = new Detalle();
		Detalle detalle3 = new Detalle();
		
		Precio precio1 = new Precio();
		Precio precio2 = new Precio();
		Precio precio3 = new Precio();
		
		Producto producto1 = new Producto();
		Producto producto2 = new Producto();
		Producto producto3 = new Producto();
		
		Proveedor provedor1 = new Proveedor();
		Proveedor provedor2 = new Proveedor();
		Proveedor provedor3 = new Proveedor();
		
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.persist(cliente);
			session.persist(cliente2);
			session.persist(cliente3);
			
			session.persist(factura);
			session.persist(factura2);
			session.persist(factura3);
			
			session.persist(detalle1);
			session.persist(detalle2);
			session.persist(detalle3);
			
			session.persist(precio1);
			session.persist(precio2);
			session.persist(precio3);
			
			session.persist(producto1);
			session.persist(producto2);
			session.persist(producto3);
			
			session.persist(provedor1);
			session.persist(provedor2);
			session.persist(provedor3);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

		HibernateUtil.getSessionFactory().close();
	}
	}
