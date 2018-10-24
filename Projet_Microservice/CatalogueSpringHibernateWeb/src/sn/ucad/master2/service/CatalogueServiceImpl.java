package sn.ucad.master2.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sn.ucad.master2.bo.Produit;
import sn.ucad.master2.dao.ICatalogueDao;
@Service
@Transactional
public class CatalogueServiceImpl implements ICatalogueService {
	private ICatalogueDao myCatalogueDao;
	@Transactional(readOnly  = true)
	public void addProduit(Produit produit) {
		// TODO Auto-generated method stub
		myCatalogueDao.addProduit(produit);

	}
	@Transactional(readOnly  = true)
	public List<Produit> listProduits() {
		// TODO Auto-generated method stub
		return myCatalogueDao.listProduits();
	}

	@Transactional
	public Produit getProduitByRefference(String ref) {
		// TODO Auto-generated method stub
		return myCatalogueDao.getProduitByRefference(ref);
	}
	
	@Transactional
	public void updateProduit(Produit produit) {
		// TODO Auto-generated method stub
		myCatalogueDao.updateProduit(produit);
	}
	
	@Transactional
	public void deleteProduit(String ref) {
		// TODO Auto-generated method stub
		myCatalogueDao.deleteProduit(ref);
	}
	public ICatalogueDao getMyCatalogueDao() {
		return myCatalogueDao;
	}
	public void setMyCatalogueDao(ICatalogueDao myCatalogueDao) {
		this.myCatalogueDao = myCatalogueDao;
	}
	@Override
	public List<Produit> getProduitByDesignation(String designation) {
		// TODO Auto-generated method stub
		return myCatalogueDao.getProduitByDesignation(designation);
	}
	
	

}
