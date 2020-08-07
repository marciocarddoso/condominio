package br.com.totemti.condominio.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.totemti.condominio.util.HibernateUtil;

public class BaseDAO<Entidade> {
	
	private Class<Entidade> classe;

	public BaseDAO() {
	this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();
			session.save(entidade);
			transaction.commit();

		} catch (RuntimeException error) {

			if (transaction != null) {
				transaction.rollback();
			}

			throw error;

		} finally {
			session.close();
		}

	}

}
