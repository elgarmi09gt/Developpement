package sn.ucad.master2.connection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;


public class EntityManagerBean {
	@PersistenceContext(unitName = "produit")
	EntityManager entityManager;
	public Session getHibernateSession(){
		return (Session)entityManager.getDelegate();
	}

}
