package RMIChuoi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class chuoiIPM extends UnicastRemoteObject implements chuoi {
	public chuoiIPM() throws RemoteException {
		super();
	}

	@Override
	public String ngichDao(String a) throws RemoteException {
		StringBuffer reverse = new StringBuffer(a);
		return reverse.reverse().toString();
	}

	@Override
	public String InHoa(String x) throws RemoteException {
		return x.toUpperCase();
	}

	@Override
	public int sum(String[] s) throws RemoteException {
		int count = 0;
		int size = s.length;
		for (int i = 0; i < size; i++) {
			count += 1;
		}
		return count;
	}

}
