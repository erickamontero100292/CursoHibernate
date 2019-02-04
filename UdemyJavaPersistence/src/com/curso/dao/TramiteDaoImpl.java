package com.curso.dao;

import com.curso.domain.Avaluo;
import com.curso.domain.Tramite;
import com.curso.domain.Tramite_;
import com.curso.idao.ITramiteDao;
import com.curso.util.HibernateUtil;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TramiteDaoImpl implements ITramiteDao {

	@Override
	public void save(Tramite tramite) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(tramite);
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
	public void update(Tramite tramite) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(tramite);
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
	public void saveOrUpdate(Tramite tramite) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Tramite tramiteSave = new Tramite();
		try {

			tx = session.beginTransaction();
			// Busco el tramite
			Tramite tramiteR = loadTramite(tramite);
			// Creo una instancia de tramite
			session.saveOrUpdate(tramite);

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
	public void delete(Tramite tramite) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(tramite);
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
	public Tramite loadTramite(Tramite tramite) {
		// criteria son consultas de tipo seguro
		// usan interfaces
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			// Fabrica para las piezas individuales de la criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
			// Definir el tipo de entidad que retorna la consulta
			Root<Tramite> root = criteria.from(Tramite.class);
			// Construyendo la consulta
			criteria.select(root);
			criteria.where(builder.equal(root.get(Tramite_.tipoTram), tramite.getTipoTram()));
			Tramite tramiteResult = session.createQuery(criteria).getSingleResult();
			session.getTransaction().commit();
			session.close();
			return tramite;

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return tramite;
	}

	@Override
	public Tramite loadTramite(String descriptionTramite) {
		// criteria son consultas de tipo seguro
		// usan interfaces
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Tramite tramiteResult = new Tramite();
		try {
			tx = session.beginTransaction();
			// Fabrica para las piezas individuales de la criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
			// Definir el tipo de entidad que retorna la consulta
			Root<Tramite> root = criteria.from(Tramite.class);
			// Construyendo la consulta
			criteria.select(root);
			criteria.where(builder.equal(root.get(Tramite_.tipoTram), descriptionTramite));
			tramiteResult = session.createQuery(criteria).getSingleResult();
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
		return tramiteResult;
	}

	@Override
	public List<Tramite> consultWithCreateQuery(String descriptionTramite) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Tramite> listTramite = null;
		try {
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			Query<Tramite> query = session.createQuery("from Tramite where tipoTram = :tipoTram");
			query.setParameter("tipoTram", descriptionTramite);
			listTramite = query.getResultList();
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
		return listTramite;

	}

	@Override
	public List<Tramite> consultWithCriteria() {
		// criteria son consultas de tipo seguro
		// usan interfaces
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Tramite> listTramite = null;
		try {
			session.beginTransaction();
			// Fabrica para las piezas individuales de la criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
//			 Definir el tipo de entidad que reronar la consulta
			Root<Tramite> root = criteria.from(Tramite.class);
			// Construyendo la consulta
			criteria.select(root);
			listTramite = session.createQuery(criteria).getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
		return listTramite;
	}

	@Override
	public List<Tramite> consultWithCriteriaCustom(String descriptionTramite) {
		// criteria son consultas de tipo seguro
		// usan interfaces
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Tramite> listTramite = null;
		try {
			session.beginTransaction();
			// Fabrica para las piezas individuales de la criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
			// Definir el tipo de entidad que retorna la consulta
			Root<Tramite> root = criteria.from(Tramite.class);
			// Construyendo la consulta
			criteria.select(root);
			criteria.where(builder.equal(root.get(Tramite_.tipoTram), descriptionTramite));
			listTramite = session.createQuery(criteria).getResultList();
			session.getTransaction().commit();
			session.close();
		} catch (

		Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
		return listTramite;
	}

	@Override
	public void loadTramite(int idTramite) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Tramite tramite = null;
		Tramite tramite2 = null;

		try {
			tx = session.beginTransaction();
			tramite = session.load(Tramite.class, idTramite);
			tx.commit();
			System.out.println(
					"El tramite : " + tramite.getIdTram() + " tiene lugar en: " + tramite.getAvaluo().getLugarAval());

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
