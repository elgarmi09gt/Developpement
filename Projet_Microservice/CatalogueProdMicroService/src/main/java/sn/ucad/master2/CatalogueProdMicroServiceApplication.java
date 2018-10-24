package sn.ucad.master2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sn.ucad.master2.bo.Produit;
import sn.ucad.master2.dao.ICatalogueDaoRepository;

@SpringBootApplication
public class CatalogueProdMicroServiceApplication implements CommandLineRunner{

	@Autowired
	ICatalogueDaoRepository myCatalogueRepository;
	public static void main(String[] args) {		
		SpringApplication.run(CatalogueProdMicroServiceApplication.class, args);	

	}
	
//	@Override
	public void run(String... arg0) throws Exception { 
		// TODO Auto-generated method stub
		myCatalogueRepository.save(new Produit("REF001","ORDINATEUR",350000,12));
		myCatalogueRepository.save(new Produit("REF002","ECRAN",75250,20));
		myCatalogueRepository.save(new Produit("REF003","SCANER",55333,32));
		myCatalogueRepository.save(new Produit("REF004","CLAVIER",433466,15));
		myCatalogueRepository.save(new Produit("REF005","IMPRIMANTE",65543,100));
		myCatalogueRepository.save(new Produit("REF006","SOURIS",1122,100));
		List<Produit> mesProduits = myCatalogueRepository.findAll();
		
		for(Produit prod:mesProduits){
			System.out.println(prod.getDesignation());
		}
	}
}
