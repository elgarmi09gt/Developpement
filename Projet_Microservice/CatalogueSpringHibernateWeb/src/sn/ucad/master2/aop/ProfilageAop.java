package sn.ucad.master2.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ProfilageAop {
	static final Logger logger = Logger.getLogger(ProfilageAop.class);
	
	@Around("execution(* sn.ucad.master2.service.*.*(..))")
	public Object profilingMethode(ProceedingJoinPoint jointPoint) throws Throwable {
		
		long debut = System.currentTimeMillis();
		logger.info("Appelle de la fonction .....");
		System.out.println("Appelle de la fonction .....");
		Object sortie = jointPoint.proceed();
		logger.info("Fonction execute avec succees.....");
		System.out.println("Fonction execute avec succees .....");
		long tempsMis = System.currentTimeMillis() - debut;
		logger.info("Temps d'execution de la fonction :"+ tempsMis+ "milliseconds");
		System.out.println("Temps d'execution de la fonction :"+ tempsMis+ "milliseconds");
		return sortie;
	}

}
