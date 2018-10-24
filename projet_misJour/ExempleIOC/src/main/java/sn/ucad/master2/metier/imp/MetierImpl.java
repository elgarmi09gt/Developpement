package sn.ucad.master2.metier.imp;

import sn.ucad.master2.dao.IDao;
import sn.ucad.master2.metier.IMetier;


public class MetierImpl implements IMetier {
	private IDao myDao;
	public String afficherTypeImpl(String appel) {
		// TODO Auto-generated method stub
		String myresult;
		if("STATIQUE".equals(appel))
			myresult = myDao.afficheResultat()+ "Injection par instanciation statique";
		else if("REFLEXION".equals(appel))
			myresult = myDao.afficheResultat()+ "Injection par instanciation dynamique par réflexion";
		else if("SPRING".equals(appel))
			myresult = myDao.afficheResultat()+ "Injection par Spring Framework";
		else
			myresult = "";

		return myresult;
	}
	public IDao getMyDao() {
		return myDao;
	}
	public void setMyDao(IDao myDao) {
		this.myDao = myDao;
	}

	
}
