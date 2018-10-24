package sn.ucad.master2.dao;

import java.util.List;

import javax.ejb.Remote;

import sn.ucad.master2.bo.Produit;
@Remote
public interface ICatalogueDao {
	
	public void addProduit(Produit produit);
	public List<Produit> listProduits();
	public Produit getProduitByRefference(String ref);
	public void updateProduit(Produit produit);
	public void deleteProduit(String ref);


}
