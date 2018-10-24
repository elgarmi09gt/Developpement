package sn.ucad.master2.dao;

import java.util.List;

import sn.ucad.master2.bo.Produit;

public interface ProduitDao {
	
	public void saveProduit(Produit produit);
	public Produit getProduit(String reference);
	public List<Produit> getProduits();
	public void deleteProduit(Produit prod);

}
