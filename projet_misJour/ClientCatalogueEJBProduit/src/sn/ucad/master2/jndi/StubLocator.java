package sn.ucad.master2.jndi;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

public class StubLocator {
	
	public static Object lookup(String ejbRemoteJndiName){
		
		try {
			/*location of JBoss JNDI Service provider the client will use. 
		    It should be URL string.*/
		    final String PROVIDER_URL = "jnp://localhost:1099";
		     
		    /*specifying the list of package prefixes to use when 
		    loading in URL context factories. colon separated*/
		    final String JNP_INTERFACES = 
		            "org.jboss.naming:org.jnp.interfaces";
		     
		    /*Factory that creates initial context objects. 
		    fully qualified class name. */
		    final String INITIAL_CONTEXT_FACTORY = 
		            "org.jnp.interfaces.NamingContextFactory";

			Properties prop = new Properties();                   
            prop.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            prop.put(Context.URL_PKG_PREFIXES, JNP_INTERFACES);
            prop.put(Context.PROVIDER_URL, PROVIDER_URL);

			Context ctx=new InitialContext(prop);
			System.out.println(ejbRemoteJndiName);
			return ctx.lookup(ejbRemoteJndiName);
		}catch (Exception e) { e.printStackTrace();
		
		}
		return null;
	}
}
