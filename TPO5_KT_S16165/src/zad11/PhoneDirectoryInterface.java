package zad11;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PhoneDirectoryInterface extends Remote {
	public String getNr(String name) throws RemoteException;
	public boolean addNr(String name, String number) throws RemoteException;
	public boolean replaceNr(String name, String number) throws RemoteException; 
}

