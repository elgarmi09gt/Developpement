package sn.ucad.master2.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import sn.ucad.master2.bo.User;
import sn.ucad.master2.dao.IUserDao;
import sn.ucad.master2.dao.UserDao;

public class TestHibernate {

	public static void main(String[] args) {
		IUserDao dao = new UserDao();

		// Add new user
		User user = new User();
		user.setFirstName("Mass");
		user.setLastName("SAMB");
		try {
			Date dateNaissance = new SimpleDateFormat("dd-MM-yyyy").parse("10-12-2010");
			user.setDateNaissance(dateNaissance);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setEmail("mass.samb@gmail.com");
		dao.addUser(user);

		// Update user
		user.setEmail("mass.samb@updated.com");
		dao.updateUser(user);

		// Get all users
		for (User myUser : dao.getAllUsers()) {
			System.out.println("NOM : "+myUser.getLastName()+ " PRENOM : "+myUser.getFirstName()+" DATE NAISSANCE : "
		+myUser.getDateNaissance()+" EMAIL : "+myUser.getEmail());
		}

	}


}
