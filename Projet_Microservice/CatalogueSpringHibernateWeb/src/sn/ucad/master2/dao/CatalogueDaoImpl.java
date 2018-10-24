package sn.ucad.master2.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import sn.ucad.master2.bo.Produit;
@Component
public class CatalogueDaoImpl extends HibernateDaoSupport implements ICatalogueDao {
	
	public void addProduit(Produit produit) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(produit);		
		}

	public List<Produit> listProduits() {
		// TODO Auto-generated method stub		
		List<Produit> mesProduits = new ArrayList<Produit>();					
		mesProduits = (List<Produit>)getHibernateTemplate().find("from Produit");
		return mesProduits;
	}

	public Produit getProduitByRefference(String ref) {
		// TODO Auto-generated method stub
		Produit myProd =(Produit)getHibernateTemplate().get(Produit.class, ref);
		return myProd;
	}

	public void updateProduit(Produit produit) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().update(produit);	
	}

	public void deleteProduit(String ref) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(getProduitByRefference(ref));	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getProduitByDesignation(String designation) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Produit.class); 
		criteria.add(Restrictions.ilike("designation", designation));
		List<Produit> mesProduits = (List<Produit>) getHibernateTemplate().findByCriteria(criteria);
		return mesProduits;
	}
		

}
