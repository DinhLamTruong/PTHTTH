package RMIChuoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ServerNotActiveException;
import java.util.Scanner;

public class client {
	public static void main(String[] args) throws IOException, ServerNotActiveException {
		// set the security manager for the client
		// System.setSecurityManager(new RMISecurityManager());
		// get the remote object from the registry

		try {
			Registry reg = LocateRegistry.getRegistry(2002);
			String url = "//localhost/xyz";

			chuoi remoteObject = (chuoi) reg.lookup(url);
			String nhap_tu_bp = "";
			String luaChon = "";
			Scanner sc = new Scanner(System.in);
			do {
				System.out.println("Menu: ");
				System.out.println("1: nhap chuoi ");
				System.out.println("2: in chuoi ky tu");
				System.out.println("3: tong chuoi");
				System.out.println("Nhap exit de thoat");
				System.out.println("Moi ban chon: ");
				luaChon = sc.nextLine();
				switch (luaChon) {
				case "1":
					System.out.println("nhap chuoi muon dao nguoc in hoa:");
					BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
					nhap_tu_bp = inFromUser.readLine();
					break;
				case "2":
					String IH = remoteObject.InHoa(nhap_tu_bp);
					System.out.println("chuoi dao nguoc in hoa:\n" + remoteObject.ngichDao(IH));
					break;
				case "3":
					String chuoi[] = nhap_tu_bp.split("");
					System.out.println("so luong ky tu cua xau = " + remoteObject.sum(chuoi));
					break;
				case "exit":
					System.out.println("Chao tam biet. Hen gap lai");
					break;
				default:
					System.out.println("chon lai");
					break;

				}
			} while (!luaChon.equals("exit"));

		} catch (RemoteException exc) {
			System.out.println("Error in lookup: " + exc.toString());
		} catch (java.rmi.NotBoundException exc) {
			System.out.println("NotBound: " + exc.toString());
		}

	}

}
