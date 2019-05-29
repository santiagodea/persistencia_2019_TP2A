package mains;

import java.time.LocalDate;

import org.hibernate.Session;

import hibernate.HibernateUtil;
import model.Cliente;
import model.Factura;

public class main {
	public static void main(String[] args) {
		LocalDate fecha = LocalDate.now();
		
		Cliente cliente = new Cliente("A", "Pratto", "Lucas", "AA001");
			
		Factura factura = new Factura(cliente, fecha, 001);
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.persist(cliente);
			session.persist(factura);
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
