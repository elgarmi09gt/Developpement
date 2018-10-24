package sn.ucad.master2.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.ucad.master2.bo.Produit;
import sn.ucad.master2.dao.ProduitDao;
import sn.ucad.master2.dao.impl.MockProduitDao;

/**
 * Servlet implementation class FormEditProduitServletControleur
 */
public class FormEditProduitServletControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProduitDao myDaoProd ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormEditProduitServletControleur() {
        super();
        // TODO Auto-generated constructor stub
        myDaoProd =  MockProduitDao.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prodParam = (String) request.getParameter("prodParam");
		String refid = (String) request.getParameter("refid");
		String designation = (String) request.getParameter("designation");
		Double prix = Double.parseDouble(request.getParameter("prix")) ;
		Integer quantite = Integer.parseInt(request.getParameter("quantite"));
		if("ADD".equals(prodParam)){			
			Produit myProduit = new Produit(refid, designation, prix, quantite);
			myDaoProd.saveProduit(myProduit);
			//request.setAttribute("action", "listProduits");
			HttpSession session  = request.getSession();
			session.setAttribute("action", "listProduits");
			request.getRequestDispatcher("produitServletControleur").forward(request, response);			
		}else if("MOD".equals(prodParam)){			
			HttpSession session  = request.getSession();
			Produit myProduit = (Produit)session.getAttribute("myProd");
			myProduit.setDesignation(designation);
			myProduit.setPrix(prix);
			myProduit.setQuantite(quantite);
			myDaoProd.saveProduit(myProduit);
			session  = request.getSession();
			session.setAttribute("action", "listProduits");
			request.getRequestDispatcher("produitServletControleur").forward(request, response);
		}
	}

}
