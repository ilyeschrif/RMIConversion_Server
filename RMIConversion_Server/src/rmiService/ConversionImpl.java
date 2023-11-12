package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConversionImpl extends UnicastRemoteObject implements IConversion {
    public ConversionImpl() throws RemoteException {
    }
    // Constructeur par défaut qui appelle le constructeur de la classe mère


    @Override
    public double convertirMontant(double mt) throws RemoteException {
        return mt*3.3;
    }
    // Implémentation de la méthode distante définie dans l'interface IConversion


}
