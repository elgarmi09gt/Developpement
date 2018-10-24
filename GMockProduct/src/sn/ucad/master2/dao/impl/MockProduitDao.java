package sn.ucad.master2.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sn.ucad.master2.bo.Book;
import sn.ucad.master2.bo.Produit;
import sn.ucad.master2.dao.ProduitDao;

public class MockProduitDao implements ProduitDao {

	private HashMap<String, Produit> monMockProduit = new HashMap<String,Produit>();
	static private MockProduitDao mockProd;
	private MockProduitDao(){
		Book b = new Book();
		b.setAuthor("SAMB");
		b.setIsbn("ISBN_0001");
		b.setReference("Ref_001");
		b.setPrix(2000);
		this.saveProduit(b);
		
		b = new Book();
		b.setAuthor("DIOP");
		b.setIsbn("ISBN_0002");
		b.setReference("Ref_002");
		b.setPrix(3500);
		this.saveProduit(b);
		
	}
	
	public static MockProduitDao getInstance(){
		if(mockProd == null)
			mockProd = new MockProduitDao();
		return mockProd;
	}
	@Override
	public void saveProduit(Produit produit) {
		// TODO Auto-generated method stub
		String myKey = produit.getReference();
		monMockProduit.put(myKey, produit);

	}

	@Override
	public Produit getProduit(String reference) {
		// TODO Auto-generated method stub
		return monMockProduit.get(reference);
	}

	@Override
	public List<Produit> getProduits() {
		// TODO Auto-generated method stub
		return new ArrayList<Produit>(monMockProduit.values());
	}

	@Override
	public void deleteProduit(Produit prod) {
		// TODO Auto-generated method stub
		String myKey = prod.getReference();
		monMockProduit.remove(myKey);
	}

}
