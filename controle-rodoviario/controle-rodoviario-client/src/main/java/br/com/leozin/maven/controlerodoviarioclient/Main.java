package br.com.leozin.maven.controlerodoviarioclient;

import br.com.mackenzie.fci.si.pi2.cr.business.CidadeFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.entity.Cidade;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Enterprise Application Client main class.
 *
 */
public class Main {
    
    @EJB
    private static CidadeFacadeRemote cidadeFacadeRemote;
    
    public static void main( String[] args ) {
        //List<Cidade> findAll = new Main().cidadeFacadeRemote.findAll();
        try {
            /*
            Properties jndiProps = new Properties();
            jndiProps.put("java.naming.factory.initial", "com.sun.enterprise.naming.impl.SerialInitContextFactory");
            jndiProps.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            jndiProps.put("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            jndiProps.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
            jndiProps.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            Context ctx = new InitialContext(jndiProps);
            CidadeFacadeRemote mySessionBean = (CidadeFacadeRemote) ctx.lookup("java:global/controle-rodoviario-ejb/CidadeFacadeRemote");
            */
            System.out.println("Initializing...");
            List<Cidade> cidades = cidadeFacadeRemote.findAll();
            for (Cidade cidade : cidades) {
                System.out.println(cidade.getNome());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
