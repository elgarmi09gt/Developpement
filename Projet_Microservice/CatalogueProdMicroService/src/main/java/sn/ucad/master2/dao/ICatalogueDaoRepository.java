package sn.ucad.master2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.ucad.master2.bo.Produit;

public interface ICatalogueDaoRepository extends JpaRepository<Produit, String>{
	
	

}
