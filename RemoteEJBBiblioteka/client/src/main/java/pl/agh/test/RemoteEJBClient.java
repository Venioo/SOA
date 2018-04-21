package pl.agh.test;

import org.jboss.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

import static javax.naming.Context.INITIAL_CONTEXT_FACTORY;
import static javax.naming.Context.PROVIDER_URL;
import static javax.naming.Context.URL_PKG_PREFIXES;

public class RemoteEJBClient {
    private final static Logger logger = Logger.getLogger(RemoteEJBClient.class.getName());
    private final static Hashtable jndiProperties = new Hashtable();

    public static void main(String[] args) throws Exception {
        testRemoteEJB();
    }

    private static void testRemoteEJB() throws NamingException {
        jndiProperties.put(Context.URL_PKG_PREFIXES,
                "org.jboss.ejb.client.naming");
        String command = "";
        String host = "127.0.0.1";
        String port = "8080"; // Wildfly HTTP port
        Context remotingContext;
        remotingContext = createRemoteEjbContext(host, port);

        String infoUrl = "ejb:/ejb-remote-server/LibraryInfoBean!pl.agh.test.LibraryInfo";
        String bookerUrl = "ejb:/ejb-remote-server/LibraryBookerBean!pl.agh.test.LibraryBooker?stateful";

        LibraryInfo info;
        LibraryBooker booker;
        info = createEjbProxy(remotingContext, infoUrl, LibraryInfo.class);
        booker = createEjbProxy(remotingContext, bookerUrl, LibraryBooker.class);

        while (true) {
            command = IOUtils.readLine("> ");
            if (command.equals("borrow") || command.equals("reserve") || command.equals("return")) {
                int bookId = 0;
                try {
                    bookId = IOUtils.readInt("Wpisz id książki");
                } catch (NumberFormatException e1) {
                    logger.info("Niewłaściwy format!");
                    continue;
                }
                try {
                    if (command.equals("borrow"))
                        booker.borrowBook(bookId);
                    else if (command.equals("reserve"))
                        booker.reserveBook(bookId);
                    else
                        booker.returnBook(bookId);
                } catch (ArrayIndexOutOfBoundsException e) {
                    logger.info("Złe id");
                } catch (BookException e) {
                    logger.info(e.getMessage());
                    continue;
                }

            } else if (command.equals("list")) {
                logger.info(info.printBookList());
                continue;
            } else if (command.equals("end")) {
                logger.info("Żegnam");
                break;
            } else {
                logger.info("Nieznane polecenie" + command);
            }
        }
    }

    //    private static TheatreInfo lookupTheatreInfoEJB() throws NamingException {
//        final Context context = new InitialContext(jndiProperties);
//        return (TheatreInfo) context.lookup("ejb:/ejb-remote-server/TheatreInfoBean!TheatreInfo");
//    }
//
//    private static TheatreBooker lookupTheatreBookerEJB() throws
//            NamingException {
//        final Context context = new InitialContext(jndiProperties);
//
//        return (TheatreBooker) context.lookup("ejb:/ejb-remote-server/LibraryBookerBean!TheatreBooker");
//    }
    private static <T> T createEjbProxy(Context remotingContext, String ejbUrl, Class<T> ejbInterfaceClass)
            throws NamingException, ClassCastException {
        Object resolvedproxy = remotingContext.lookup(ejbUrl);
        return (T) resolvedproxy;
    }

    private static Context createRemoteEjbContext(String host, String port) throws NamingException {

        Hashtable<Object, Object> props = new Hashtable<>();

        props.put(INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        props.put(URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

        props.put("jboss.naming.client.ejb.context", false);
        props.put("org.jboss.ejb.client.scoped.context", true);

        props.put("endpoint.name", "client-endpoint");
        props.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", false);
        props.put("remote.connections", "default");
        props.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", false);

        props.put(PROVIDER_URL, "http-remoting://" + host + ":" + port);
        props.put("remote.connection.default.host", host);
        props.put("remote.connection.default.port", port);

        return new InitialContext(props);
    }
}
