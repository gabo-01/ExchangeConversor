import fernando.Conversor.Changes.Change;
import fernando.Conversor.Changes.ChangeExtensor;
import fernando.Conversor.Consultas.Consultas;
import fernando.Conversor.Request.Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        String monedaOriginal;
        String monedaCambio;
        String cantidad;
        Request solicitud;
        Change change;
        ChangeExtensor cambio;
        List<ChangeExtensor> consultas=new ArrayList<>();

        while (true) {
            System.out.println("=====================================================================");
            System.out.println("Change Money INC");
            System.out.println("1.- Cambio Pesos mexicanos (MXN) a Dolares americanos (USD)");
            System.out.println("2.- Cambio Pesos mexicanos (MXN) a Euros (EUR)");
            System.out.println("3.- Cambio Pesos mexicanos (MXN) a Dolares Canadienses (CAD)");
            System.out.println("4.- Cambio Pesos mexicanos (MXN) a Francos Suizos (CHF)");
            System.out.println("5.- Cambio Pesos mexicanos (MXN) a Yen Japones (JPY)");
            System.out.println("0.- Salir");
            System.out.println("=====================================================================");
            System.out.print("Selecciona una opción: ");

            int opcion = teclado.nextInt();
            teclado.nextLine();

            if (opcion == 0) {
                System.out.println("Gracias por usar el conversor");
                break;
            }

            System.out.print("Ingresa la cantidad: ");
            cantidad = teclado.nextLine();

            switch (opcion) {
                case 1:
                    monedaOriginal = "mxn";
                    monedaCambio = "usd";
                    break;
                case 2:
                    monedaOriginal = "mxn";
                    monedaCambio = "eur";
                    break;
                case 3:
                    monedaOriginal = "mxn";
                    monedaCambio = "cad";
                    break;
                case 4:
                    monedaOriginal = "mxn";
                    monedaCambio = "chf";
                    break;
                case 5:
                    monedaOriginal = "mxn";
                    monedaCambio = "jpy";
                    break;
                default:
                    System.out.println("Esa conversión no está disponible");
                    Thread.sleep(5000);
                    continue;
            }

            solicitud = new Request();
            change = solicitud.Request(monedaOriginal, monedaCambio, cantidad);
            cambio = new ChangeExtensor(change);
            consultas.add(cambio);

            new Consultas(consultas);
            System.out.println(cambio);

            Thread.sleep(5000);
        }
    }
}