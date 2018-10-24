package sn.ucad.master2.presentation;

import java.io.*;import java.lang.reflect.*;
import java.util.Scanner; 
import sn.ucad.master2.dao.IDao;
import sn.ucad.master2.dao.impl.DaoImpl;
import sn.ucad.master2.metier.IMetier;
import sn.ucad.master2.metier.imp.MetierImpl;
public class Presentation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Couche présentation non fermer à la modification : Injection par instanciation statique
//		DaoImpl myDao=new DaoImpl();
//		MetierImpl myMetier=new MetierImpl();
//		myMetier.setMyDao(myDao);
//		System.out.println(myMetier.afficherTypeImpl("STATIQUE"));
		//......Injection par instanciation dynamique par réflexion
		try {			
			Scanner scanner=new Scanner(new File("config.text"));
			String daoClassname=scanner.next();
			String metierClassName=scanner.next();
			System.out.println("La classe Dao : "+daoClassname);
			System.out.println("La classe Metier : "+metierClassName);
			Class cdao=Class.forName(daoClassname);
			IDao dao= (IDao) cdao.newInstance();
			Class cmetier=Class.forName(metierClassName);
			IMetier metier=(IMetier) cmetier.newInstance();
			Method meth=cmetier.getMethod("setMyDao",new Class[]{IDao.class});
			meth.invoke(metier, new Object[]{dao});
			System.out.println(metier.afficherTypeImpl("REFLEXION"));
			} catch (Exception e) {
				e.printStackTrace(); 
			}
	}

}
