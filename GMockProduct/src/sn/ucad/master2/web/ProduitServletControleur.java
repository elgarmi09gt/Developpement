package sn.ucad.master2.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.ucad.master2.bo.Produit;
import sn.ucad.master2.dao.ProduitDao;
import sn.ucad.master2.dao.impl.MockProduitDao;

/**
 * Servlet implementation class ProduitServletControleur
 */
public class ProduitServletControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProduitDao myDaoProd;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServletControleur() {
        super();
        // TODO Auto-generated constructor stub
        myDaoProd = MockProduitDao.getInstance();
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
		String action = request.getParameter("action");
		HttpSession session  = request.getSession();
		if(action == null)
			action = (String)session.getAttribute("action");
		
		if(action!=null && "listProduits".equals(action)){
			List<Produit>mesProduits = myDaoProd.getProduits();
			request.setAttribute("produits", mesProduits);				
	        request.getRequestDispatcher("WEB-INF/jsp/listProduit.jsp").forward(request, response);
		}else if(action!=null && "deleteProduits".equals(action)){	
			String prodRef = request.getParameter("prodRef");
			Produit myProd = myDaoProd.getProduit(prodRef);
			myDaoProd.deleteProduit(myProd);
			List<Produit>mesProduits = myDaoProd.getProduits();
			request.setAttribute("produits", mesProduits);	
			request.getRequestDispatcher("WEB-INF/jsp/listProduit.jsp").forward(request, response);
			
		}else if(action!=null && "addProduits".equals(action)){	
			request.getRequestDispatcher("WEB-INF/jsp/addProduit.jsp").forward(request, response);			
		}else if(action!=null && "editProduits".equals(action)){	
			String prodRef = request.getParameter("prodRef");			
			Produit myProd = myDaoProd.getProduit(prodRef);
			session  = request.getSession();
			session.setAttribute("myProd", myProd);	
			request.getRequestDispatcher("WEB-INF/jsp/modProduit.jsp").forward(request, response);			
		}
		
	}

}
