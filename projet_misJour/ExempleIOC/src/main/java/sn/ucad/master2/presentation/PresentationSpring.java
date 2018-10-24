package sn.ucad.master2.presentation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import sn.ucad.master2.metier.IMetier;

public class PresentationSpring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context=
				new	ClassPathXmlApplicationContext(new String[]{"spring-ioc.xml"});
				IMetier metier=(IMetier) context.getBean("metier");
				System.out.println(metier.afficherTypeImpl("SPRING"));
	}

}
