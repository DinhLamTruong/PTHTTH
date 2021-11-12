package RMIChuoi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface chuoi extends Remote {
	public int sum(String[] s) throws RemoteException;
	public String InHoa(String x) throws RemoteException;
	public String ngichDao(String a) throws RemoteException;

}
