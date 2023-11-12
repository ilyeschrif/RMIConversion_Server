package rmiServer;

import rmiService.ConversionImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ConversionServer {

    private static final int PORT = 9999; // le port RMI sur lequel le serveur écoutera les connexions

    public static void main(String[] args) {
        try {

            // Création du registre RMI sur le port spécifié
            LocateRegistry.createRegistry(PORT);

            // Création de l'objet de conversion
            ConversionImpl ObjetConvertion = new ConversionImpl();

            // Liaison de l'objet de conversion au registre RMI
            Naming.rebind("rmi://localhost:" + PORT + "/ConversionObject", ObjetConvertion);


        } catch (MalformedURLException | RemoteException e) {

            // Gestion des exceptions lors de la création du registre ou de la liaison d'objet
            throw new RuntimeException(e.getMessage());
        }

    }

}
