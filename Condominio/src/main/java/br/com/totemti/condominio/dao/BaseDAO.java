package br.com.totemti.condominio.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
	
	public List<Entidade> listar() {
		Session session =  HibernateUtil.getSessionFactory().openSession();
		
		try {
			
			Criteria consulta = session.createCriteria(classe);
			
			List<Entidade> resultado = consulta.list();
			
			return resultado;
			
		} catch (RuntimeException error) {
			
			throw error;
			
		}finally {
			
			session.close();
		}
	}
	
	public Entidade buscar(Long codigo) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			
			Criteria consulta = session.createCriteria(classe);
			
			consulta.add(Restrictions.idEq(codigo));
			
			Entidade resultado = (Entidade) consulta.uniqueResult();
			
			return resultado;
		
		}catch (RuntimeException error) {
			throw error;
		
		}finally {
			
			session.close();
		}
	}
	
	public void excluir(Entidade entidade) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			session.delete(entidade);
			transaction.commit();
			
		} catch (RuntimeException error) {
			
			if (transaction != null) {
				transaction.rollback();
			}

			throw error;
		
		}finally {
			
			session.close();
		}

	}

}
