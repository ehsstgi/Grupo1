/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import br.com.mackenzie.fci.si.pi2.cr.business.CidadeFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.business.PassagemFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.business.UsuarioFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.business.ViagemFacadeRemote;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author leonardo.rafaeli
 */
public final class ServiceLocator {
    
    private static InitialContext ic;
    
    static {
        try {
            Properties props = new Properties();

            props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            props.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");

            ic = new InitialContext(props);
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static CidadeFacadeRemote getCidadeFacade() {
        try {
            return (CidadeFacadeRemote) ic.lookup("java:global/controle-rodoviario-ear-1.0-SNAPSHOT/controle-rodoviario-ejb-1.0-SNAPSHOT/CidadeFacade");
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static PassagemFacadeRemote getPassageFacade() {
        try {
            return (PassagemFacadeRemote) ic.lookup("java:global/controle-rodoviario-ear-1.0-SNAPSHOT/controle-rodoviario-ejb-1.0-SNAPSHOT/PassagemFacade");
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static ViagemFacadeRemote getViagemFacade() {
        try {
            return (ViagemFacadeRemote) ic.lookup("java:global/controle-rodoviario-ear-1.0-SNAPSHOT/controle-rodoviario-ejb-1.0-SNAPSHOT/ViagemFacade");
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static UsuarioFacadeRemote getUserFacade() {
        try {
            return (UsuarioFacadeRemote) ic.lookup("java:global/controle-rodoviario-ear-1.0-SNAPSHOT/controle-rodoviario-ejb-1.0-SNAPSHOT/UsuarioFacade");
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
