package br.com.totemti.condominio.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = createSessionFactory();
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	private static SessionFactory createSessionFactory() {
		try {
			Configuration configuration = new Configuration().configure();
			
			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			
			SessionFactory factory = configuration.buildSessionFactory(registry);
			
			return factory;
		} catch (Throwable ex) {
			System.err.println("A fábrica de sessões não pode ser criada." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

}
