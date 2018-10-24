package sn.ucad.master2.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sn.ucad.master2.bo.Produit;
import sn.ucad.master2.service.ICatalogueService;

/**
 * Servlet implementation class ProduitServletControleur
 */
@Controller
public class ProduitSpringControleur{
	
	@Autowired
	private ICatalogueService myCatalogueService;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitSpringControleur() {
        super();
        // TODO Auto-generated constructor stub
        //myDaoCatalogue =  new CatalogueDaoImpl();
    }
    
    @RequestMapping(value = "/rechercher")
	public ModelAndView rechercherProduits(HttpServletRequest request) throws IOException {
    	String designation = request.getParameter("designation");
		List<Produit> mesProduits = myCatalogueService.getProduitByDesignation(designation);		
		ModelAndView model = new ModelAndView();
		model.addObject("produits", mesProduits);
		model.setViewName("listProduit");
		return model;
	}
    
    @RequestMapping(value = "/listProduits")
	public ModelAndView listProduits(ModelAndView model) throws IOException {
		List<Produit> mesProduits = myCatalogueService.listProduits();
		model.addObject("produits", mesProduits);
		model.setViewName("listProduit");
		return model;
	}

	@RequestMapping(value = "/addProduits", method = RequestMethod.GET)
	public ModelAndView newProduit(ModelAndView model) {
		Produit produit = new Produit();
		model.addObject("produit", produit);
		model.setViewName("addProduit");
		return model;
	}

	@RequestMapping(value = "/saveProduit", method = RequestMethod.POST)
	public ModelAndView saveProduit(@ModelAttribute Produit produit) {
		
		myCatalogueService.addProduit(produit);

		return new ModelAndView("redirect:/listProduits.mvc");
	}

	@RequestMapping(value = "/deleteProduit", method = RequestMethod.GET)
	public ModelAndView deleteProduit(HttpServletRequest request) {
		String reference = request.getParameter("reference");
		myCatalogueService.deleteProduit(reference);
		return new ModelAndView("redirect:/listProduits.mvc");
	}

	@RequestMapping(value = "/editProduit", method = RequestMethod.GET)
	public ModelAndView editProduit(HttpServletRequest request) {
		String reference = request.getParameter("reference");
		Produit produit = myCatalogueService.getProduitByRefference(reference);
		ModelAndView model = new ModelAndView("addProduit");
		model.addObject("produit", produit);

		return model;
	}

}
