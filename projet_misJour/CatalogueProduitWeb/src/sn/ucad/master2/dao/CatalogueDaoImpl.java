package sn.ucad.master2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.ucad.master2.bo.Produit;
import sn.ucad.master2.connection.SingletonConnection;

public class CatalogueDaoImpl implements ICatalogueDao {

	
	public void addProduit(Produit produit) {
		// TODO Auto-generated method stub
		Connection myConnection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = myConnection.prepareStatement
					("insert into PRODUIT(REF_PROD, DESIGNATION, PRIX, QUANTITE) values (?,?,?,?)");
			ps.setString(1, produit.getReference());
			ps.setString(2, produit.getDesignation());
			ps.setDouble(3, produit.getPrix());
			ps.setInt(4, produit.getQuantite());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Produit> listProduits() {
		// TODO Auto-generated method stub
		List<Produit> mesProduits = new ArrayList<Produit>();			
		Connection myConnection = SingletonConnection.getConnection();		
		try {
			PreparedStatement ps = myConnection.prepareStatement
					("select * from PRODUIT");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Produit myProd = new Produit();
				myProd.setReference(rs.getString("REF_PROD"));
				myProd.setDesignation(rs.getString("DESIGNATION"));
				myProd.setPrix(rs.getDouble("PRIX"));
				myProd.setQuantite(rs.getInt("QUANTITE"));
				mesProduits.add(myProd);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mesProduits;
	}

	public Produit getProduitByRefference(String ref) {
		// TODO Auto-generated method stub
		Produit myProd = null;
		Connection myConnection = SingletonConnection.getConnection();	
		try {
			PreparedStatement ps = myConnection.prepareStatement					
					("select * from PRODUIT where REF_PROD like ?");
			ps.setString(1, "%"+ref+"%");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){	
				myProd = new Produit();
				myProd.setReference(rs.getString("REF_PROD"));
				myProd.setDesignation(rs.getString("DESIGNATION"));
				myProd.setPrix(rs.getDouble("PRIX"));
				myProd.setQuantite(rs.getInt("QUANTITE"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(myProd == null) throw new RuntimeException("Produit "+ref+" inexistant");
		return myProd;
	}

	public void updateProduit(Produit produit) {
		// TODO Auto-generated method stub
		Connection myConnection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = myConnection.prepareStatement
					("update PRODUIT set DESIGNATION = ?, PRIX = ?, QUANTITE = ? WHERE REF_PROD = ?");
			ps.setString(1, produit.getDesignation());
			ps.setDouble(2, produit.getPrix());			
			ps.setInt(3, produit.getQuantite());
			ps.setString(4, produit.getReference());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteProduit(String ref) {
		// TODO Auto-generated method stub
		
		Connection myConnection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = myConnection.prepareStatement
					("delete from PRODUIT  where REF_PROD = ?");
			
			ps.setString(1, ref);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

}
