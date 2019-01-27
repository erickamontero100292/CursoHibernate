package com.curso.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.curso.domain.Avaluo;
import com.curso.domain.Avaluo_;
import com.curso.domain.Tramite;
import com.curso.domain.Tramite_;
import com.curso.idao.IAvaluoDao;
import com.curso.util.HibernateUtil;

public class AvaluoDaoImpl implements IAvaluoDao {

	@Override
	public void save(Avaluo avaluo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.save(avaluo);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();

		}

	}

	@Override
	public void update(Avaluo avaluo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(avaluo);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void saveOrUpdate(Avaluo avaluo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Avaluo avaluo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Avaluo loadAvaluo(Avaluo avaluo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Avaluo loadAvaluo(String descriptionAvaluo) {
		// criteria son consultas de tipo seguro
		// usan interfaces
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Avaluo avaluoResult = new Avaluo();

		try {
			tx = session.beginTransaction();
			// Fabrica para las piezas individuales de la criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Avaluo> criteria = builder.createQuery(Avaluo.class);
			// Definir el tipo de entidad que retorna la consulta
			Root<Avaluo> root = criteria.from(Avaluo.class);
			// Construyendo la consulta
			criteria.select(root);
			criteria.where(builder.equal(root.get(Avaluo_.lugarAval), descriptionAvaluo));
			 avaluoResult = session.createQuery(criteria).getSingleResult();
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return avaluoResult;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Avaluo> consultWithCreateQuery(String lugarAvaluo) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Avaluo> listAvaluo = null;
		try {
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			Query<Avaluo> query = session.createQuery("from Avaluo where lugarAval = :lugar");
			query.setParameter("lugar", lugarAvaluo);
			listAvaluo = query.getResultList();
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
		return listAvaluo;
	}

	@Override
	public List<Avaluo> consultWithCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Avaluo> consultWithCriteriaCustom(String descriptionAvaluo) {
		// TODO Auto-generated method stub
		return null;
	}

}
