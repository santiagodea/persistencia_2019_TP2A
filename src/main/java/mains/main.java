package mains;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import hibernate.HibernateUtil;
import model.Alimento;
import model.Cliente;
import model.Congelado;
import model.Factura;
import model.Frio;
import model.General;
import model.Gondola;
import model.Producto;
import model.Proveedor;

public class main {
	
	private static Logger logger = LogManager.getLogger(main.class);

	public static void main(String[] args) {

		LocalDate fecha = LocalDate.now();

		Cliente cliente = new Cliente("A", "Pratto", "Lucas", "AA001");
		Cliente cliente2 = new Cliente("B", "Martinez", "Pity", "AA002");
		Cliente cliente3 = new Cliente("C","Ponzio", "Leon", "AA003");

		Proveedor proveedor1 = new Proveedor("PR1", "proveedorDeBotines");
		Proveedor proveedor2 = new Proveedor("PR2", "proveedorDePelotas");
		Proveedor proveedor3 = new Proveedor("PR3", "proveedorDeCasacas");
		Proveedor proveedor4 = new Proveedor("PR4", "proveedorDeCasacasSuplentes");
		Proveedor proveedor5 = new Proveedor("PR5", "proveedorDeFrios");
		Proveedor proveedor6 = new Proveedor("PR6", "proveedorDeCongelados");
		Proveedor proveedor7 = new Proveedor("PR7", "proveedorDeGondolas");
		
		Producto producto1 = new General("P1","botin",proveedor1,3);
		
		Producto producto2 = new General("P2","pelota",proveedor2,5);
		producto2.actualizarPrecio(700.50);
		Producto producto3 = new General("P3","camiseta",proveedor3,8);
		producto3.actualizarPrecio(1750);
		
		Producto producto4 = new Frio("P4","sanguche",proveedor5, 0, 15, LocalDate.now());
		producto4.actualizarPrecio(150);
		Producto producto5 = new Congelado("P5","energizante",proveedor6, LocalDate.now());
		producto5.actualizarPrecio(200.50);
		Producto producto6 = new Gondola("P6","agua",proveedor7,300.00, LocalDate.now());
		producto6.actualizarPrecio(75.80);

		
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
		factura3.agregarDetalle(producto4,10);
		factura3.agregarDetalle(producto5,20);
		factura3.agregarDetalle(producto6,30);


		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.persist(cliente);
			session.persist(cliente2);
			session.persist(cliente3);
			
			session.persist(producto1);
			session.persist(producto2);
			session.persist(producto3);
			session.persist(producto4);
			session.persist(producto5);
			session.persist(producto6);

			session.persist(proveedor1);
			session.persist(proveedor2);
			session.persist(proveedor3);

			session.persist(factura);		
			session.persist(factura2);			
			session.persist(factura3);


			session.getTransaction().commit();
			
			
			Query queryA = session.createQuery("from Producto");
			@SuppressWarnings("unchecked")
			List<Producto> productos = queryA.getResultList();
			productos.stream().forEach( p -> logger.error(p.getDescripcion()));
			
			Query queryB = session.createQuery("from Alimento");
			@SuppressWarnings("unchecked")
			List<Alimento> alimentos = queryB.getResultList();
			alimentos.stream().forEach( a -> logger.error(a.getDescripcion()));
			
			Query queryC = session.createQuery("from Gondola");
			@SuppressWarnings("unchecked")
			List<Gondola> gondolas = queryC.getResultList();
			gondolas.stream().forEach( g -> logger.error(g.getDescripcion()));
			
			Query queryD = session.createQuery(
					"from General "
					+ "where peso > 4"
					);
			
			
			@SuppressWarnings("unchecked")
			List<General> generales = queryD.getResultList();
			
			Stream<General> generalesFiltrados = generales.stream().filter(g -> g.getPrecioFinal() > 1500);
			
			generalesFiltrados.forEach( g -> logger.error(g.getDescripcion()));
	
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

		HibernateUtil.getSessionFactory().close();
	}
}
