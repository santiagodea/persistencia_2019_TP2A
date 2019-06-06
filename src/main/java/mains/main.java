package mains;

import java.time.LocalDate;

import org.hibernate.Session;

import hibernate.HibernateUtil;
import model.Cliente;
import model.Factura;
import model.Producto;
import model.Proveedor;

public class main {
	public static void main(String[] args) {
		LocalDate fecha = LocalDate.now();

		Cliente cliente = new Cliente("A", "Pratto", "Lucas", "AA001");
		Cliente cliente2 = new Cliente("B", "Martinez", "Pity", "AA002");
		Cliente cliente3 = new Cliente("C","Ponzio", "Leon", "AA003");

		Proveedor proveedor1 = new Proveedor("PR1", "proveedorDeBotines");
		Proveedor proveedor2 = new Proveedor("PR2", "proveedorDePelotas");
		Proveedor proveedor3 = new Proveedor("PR3", "proveedorDeCasacas");
		Proveedor proveedor4 = new Proveedor("PR4", "proveedorDeCasacasSuplentes");
		
		Producto producto1 = new Producto("P1","botin",proveedor1);
		Producto producto2 = new Producto("P2","pelota",proveedor2,980.50);
		Producto producto3 = new Producto("P3","camiseta",proveedor3,1250.99);
		
		producto3.addProveedor(proveedor4);
		
		producto1.actualizarPrecio(150.82);
		producto2.actualizarPrecio(1050.00);
		
		Factura factura = new Factura(cliente, fecha, 001);
		factura.agregarDetalle(producto1,15);
		factura.agregarDetalle(producto3,11);
		
		
		Factura factura2 = new Factura(cliente2, fecha, 002);
		factura2.agregarDetalle(producto3,7);
		factura2.agregarDetalle(producto2,5);
		factura2.agregarDetalle(producto1,9);
		
		Factura factura3 = new Factura(cliente3, fecha, 003);
		factura3.agregarDetalle(producto2,2);
		factura3.agregarDetalle(producto3,3);


		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.persist(cliente);
			session.persist(cliente2);
			session.persist(cliente3);
			
			session.persist(producto1);
			session.persist(producto2);
			session.persist(producto3);

			session.persist(proveedor1);
			session.persist(proveedor2);
			session.persist(proveedor3);

			session.persist(factura);		
			session.persist(factura2);			
			session.persist(factura3);


			

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
