package RMIChuoi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ServerNotActiveException;

public class server {
	public static void main(String args[]) throws ServerNotActiveException {
		try {
			// set the security manager
			// create a local instance of the object
			String url = "//localhost/xyz";

			chuoiIPM Server = new chuoiIPM();

			Registry reg = LocateRegistry.createRegistry(2002);

			// put the local instance in the registry
			reg.rebind(url, Server);
			System.out.println("Server running success...");

		} catch (RemoteException re) {
			System.out.println("Remote exception: " + re.toString());
		}
	}

}
