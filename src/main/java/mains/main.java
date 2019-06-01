package mains;

import java.time.LocalDate;

import org.hibernate.Session;

import hibernate.HibernateUtil;
import model.Cliente;
import model.Detalle;
import model.Factura;
import model.Producto;
import model.Proveedor;

public class main {
	public static void main(String[] args) {
		LocalDate fecha = LocalDate.now();

		Cliente cliente = new Cliente("A", "Pratto", "Lucas", "AA001");
		Cliente cliente2 = new Cliente("B", "Martinez", "Pity", "AA002");
		Cliente cliente3 = new Cliente("C","Ponzio", "Leon", "AA003");

		Producto producto1 = new Producto("P1","botin",760.00);
		Producto producto2 = new Producto("P2","pelota",980.50);
		Producto producto3 = new Producto("P3","camiseta",1250.99);

		Proveedor proveedor1 = new Proveedor("PR1", "proveedorDeBotines");
		Proveedor proveedor2 = new Proveedor("PR2", "proveedorDePelotas");
		Proveedor proveedor3 = new Proveedor("PR3", "proveedorDeCasacas");
		
		producto1.addProveedor(proveedor1);
		proveedor1.addProducto(producto1);
		producto2.addProveedor(proveedor2);
		proveedor2.addProducto(producto2);
		producto3.addProveedor(proveedor3);
		proveedor3.addProducto(producto3);
		
		
		Factura factura = new Factura(cliente, fecha, 001);
		Detalle detalle1 = new Detalle(factura, producto1, 15);
		Detalle detalle2 = new Detalle(factura, producto3, 11);
		
		
		Factura factura2 = new Factura(cliente2, fecha, 002);
		Detalle detalle3 = new Detalle(factura2, producto3, 7);
		Detalle detalle4 = new Detalle(factura2, producto2, 5);
		Detalle detalle5 = new Detalle(factura2, producto1, 9);
		
		Factura factura3 = new Factura(cliente3, fecha, 003);
		Detalle detalle6 = new Detalle(factura3, producto2, 2);
		Detalle detalle7 = new Detalle(factura3, producto3, 3);


		


		

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
			session.persist(detalle1);
			session.persist(detalle2);
			
			session.persist(factura2);
			session.persist(detalle3);
			session.persist(detalle4);
			session.persist(detalle5);
			
			session.persist(factura3);
			session.persist(detalle7);
			session.persist(detalle6);


			

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
