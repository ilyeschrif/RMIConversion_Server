package rmiClient;

import rmiService.IConversion;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ConversionClient {

    private static final int PORT = 9999;

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {

        try {

            // Recherche de l'objet distant
            IConversion stub = (IConversion) Naming.lookup("rmi://localhost:" + PORT + "/ConversionObject");

            // Demande à l'utilisateur d'entrer le montant à convertir
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrer le montant a convertir : ");
            double montant = scanner.nextDouble();

            // Affichage du résultat
            System.out.println(stub.convertirMontant(montant));

        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            // Gestion des exceptions liées à la recherche de l'objet distant ou à la communication RMI
            System.out.println(e.getMessage());
        }
    }
}
