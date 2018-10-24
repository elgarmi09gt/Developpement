package sn.ucad.master2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sn.ucad.master2.bo.Produit;
import sn.ucad.master2.dao.ICatalogueDaoRepository;

@RestController
public class CatalogueProduitRestService {
	@Autowired
	private ICatalogueDaoRepository catalogueRepository;
	
	@RequestMapping(value = "/listProduits",method=RequestMethod.GET)
	public List<Produit> listProduits(){
		return catalogueRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listProduits{ref}",method=RequestMethod.GET)
	public Produit getProduitByRef(@PathVariable("ref")String ref){
		return catalogueRepository.findOne(ref);
	}
	@RequestMapping(value = "/saveProduit",method=RequestMethod.POST)
	public Produit saveProduit(@RequestBody Produit produit){
		return catalogueRepository.save(produit);
	}
	@RequestMapping(value = "/editProduit",method=RequestMethod.PUT)
	public Produit updateProduit(@RequestBody Produit produit){
		return catalogueRepository.saveAndFlush(produit);
	}
	@RequestMapping(value = "/deleteProduit", method = RequestMethod.DELETE)
	public void deleteProduit(@RequestBody Produit produit){		
		catalogueRepository.delete(produit);
	}
	

}
